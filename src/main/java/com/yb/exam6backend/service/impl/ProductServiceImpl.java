package com.yb.exam6backend.service.impl;

import com.yb.exam6backend.mapper.ProductsMapper;
import com.yb.exam6backend.mapper.QualitiesMapper;
import com.yb.exam6backend.pojo.Products;
import com.yb.exam6backend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private QualitiesMapper qualitiesMapper;
    @Autowired
    private ProductsMapper productsMapper;
    @Override
    public List<Products> queryAll() {
        return productsMapper.queryAll();
    }

    @Override
    public List<Products> queryAllView(String productName) {
        return productsMapper.queryAllView(productName);
    }

    @Override
    public Integer add(Products products) {
        return productsMapper.add(products);
    }

    @Override
    public Integer update(Products products) {
        return productsMapper.update(products);
    }

    @Override
    public Products queryById(String productName) {
        return productsMapper.queryById(productName);
    }

    @Override
    public Products getProductById(Integer id) {
        return productsMapper.getProductById(id);
    }
}
