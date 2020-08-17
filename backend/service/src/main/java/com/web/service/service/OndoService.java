package com.web.service.service;



import com.web.service.model.OndoDTO;

import com.web.service.repository.OndoRepository;

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
public class OndoService {

    /**
     * 안드로이드로 보낼 온습도값 데이터 가공
     * @return OndoRepository.selectOndo()
     * : -ondoMapper에 id가 selectOndo인 SQL문 데이터 가공
     */
    public List<Map<String, Object>> selectOndo() {
        return OndoRepository.selectOndo();
    }

    /**
     * 목록 출력 웹페이지에 최근 데이터 10개 출력할 데이터 가공
     * @return OndoRepository.selectOndoList()
     * : -ondoMapper에 id가 selectOndoList인 SQL문 데이터 가공
     */
    public List<Map<String, Object>> selectOndoList() {
        return OndoRepository.selectOndoList();
    }

    /**
     * 라즈베리파이에서 보낸 온습도, 저장된 날짜 시간값 데이터 가공
     * @param ondoDTO : 라즈베리파이에서 온 데이터를 담음
     */
    /*라즈베리에서 온 온습도 정보를 db저장*/
    public void insertOndo(OndoDTO ondoDTO) {
        OndoRepository.insertOndo(ondoDTO);
    }


}
