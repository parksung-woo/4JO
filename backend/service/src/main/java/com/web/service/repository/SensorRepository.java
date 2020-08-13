package com.web.service.repository;


import com.web.service.model.SensorDTO;
import com.web.service.util.PoolManager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Repository
public class SensorRepository {

    /**
     * 센서 값을 라즈베리파이로  보냄
     * @return
     * : -DB에 있는 값을 id가 selectSensor인 SQL문을 통해 조작
     */
    public static List<Map<String, Object>> selectSensor() {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectSensor");
    }

    /**
     * 안드로이드에서 보낸 센서값(ON/OFF) 데이터를 DB에 저장
     * @param sensorDTO : 센서값과 그 센서가 저장된 날짜,시간(DB문에서 자동)을 담음
     */
    public static void insertSensor(SensorDTO sensorDTO) {
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();
        session.insert("web.service.insertSensor", sensorDTO);
        session.commit();
    }
}
