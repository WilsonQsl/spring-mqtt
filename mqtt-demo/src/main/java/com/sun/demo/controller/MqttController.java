package com.sun.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sun.demo.service.IMqttService;
import com.sun.demo.vo.ApiResult;
import com.sun.demo.dto.DeviceDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author qiansl
 * @version 1.0
 * @date 2023/8/29 21:15
 * @description 测试接口
 */
@RestController
@RequestMapping("/mqtt")
public class MqttController {


    @Resource
    IMqttService mqttService;

    private final static String SEND_TOPIC_PREFIX = "receive_iot_topic/";


    @PostMapping("/sendToTopic")
    public ApiResult sendToTopic(String topic, String payload) {
        /**
         * 想接收方方法消息-主题：receive_iot_topic/#,receive_chat_topic/#
         */
        mqttService.sendToMqtt(topic,payload);
        System.out.println("发送成功=>" + "主题：" + topic + "  载荷:" + payload);
        return ApiResult.success(null, "发送成功");
    }

    /**
     * 设备经纬度上报
     * @param dto 设备信息
     * @return
     */
    @PostMapping("/sync")
    public ApiResult controlCommand(@RequestBody DeviceDTO dto) {
        String deviceId = dto.getDeviceId();
        // 前缀 + 设备号
        String topic = SEND_TOPIC_PREFIX + deviceId;
        String payload= JSON.toJSONString(dto);
        mqttService.sendToMqtt(topic,payload);
        return ApiResult.success(null, "发送成功");
    }

    @PostMapping("/sendToQosTopic")
    public ApiResult sendToQosTopic(String topic, String payload) {
        /**
         * 想接收方方法消息-主题：receive_iot_topic/#,receive_chat_topic/#
         */
        mqttService.sendToMqtt(topic,1,payload);
        System.out.println("发送成功=>" + "主题：" + topic + "  载荷:" + payload);
        return ApiResult.success(null, "发送成功");
    }
}

