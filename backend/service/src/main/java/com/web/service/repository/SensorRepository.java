package com.web.service.repository;


import com.web.service.model.SensorDTO;
import com.web.service.util.PoolManager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SensorRepository {

    //안드로이드로 데이터 보냄?
    public static List<Map<String, Object>> selectSensor(){

        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectSensor");
    }

    //안드로이드 센서값 데이터 넣기
    public static void insertSensor(SensorDTO sensorDTO){
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();

        session.insert("web.service.insertSensor", sensorDTO);

        session.commit();
    }
}
