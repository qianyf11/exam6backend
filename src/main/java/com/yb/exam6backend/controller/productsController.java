package com.yb.exam6backend.controller;

import com.yb.exam6backend.pojo.Products;
import com.yb.exam6backend.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class productsController {
    @Autowired
    private IProductService productService;
    @GetMapping("queryAll")
    public List<Products> queryAll(){
        return productService.queryAll();
    }
    @GetMapping("queryAllView")
    public List<Products> queryAllView(@Param("productName")String productName){
        return productService.queryAllView(productName);
    }
}
