package com.web.service.controller;

import com.web.service.model.SensorDTO;
import com.web.service.service.SensorService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@RestController
@Slf4j
public class SensorController {

    @Setter(onMethod_ = {@Autowired})
    private SensorService sensorService;

    /**
     * 센서 값을 localhost:8383/sensor 웹으로 Json형태로 출력
     * @return sensorService.selectSensor() : sensorMapper에서 id값이 selectSensor인 SQL문을
     *                                        sensorService에서 가공한 값을 리턴
     */
    @GetMapping("/sensor")
    public List<Map<String, Object>> selectSensor() {
        log.info(String.valueOf(sensorService));
        return sensorService.selectSensor();
    }

    /**
     * 안드에서 보낸 센서값을 localhost:8383/switch 를 통해 DB에 넣기
     * @param sensor  : 안드로이드에서 LED ON/OFF 제어
     *                  값을 localhost:포트번호/switch
     *                  통해 DB에 넣기 ( 1 : ON, 0 : OFF )
     * @return sensor : 센서값을 리턴
     */
    @GetMapping("/switch")
    public String insertSensor(@RequestParam String sensor) {
        log.info("sensorInsert 실행");
        log.info(sensor);
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setSensor(sensor);
        sensorService.insertSensor(sensorDTO);
        return sensor;
    }
}
