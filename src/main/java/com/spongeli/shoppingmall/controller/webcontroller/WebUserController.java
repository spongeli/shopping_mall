package com.spongeli.shoppingmall.controller.webcontroller;

import com.spongeli.shoppingmall.common.system.BaseController;
import com.spongeli.shoppingmall.common.system.CommonResponse;
import com.spongeli.shoppingmall.entity.request.user.web.DoLoginPwdInparam;
import com.spongeli.shoppingmall.entity.request.user.web.DoLoginVerifyInparam;
import com.spongeli.shoppingmall.entity.request.user.web.DoRegisterInparam;
import com.spongeli.shoppingmall.entity.request.user.web.WebDoLoginInparam;
import com.spongeli.shoppingmall.service.commonservice.CommonService;
import com.spongeli.shoppingmall.service.web.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 10:56
 **/
@RestController
@RequestMapping("/web/user")
public class WebUserController extends BaseController {
    @Autowired
    private WebUserService service;
    @Autowired
    private CommonService commonService;

    @PostMapping("/wxlogin")
    public CommonResponse wxlogin(@RequestBody WebDoLoginInparam inparam) {
        return instanceSuccess(service.wxlogin(inparam));
    }

    /**
     * 获取验证码
     *
     * @param username
     * @param request
     * @return
     */
    @GetMapping("/send_verify")
    public CommonResponse sendVerify(@RequestParam("username") String username, HttpServletRequest request) {
        commonService.sendVerify(username, request);
        return instanceSuccess();
    }

    /**
     * 用户注册
     *
     * @param inparam
     * @return
     */
    @PostMapping("/doRegister")
    public CommonResponse doRegister(@RequestBody @Valid DoRegisterInparam inparam) {
        service.doRegister(inparam);
        return instanceSuccess();
    }

    /**
     * 密码登陆
     * @param inparam
     * @return
     */
    @PostMapping("/doLoginPwd")
    public CommonResponse doLoginByPwd(@RequestBody @Valid DoLoginPwdInparam inparam) {
        return instanceSuccess(service.doLoginByPwd(inparam));
    }

    @PostMapping("/doLoginVerify")
    public CommonResponse doLoginVerify(@RequestBody @Valid DoLoginVerifyInparam inparam){
        return instanceSuccess(service.doLoginVerify(inparam));
    }
}
