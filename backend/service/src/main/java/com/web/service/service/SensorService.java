package com.web.service.service;


import com.web.service.model.SensorDTO;
import com.web.service.repository.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Service
@Slf4j
public class SensorService {

    /**
     * DB에 저장된 센서 값을 JSON형태로 가공
     * @return SensorRepository.selectSensor()
     * : -sensorMapper에 id가 selectSensor인 SQL문 데이터 가공
     */
    public List<Map<String, Object>> selectSensor() {
        return SensorRepository.selectSensor();
    }

    /**
     * 안드로이드에서 온 센서 값을 가공
     * @param sensorDTO : 안드로이드에서 온 센서값을 담음
     */
    public void insertSensor(SensorDTO sensorDTO) {
        SensorRepository.insertSensor(sensorDTO);
    }
}
