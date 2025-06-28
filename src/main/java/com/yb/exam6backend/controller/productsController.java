package com.yb.exam6backend.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yb.exam6backend.pojo.Products;
import com.yb.exam6backend.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @GetMapping("queryById")
    public Products queryById(String productName){
        return productService.queryById(productName);
    }
    @GetMapping("queryAllView")
    public PageInfo queryAllView(@Param("productName")String productName,Integer curPage,Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        List<Products> products = productService.queryAllView(productName);
        PageInfo<Products> productsPageInfo = PageInfo.of(products);
        productsPageInfo.setNextPage(productsPageInfo.getNextPage()==0?1:productsPageInfo.getNextPage());
        productsPageInfo.setPrePage(productsPageInfo.getPrePage()==0?productsPageInfo.getPages():productsPageInfo.getPrePage());
        return productsPageInfo;
    }
    @PostMapping("add")
    public HashMap<String,String> add(@RequestBody Products products){
        HashMap<String, String> hashMap = new HashMap<>();
       Integer i= productService.add(products);
       hashMap.put("code",i>0?"200":"400");
       hashMap.put("msg",i>0?"新增成功":"新增失败");
        return hashMap;
    }
    @PostMapping("update")
    public HashMap<String,String> update(@RequestBody Products products){
        HashMap<String, String> hashMap = new HashMap<>();
       Integer i= productService.update(products);
       hashMap.put("code",i>0?"200":"400");
       hashMap.put("msg",i>0?"修改成功":"修改失败");
        return hashMap;
    }
}
