/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.service;

import com.github.ipan97.enggal.damang.model.Product;
import com.github.ipan97.enggal.damang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ipan on 03/06/17.
 */
@Service
@Transactional
public class ProductService extends AbstractService<Product, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }
}
