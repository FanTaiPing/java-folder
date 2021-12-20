package com.fan.dao;

import com.fan.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    /**
     * 用户登录
     * @param cardNo
     * @return
     */
    Account login(Long cardNo);

    /**
     * 查询余额
     * @param cardNo
     * @return
     */
    Double getAccountByCode(Long cardNo);

    /**
     *
     * @param balance 金额
     * @param flag 判断金额是增加还是减少
     * @param cardNo 卡号
     * @return
     */
    int updateMoney(@Param("balance") double balance,@Param("flag") String flag,@Param("cardNo") Long cardNo);
}
