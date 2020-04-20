package com.spongeli.shoppingmall.service.commonservice.impl;

import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.util.ServiceUtil;
import com.spongeli.shoppingmall.service.commonservice.AliSmsService;
import com.spongeli.shoppingmall.service.commonservice.CommonService;
import com.spongeli.shoppingmall.service.commonservice.MailService;
import com.spongeli.shoppingmall.utils.MatchUtil;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.datetime.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Service
public class CommonServiceImpl extends BaseService implements CommonService {

    private static final Logger logger = LogManager.getLogger(CommonServiceImpl.class);

    static final String REDIS_INC_KEY = "user_id_key";

    @Autowired
    private AliSmsService aliSmsService;
    @Autowired
    private MailService mailService;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 验证码验证
     *
     * @param request
     * @param verify
     * @return
     */
    @Override
    public boolean checkVerifyCode(HttpServletRequest request, String verify) {
        Object tempVerify = redisUtil.get(ServiceUtil.getIpAddr(request));
        if (Objects.isNull(tempVerify) || !StringUtils.isEquals(verify, String.valueOf(tempVerify))) {
            throw new SystemException("验证码不正确");
        }
        return true;
    }

    @Override
    public void sendVerify(String username, HttpServletRequest request) {
        String addrIp = ServiceUtil.getIpAddr(request);

        // 验证是否可以发送验证码
        Object countNum = redisUtil.get(addrIp + "_count");
        int count = Objects.isNull(countNum) ? 0 : Integer.valueOf(String.valueOf(countNum));
        if (!checkLegal(count)) {
            throw new SystemException("2小时内只容许最多发送5条验证码");
        }

        String code = getVerifyCode();
        boolean flag = false;
        if (MatchUtil.isMobileNO(username)) {
            // 手机号
//            flag = aliSmsService.sendAliSmsService(username, code);
            flag = true;
        } else if (MatchUtil.isEmail(username)) {
            // email
//            flag = mailService.sendEmailByVerify(username, code);
            flag = true;
        } else {
            throw new SystemException("输入的信息不合法");
        }

        // 验证码没发出去
        if (!flag) {
            throw new SystemException("服务器异常");
        }

        // 保存到redis 临时验证码
        redisUtil.set(addrIp, code, 60 * 15);

        // 防止刷量(保存两小时)
        redisUtil.set(addrIp + "_count", count + 1, 60 * 120);

        logger.info("code:{}", code);
    }

    /**
     * 生成的全局唯一号
     *
     * @param prefix
     * @return
     */
    @Override
    public String genOrderNoByRedis(String prefix) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(REDIS_INC_KEY, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement() + 1;
        Date today = new Date();
        Calendar cs = Calendar.getInstance();
        cs.setTime(today);
        //凌晨过期
        cs.add(Calendar.DAY_OF_MONTH, 1);
        cs.set(Calendar.HOUR_OF_DAY, 0);
        cs.set(Calendar.MINUTE, 0);
        cs.set(Calendar.SECOND, 0);
        //设置第二天的凌晨00：00为失效期
        entityIdCounter.expireAt(cs.getTime());
        System.out.println(FastDateFormat.getInstance("yyyyMMddHHmmss").format(cs.getTime()));
        //补四位,缺失的位置用0补位
        String importantKey = increment.toString();
        if (importantKey.length() < 5) {
            importantKey = "0000".substring(0, 5 - importantKey.length()) + importantKey;
        }
        //
        String orderNO = String.format("%s%s%s", prefix, FastDateFormat.getInstance("yyyyMMdd").format(today), importantKey);
        return orderNO;
    }

    /**
     * 验证合法行
     *
     * @param count
     * @return
     */
    private boolean checkLegal(int count) {
        return Integer.valueOf(count) <= 4;
    }

    /**
     * 获取随机的六位数
     *
     * @return
     */
    private String getVerifyCode() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        return result;
    }
}
