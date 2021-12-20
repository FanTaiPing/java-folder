package com.fan.service.impl;

import com.fan.dao.AccountDao;
import com.fan.entity.Account;
import com.fan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account login(Long cardNo) {
        return accountDao.login(cardNo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Double getAccountByCode(Long cardNo) {
        return accountDao.getAccountByCode(cardNo);
    }

    @Override
    public int updateMoney(double balance, String flag, Long cardNo) {
        return accountDao.updateMoney(balance,flag,cardNo);
    }
}
