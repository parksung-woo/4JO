package com.web.service.controller;

import com.google.gson.Gson;
import com.web.service.model.OndoDTO;
import com.web.service.service.OndoService;
import lombok.Setter;
import lombok.extern.java.Log;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class IncomeController {



    @Setter(onMethod_=@Autowired)
    private OndoService ondoService;

    @RequestMapping(value = "/graph", method = RequestMethod.GET)
    public String dateIncome(Locale locale, Model model) {
        return "graph";
    }


    @RequestMapping(value = "/selectOndoList", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
    public @ResponseBody String incomeList(Locale locale, Model model) {
        Gson gson = new Gson();
        List<Map<String, Object>> list = ondoService.selectOndoList();
        return gson.toJson(list);
    }
}
