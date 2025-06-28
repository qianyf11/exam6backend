package com.yb.exam6backend.mapper;

import com.yb.exam6backend.pojo.Products;
import com.yb.exam6backend.pojo.Qualities;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualitiesMapper {
    int insertQuality(Qualities qualities);
    Qualities findByProductId(Integer productId);
    int updateQuality(Qualities qualities);

}
