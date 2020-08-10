package com.web.service.service;


import com.web.service.model.MemberDTO;
import com.web.service.model.OndoDTO;
import com.web.service.repository.MemberRepository;
import com.web.service.repository.OndoRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OndoService {

    @Setter(onMethod_ = {@Autowired})
    private OndoRepository ondoRepository;

    //안드로이드 쪽으로 출력?
    public List<Map<String, Object>> selectOndo() {
        return OndoRepository.selectOndo();
    }

    public List<Map<String, Object>> selectOndoList() {
        return OndoRepository.selectOndoList();
    }

    // 라즈베리에서 온 정보를 db저장
    public void insertOndo(OndoDTO ondoDTO) {
        OndoRepository.insertOndo(ondoDTO);
    }


    public void insertOndo(String temperature, String humidity, String nowDatetime) throws Exception{

        OndoDTO ondoDTO = new OndoDTO();
        ondoDTO.setTemperature(temperature);
        ondoDTO.setHumidity(humidity);
        ondoDTO.setNowDatetime(nowDatetime);
        ondoRepository.insertOndo(ondoDTO);

    }

}
