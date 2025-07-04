package com.yb.exam6backend.service;

import com.yb.exam6backend.pojo.Products;

import java.util.List;

public interface IProductService {
    List<Products> queryAll();

    List<Products> queryAllView(String productName);

    Integer add(Products products);

    Integer update(Products products);

    Products queryById(String productName);

    Products getProductById(Integer id);
}
