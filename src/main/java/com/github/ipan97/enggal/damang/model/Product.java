/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by ipan on 03/06/17.
 */
@Entity
public class Product extends AbstractModel<Long> {

    @Column(name="name",length = 50)
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="type",length = 50)
    private String type;

    @Column(name="stock",length = 4)
    private Integer stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
