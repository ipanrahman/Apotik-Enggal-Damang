/*
 * Copyright (c) Ipan Taupik Rahman
 */

package com.github.ipan97.enggal.damang.controller;

import com.github.ipan97.enggal.damang.model.Product;
import com.github.ipan97.enggal.damang.service.ProductService;
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
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product")
    public String index() {
        return "redirect:product/1";
    }

    @RequestMapping(value = "/product/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable() Integer pageNumber, Model model) {
        Page<Product> page = productService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "product/list";
    }

    @RequestMapping(value = "/product/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @RequestMapping(value = "/product/edit/{id}")
    public String add(@PathVariable() Long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "product/form";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String save(Product product, final RedirectAttributes ra) {
        product.setCreatedDate(new Date());
        product.setModifiedDate(new Date());
        Product save = productService.save(product);
        ra.addFlashAttribute("successFlash", "Success add product.");
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
