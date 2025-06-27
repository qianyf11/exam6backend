package com.yb.exam6backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

  private Integer id;
  private String  productName;
  @DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(pattern = "yyyy-MM-dd")
  private Date    productDate;
  private Integer productSum;
  private String  productDesc;
  private double  productPrice;
  private Integer score;
  private String qualityDesc;
  private Qualities qualities;

}
