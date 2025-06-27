package com.yb.exam6backend.service;

import com.yb.exam6backend.pojo.Products;

import java.util.List;

public interface IProductService {
    List<Products> queryAll();

    List<Products> queryAllView(String productName);
}
