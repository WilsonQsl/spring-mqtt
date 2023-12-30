package com.sun.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sun.demo.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;


/**
 * @author qiansl
 * @version 1.0
 * @date 2023/8/29 21:15
 * @description 消息订阅数据处理
 */
@Service
public class MqttServiceImpl implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        //String topic = (String) message.getHeaders().get("mqtt_receivedTopic");
        String payload = (String) message.getPayload();
        DeviceDTO entity = JSONObject.parseObject(payload, DeviceDTO.class);
        if (entity != null) {
            //不是心跳数据
            if (!entity.getTypes().equals("heartbeat")) {
                //处理数据入库
                System.out.println("上报数据：" + entity);
            }
        }
    }
}


