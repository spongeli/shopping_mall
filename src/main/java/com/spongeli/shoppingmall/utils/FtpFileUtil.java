package com.spongeli.shoppingmall.utils;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.SystemConstant;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author spongeli
 * @Date 2019/10/15 10:26
 **/
public class FtpFileUtil {
    private static Logger logger = LoggerFactory.getLogger(FtpFileUtil.class);

    public static String uploadFile(String originFileName, InputStream input) {
        String imgFilePath = null;
        String imgName = null;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {

            ftp.setConnectTimeout(2000);

            int reply;
            // 链接
            ftp.connect(SystemConstant.FTP_ADDRESS, SystemConstant.FTP_PORT);// 连接FTP服务器
            ftp.login(SystemConstant.FTP_USERNAME, SystemConstant.FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return "";
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            imgFilePath = getImgFilePath();
//            ftp.makeDirectory(FtpConstamt.FTP_BASEPATH + "/" + imgFilePath);
//            ftp.changeWorkingDirectory(FtpConstamt.FTP_BASEPATH + "/" + imgFilePath);
            imgName = getImgName(originFileName);
            ftp.enterLocalPassiveMode();
            boolean file = ftp.storeFile(imgName, input);
            logger.info("file=" + file);
            input.close();
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    throw new SystemException("上传文件【" + originFileName + "】失败!");
                }
            }

        }
        return imgName;
    }

//    public static boolean deleteFile(String fileName) {
//        FTPClient ftp = new FTPClient();
//        ftp.setControlEncoding("UTF-8");
//        boolean flag = false;
//        try {
//            int reply;
//            // 链接
//            ftp.connect(FtpConstamt.FTP_ADDRESS, FtpConstamt.FTP_PORT);// 连接FTP服务器
//            ftp.login(FtpConstamt.FTP_USERNAME, FtpConstamt.FTP_PASSWORD);// 登录
//            reply = ftp.getReplyCode();
//            if (!FTPReply.isPositiveCompletion(reply)) {
//                ftp.disconnect();
//                return false;
//            }
//            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
//            ftp.changeWorkingDirectory(FtpConstamt.FTP_BASEPATH + "/" + fileName);
//            FTPFile[] ftpFiles = ftp.listFiles();
//            ftp.enterLocalPassiveMode();
////            删除文件夹下的所有文件
//            for (int i = 0; i < ftpFiles.length; i++) {
//                ftp.deleteFile(ftpFiles[i].getName());
//            }
////            删除文件夹
//            ftp.changeWorkingDirectory(FtpConstamt.FTP_BASEPATH);
//            ftp.removeDirectory(fileName);
//            ftp.logout();
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (ftp.isConnected()) {
//                try {
//                    ftp.disconnect();
//                } catch (IOException ioe) {
//                }
//            }
//        }
//        return flag;
//    }

    /**
     * 文件名字
     *
     * @param originFileName
     * @return
     */
    public static String getImgName(String originFileName) {
        String suffix = originFileName.substring(originFileName.indexOf(".") + 1);
        UUID fileName = UUID.randomUUID();
        return fileName + "." + suffix;
    }


    public static String getImgFilePath() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}