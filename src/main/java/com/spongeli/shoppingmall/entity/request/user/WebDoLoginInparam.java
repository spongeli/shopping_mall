package com.spongeli.shoppingmall.entity.request.user;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/4/17 11:02
 **/
public class WebDoLoginInparam {

    private String nickname;

    private String userpic;

    private String phone;

    private String password;

    private String token;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
