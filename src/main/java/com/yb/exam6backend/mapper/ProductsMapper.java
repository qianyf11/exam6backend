package com.yb.exam6backend.mapper;

import com.yb.exam6backend.pojo.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductsMapper {
    List<Products> queryAll();

    List<Products> queryAllView(String productName);

    Integer add(Products products);

    Integer update(Products products);

    Products queryById(String productName);

    Products getProductById(Integer id);
}
