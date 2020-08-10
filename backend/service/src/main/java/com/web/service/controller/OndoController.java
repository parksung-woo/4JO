package com.web.service.controller;

import com.web.service.model.OndoDTO;
import com.web.service.service.LoginService;
import com.web.service.service.OndoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class OndoController {

    @Setter(onMethod_ = {@Autowired})
    private OndoService ondoService;


    //안드로이드로 온습도 값 보냄
    @GetMapping( value = "/ondoPrint" )
    public List<Map<String, Object>> seleteondo() throws Exception{
        log.info(String.valueOf(ondoService));
        return ondoService.selectOndo();
    }

    //온도 데이터 값 넣음
    @GetMapping("/raspberryInsert")
    public String ondoInsert(@RequestParam String temperature,
                             @RequestParam String humidity,
                             @RequestParam String nowDatetime)
            throws Exception{
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
