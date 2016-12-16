package com.kpi.controller;

import com.kpi.model.Shipment;
import com.kpi.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @RequestMapping(value = "/get")
    public ModelAndView get(ModelAndView model) {
        model.setViewName("shipmentlist");
        model.addObject("shipments", shipmentService.getAll());
        return model;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Long id, ModelAndView model) {
        try {
            shipmentService.delete(id);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }

    @RequestMapping(value = "/preUpdate")
    public ModelAndView preUpdate(@RequestParam Long id, ModelAndView model) {
        Shipment shipment = shipmentService.getById(id);
        model.setViewName("shipment");
        model.addObject("shipment", shipment);
        model.addObject("operation", "update");
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(Shipment shipment, ModelAndView model) {
        try {
            shipmentService.update(shipment);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }

    @RequestMapping(value = "/preInsert")
    public ModelAndView preInsert(ModelAndView model) throws SQLException {
        model.setViewName("shipment");
        Shipment shipment = new Shipment();
        shipment.setId((long) (shipmentService.getMaxId() + 1));
        model.addObject("shipment", shipment);
        model.addObject("operation", "insert");
        return model;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(Shipment shipment, ModelAndView model) {
        try {
            shipmentService.insert(shipment);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }
}
