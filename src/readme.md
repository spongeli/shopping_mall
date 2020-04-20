**电商项目**

## 短信模块

采用阿里云的短信服务

1.开通阿里云短信服务，获取相关参数

2.找到项目

~~~java
com.spongeli.shoppingmall.common.project.SmsConstant
修改相关参数：
ACCESSKEYID，ACCESSKEYSECRET，SIGNNAME，TEMPLATECODE
~~~

3.调用封装好的接口

~~~java
com.spongeli.shoppingmall.service.commonservice.AliSmsService.sendAliSmsService
~~~

## 邮件模块

以qq邮件为例

1.开通qq邮件发送功能

~~~java
https://segmentfault.com/a/1190000013092374
~~~

2.配置参数

~~~reStructuredText
1.shopping_mall\src\main\resources\application.properties
在该文件中找到
spring.mail.host=smtp.qq.com    //qq有限的服务
spring.mail.username=2282259433@qq.com  // 
spring.mail.password=owuexcckqvoldjdd   // 密钥，在第一步中获取
mail.fromMail.addr=2282259433@qq.com   
~~~

3.调用

~~~java
com.spongeli.shoppingmall.service.commonservice.MailService
~~~





