package com.spongeli.shoppingmall.shopping_mall;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.cont.SystemConstant;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/14 17:01
 **/
public class Test111 {

    @Test
    public void teeee() throws FileNotFoundException {
        uploadFile("分类.png",new FileInputStream(new File("D:\\素材\\lc\\lc\\分类.png")));
    }

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
//            ftp.makeDirectory(FtpConstamt.FTP_BASEPATH + "/" + imgFilePath);
//            ftp.changeWorkingDirectory(FtpConstamt.FTP_BASEPATH + "/" + imgFilePath);
            ftp.enterLocalPassiveMode();
            boolean file = ftp.storeFile(imgName, input);
            System.out.println(file);
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
}
