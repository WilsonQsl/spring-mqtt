package com.sun.demo.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * @author qiansl
 * @version 1.0
 * @date 2023/8/29 21:15
 * @description 设备经纬度信息上报
 */
@Data
public class DeviceDTO implements Serializable {

    //设备id
    private String deviceId;

    //租户ID
    private String tenantId;

    //设备来源
    private String types;

    //loraid硬件的id
    private String loraId;

    //创建时间
    private String createTime;

    //设备状态
    private Integer status;

    //经度
    private Double longitude;

    //纬度
    private Double latitude;

}

