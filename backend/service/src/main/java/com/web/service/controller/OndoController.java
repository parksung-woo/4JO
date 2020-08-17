package com.web.service.controller;

import com.web.service.model.OndoDTO;
import com.web.service.service.OndoService;
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
public class OndoController {

    @Setter(onMethod_ = {@Autowired})
    private OndoService ondoService;

    /**
     * JSON형태의 온습도 값을 안드로이드로 전송
     * @return ondoService.selectOndo() : ondoMapper에서 id값이 selectOndo인 SQL문을
     *                                    ondoService에서 가공한 값을 리턴
     */
    @GetMapping( value = "/ondoPrint" )
    public List<Map<String, Object>> seleteondo() {
        log.info(String.valueOf(ondoService));
        return ondoService.selectOndo();
    }

    /**
     * 라즈베리파이에서 측정된 온습도 데이터 값을 localhost/raspberryInsert로 전송
     * @param temperature : 측정된 온도
     * @param humidity    : 측정된 습도
     * @param nowDatetime : 측정한 시간
     * @return "success"  : 라즈베리파이로 success 출력
     */
    @GetMapping("/raspberryInsert")
    public String ondoInsert(@RequestParam String temperature,
                             @RequestParam String humidity,
                             @RequestParam String nowDatetime) {
        log.info("raspberryInsert 실행");
        log.info(temperature);
        log.info(humidity);
        log.info(nowDatetime);

        OndoDTO ondoDTO = new OndoDTO();
        ondoDTO.setTemperature(temperature);
        ondoDTO.setHumidity(humidity);
        ondoDTO.setNowDatetime(nowDatetime);
        ondoService.insertOndo(ondoDTO);

        return "success";
    }


}
