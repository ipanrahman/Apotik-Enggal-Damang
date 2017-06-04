/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.controller;

import com.github.ipan97.enggal.damang.model.Employee;
import com.github.ipan97.enggal.damang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * Created by ipan on 03/06/17.
 */
@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee")
    public String index() {
        return "redirect:/employee/1";
    }

    @RequestMapping(value = "/employee/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable() Integer pageNumber, Model model) {
        Page<Employee> page = employeeService.getList(pageNumber);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "employee/list";
    }

    @RequestMapping(value = "/employee/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @RequestMapping(value = "/employee/edit/{id}")
    public String edit(@PathVariable() Long id, Model model) {
        Employee employee = employeeService.get(id);
        model.addAttribute("employee", employee);
        return "employee/form";
    }

    @RequestMapping(value = "/employee/save", method = RequestMethod.POST)
    public String save(Employee employee, RedirectAttributes ra) {
        employee.setCreatedDate(new Date());
        employee.setModifiedDate(new Date());
        employeeService.save(employee);
        ra.addFlashAttribute("successFlash", "Success add employee");
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/delete/{id}")
    public String delete(@PathVariable() Long id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
