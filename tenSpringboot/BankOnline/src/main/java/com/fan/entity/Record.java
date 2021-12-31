package com.fan.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Record {
    private int id;
    private long cardNo;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;
    private double expense;
    private double income;
    private double balance;
    private String transactionType;
    private String remark;
}
