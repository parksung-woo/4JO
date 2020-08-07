package com.web.service.controller;

import com.web.service.model.SensorDTO;
import com.web.service.service.LoginService;
import com.web.service.service.SensorService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class SensorController {

    @Setter(onMethod_ = {@Autowired})
    SensorService sensorService;

    @GetMapping("/sensor")
    public List<Map<String, Object>> selectSensor() throws Exception{
        log.info(String.valueOf(sensorService));
        return sensorService.selectSensor();
    }

    //안드로이드 센서값 넣기
    @GetMapping("/switch")
    public String insertSensor(@RequestParam String sensor){
        log.info("sensorInsert 실행");
        log.info(sensor);

        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setSensor(sensor);
        sensorService.insertSensor(sensorDTO);

        return sensor;
    }
}
