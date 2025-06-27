package com.yb.exam6backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qualities {

  private Integer id;
  private Integer score;
  private String  qualityDesc;
  private Integer productId;

}
