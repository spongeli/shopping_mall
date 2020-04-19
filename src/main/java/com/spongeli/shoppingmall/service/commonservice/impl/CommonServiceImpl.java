package com.spongeli.shoppingmall.service.commonservice.impl;

import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.util.ServiceUtil;
import com.spongeli.shoppingmall.service.commonservice.CommonService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CommonServiceImpl extends BaseService implements CommonService {

    /**
     * 验证码验证
     * @param request
     * @param verify
     * @return
     */
    @Override
    public boolean checkVerifyCode(HttpServletRequest request, String verify) {
        String tempVerify = redisUtil.get(ServiceUtil.getIpAddr(request)) + "";
        if(StringUtils.isEmpty(tempVerify) || !StringUtils.isEquals(verify,tempVerify)){
            return false;
        }
        return false;
    }
}
