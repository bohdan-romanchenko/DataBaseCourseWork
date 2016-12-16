package com.kpi.controller;

import com.kpi.model.Supply;
import com.kpi.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/supply")
public class SupplyController {

    @Autowired
    SupplyService supplyService;

    @RequestMapping(value = "/get")
    public ModelAndView get(ModelAndView model) {
        model.setViewName("supplylist");
        model.addObject("supplys", supplyService.getAll());
        return model;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Long id, ModelAndView model) {
        try {
            supplyService.delete(id);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }

    @RequestMapping(value = "/preUpdate")
    public ModelAndView preUpdate(@RequestParam Long id, ModelAndView model) {
        Supply supply = supplyService.getById(id);
        model.setViewName("supply");
        model.addObject("supply", supply);
        model.addObject("operation", "update");
        return model;
    }

    @RequestMapping(value = "/update")
    public ModelAndView update(Supply teacher, ModelAndView model) {
        try {
            supplyService.update(teacher);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }

    @RequestMapping(value = "/preInsert")
    public ModelAndView preInsert(ModelAndView model) throws SQLException {
        model.setViewName("supply");
        Supply supply = new Supply();
        supply.setId((long) (supplyService.getMaxId() + 1));
        model.addObject("supply", supply);
        model.addObject("operation", "insert");
        return model;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(Supply supply, ModelAndView model) {
        try {
            supplyService.insert(supply);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }
}
