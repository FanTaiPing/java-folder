package com.fan.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Record {
    private int id;
    private long cardNo;
    private Date transaction_date;
    private double expense;
    private double income;
    private double balance;
    private String transaction_type;
    private String remark;
}
