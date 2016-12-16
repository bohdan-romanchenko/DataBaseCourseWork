package com.kpi.controller;

import com.kpi.model.Agent;
import com.kpi.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/agent")
public class AgentController {

    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(ModelAndView model) {
        model.setViewName("agentlist");
        model.addObject("agent", agentService.getAll());
        return model;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Integer id, ModelAndView model) {
        try {
            agentService.delete(id);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }

    @RequestMapping(value = "/preUpdate")
    public ModelAndView preUpdate(@RequestParam Integer id, ModelAndView model) {
        Agent agent = agentService.getById(id);
        model.setViewName("agent");
        model.addObject("agent", agent);
        model.addObject("operation", "update");
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(Agent agent, ModelAndView model) {
        try {
            agentService.update(agent);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }

    @RequestMapping(value = "/preInsert")
    public ModelAndView preInsert(ModelAndView model) throws SQLException {
        model.setViewName("agent");
        Agent agent = new Agent();
        agent.setId(agentService.getMaxId() + 1);
        model.addObject("agent", agent);
        model.addObject("operation", "insert");
        return model;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(Agent agent, ModelAndView model) {
        try {
            agentService.insert(agent);
        } catch (SQLException e) {
            model.addObject("exception", e.getMessage());
            e.printStackTrace();
        }
        return get(model);
    }
}
