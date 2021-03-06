package com.km.sglototo.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:
 * @Date: 2019/6/19 09:08
 * @Description:
 */
@Data
public class BalancePayParam {

    private Long orderId;
    private BigDecimal payAmount;
    private BigDecimal balance;
}
