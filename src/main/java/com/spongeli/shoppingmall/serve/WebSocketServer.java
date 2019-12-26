package com.spongeli.shoppingmall.serve;

import com.spongeli.shoppingmall.service.commonservice.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: lichao
 * @Date: 20190731
 * @Description: websocket 服务类
 */

/**
 * @ServerEndpoint 这个注解有什么作用？
 * <p>
 * 这个注解用于标识作用在类上，它的主要功能是把当前类标识成一个WebSocket的服务端
 * 注解的值用户客户端连接访问的URL地址
 */

@Component
@ServerEndpoint(value = "/websocket/{userGroup}/{ip}")
public class WebSocketServer {
    Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private static final String SOCKET_LIST = "List";
    private static HelloService helloService;
    private static final String IMG_URL = "https://lonyw.com/img/weixin.png";

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setMessageDialogueService(HelloService service) {
        WebSocketServer.helloService = service;
    }

    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();


    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "userGroup") String userGroup, @PathParam(value = "ip") String ip) {
        this.session = session;
        webSocketSet.put(userGroup, this);
        logger.info("用户：【" + userGroup + "】[WebSocket] 连接成功，当前连接人数为：" + webSocketSet.size());
    }

    @OnClose
    public void OnClose() {
        System.out.println(this);
        String userGroup = this.session.getPathParameters().get("userGroup");
        webSocketSet.remove(userGroup);
        logger.info("[WebSocket] 退出成功，当前连接人数为：=" + webSocketSet.size());
    }

    @OnMessage
    public void OnMessage(String message) {
        logger.info("[WebSocket] 收到消息：" + message);
        //判断是否需要指定发送，具体规则自定义

        // 心跳检测
        if ("ping".equals(message)) {
            return;
        }
    }

    /**
     * 群发
     *
     * @param message
     */
    public void GroupSending(String message) {
        for (String name : webSocketSet.keySet()) {
            try {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定发送
     *
     * @param name
     * @param message
     */
    public boolean AppointSending(String name, String message) {
        try {
            WebSocketServer server = webSocketSet.get(name);

            if (server != null) {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
                logger.info("发送到服务【" + name + "】成功,信息：{}", message);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("获取不到服务【" + name + "】");
        return false;
    }
}