package com.web.service.repository;

import com.web.service.model.OndoDTO;
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
public class OndoRepository {

    /**
     * 안드로이드로 온습도 JSON형태 데이터(최근 데이터 한개를 전송)
     * @return manager.getSession().selectList("web.service.selectOndo")
     * : -DB에 있는 값을 id가 selectOndo인 SQL문을 통해 조작
     */
    public static List<Map<String, Object>> selectOndo() {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectOndo");
    }

    /**
     * 온습도 목록에 출력할 값을 가져옴(최근 데이터 10개를 출력)
     * @return manager.getSession().selectList("web.service.selectOndoList")
     * : -DB에 있는 값을 id가 selectOndoList인 SQL문을 통해 조작
     */
    public static List<Map<String, Object>> selectOndoList() {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectOndoList");
    }

    /**
     * 라즈베리파이에서 전송된 데이터를  DB넣음
     * @param ondoDTO : 온습도, 측정된 날짜시간 데이터를 받음
     */
    public static void insertOndo(OndoDTO ondoDTO) {
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();
        session.insert("web.service.insertOndo", ondoDTO);
        session.commit();
    }
}
