package com.web.service.repository;

import com.web.service.model.OndoDTO;
import com.web.service.util.PoolManager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OndoRepository {


    //안드로이드로 데이터 보냄?
    public static List<Map<String, Object>> selectOndo(){

        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectOndo");
    }

    //라즈베리 데이터 넣기
    public static void insertOndo(OndoDTO ondoDTO){
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();

        session.insert("web.service.insertOndo", ondoDTO);

        session.commit();
    }
}
