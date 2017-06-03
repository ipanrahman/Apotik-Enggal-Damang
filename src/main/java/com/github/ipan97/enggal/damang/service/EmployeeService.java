/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.service;

import com.github.ipan97.enggal.damang.model.Employee;
import com.github.ipan97.enggal.damang.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ipan on 03/06/17.
 */
@Service
@Transactional
public class EmployeeService extends AbstractService<Employee, Long> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }
}
