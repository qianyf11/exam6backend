package com.yb.exam6backend.service.impl;

import com.yb.exam6backend.mapper.QualitiesMapper;
import com.yb.exam6backend.pojo.Products;
import com.yb.exam6backend.pojo.Qualities;
import com.yb.exam6backend.service.IQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QualityServiceImpl implements IQualityService {

    @Autowired
    private QualitiesMapper qualitiesMapper;

    @Override
    public boolean saveQuality(Qualities qualities) {
        try {
            Qualities existingQuality = qualitiesMapper.findByProductId(qualities.getProductId());
            if (existingQuality == null) {
                qualitiesMapper.insertQuality(qualities);
            } else {
                qualities.setId(existingQuality.getId());
                qualitiesMapper.updateQuality(qualities);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
