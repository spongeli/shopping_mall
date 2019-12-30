package com.spongeli.shoppingmall.shopping_mall;

import com.spongeli.shoppingmall.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class ShoppingMallApplicationTests {
    private static String md5key = "mall-login";
    @Test
    void contextLoads() {
        System.out.println(MD5Util.getMD5(md5key + "-" + "123456"));
    }

}
