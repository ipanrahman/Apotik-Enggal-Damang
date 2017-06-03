/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.repository;

import com.github.ipan97.enggal.damang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ipan on 03/06/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
