package com.sun.demo.controller;

import com.sun.demo.dto.DeviceDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiansl
 * @version 1.0
 * @date 2023/8/29 21:15
 * @description
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(String str){
        Class deviceDTOClass = DeviceDTO.class;

        DeviceDTO dto = new DeviceDTO();
        Class cz = dto.getClass();

        return str;
    }
}
