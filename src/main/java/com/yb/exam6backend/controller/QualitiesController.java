package com.yb.exam6backend.controller;

import com.yb.exam6backend.pojo.Products;
import com.yb.exam6backend.pojo.Qualities;
import com.yb.exam6backend.service.IQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class QualitiesController {
    @Autowired
    private IQualityService qualityService;

    @PostMapping("/saveQuality")
    public Map<String, Object> saveQuality(@RequestBody Qualities qualities) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 验证质检结果
            if ("全部".equals(qualities.getQualityDesc())) {
                result.put("success", false);
                result.put("message", "质检结果必选！");
                return result;
            }

            // 确保score不为null
            if (qualities.getScore() == null) {
                qualities.setScore(0);
            }

            boolean success = qualityService.saveQuality(qualities);
            result.put("success", success);
            if (!success) {
                result.put("message", "保存质检结果失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "系统异常：" + e.getMessage());
        }

        return result;
    }
}
