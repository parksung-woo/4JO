package com.web.service.service;

import com.web.service.model.OndoDTO;
import com.web.service.model.SensorDTO;
import com.web.service.repository.OndoRepository;
import com.web.service.repository.SensorRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SensorService {

    @Setter(onMethod_ = {@Autowired})
    private SensorRepository sensorRepository;

    //안드로이드 쪽으로 출력?
    public List<Map<String, Object>> selectSensor() {
        return sensorRepository.selectSensor();
    }

    // 안드로이드에서 온 센서정보를 db저장
    public void insertSensor(SensorDTO sensorDTO) {
        SensorRepository.insertSensor(sensorDTO);
    }
    public void insertSensor(String sensor) throws Exception{

        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setSensor(sensor);
        sensorRepository.insertSensor(sensorDTO);

    }
}
