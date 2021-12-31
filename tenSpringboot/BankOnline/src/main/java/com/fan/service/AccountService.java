package com.fan.service;

import com.fan.entity.Account;

public interface AccountService {
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
    Account getAccountByCode(Long cardNo);

    /**
     *
     * @param balance 金额
     * @param flag 判断金额是增加还是减少
     * @param cardNo 卡号
     * @return 记录条数
     */
    int updateMoney(double balance, String flag, Long cardNo);

    /**
     * 修改密码
     * @param password
     * @return
     */
    int updatePassword(String password,Long cardNo);
}
