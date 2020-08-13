package com.web.service.controller;

import com.google.gson.Gson;
import com.web.service.service.OndoService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Controller
public class IncomeController {



    @Setter(onMethod_=@Autowired)
    private OndoService ondoService;

    /**
     * 온습도 데이터를 graph.jsp 그래프 구현 페이지
     * @return "graph" : graph.jsp 웹 페이지
     */
    @GetMapping(value = "/graph")
    public String dateIncome() {
        return "graph";
    }

    /**
     * 온습도 데이터 값을 JSON형태로 만들어 
     * localhost:8383/selectOndoList 로 전송
     * @return gson.toJson(list) : JSON 값 리턴
     */
    @GetMapping(value = "/selectOndoList", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String incomeList() {
        Gson gson = new Gson();
        List<Map<String, Object>> list = ondoService.selectOndoList();
        return gson.toJson(list);
    }
}
