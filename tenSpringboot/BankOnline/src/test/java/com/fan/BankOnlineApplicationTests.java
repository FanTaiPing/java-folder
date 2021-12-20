package com.fan;

import com.fan.dao.AccountDao;
import com.fan.dao.RecordDao;
import com.fan.entity.Record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BankOnlineApplicationTests {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private RecordDao recordDao;

    @Test
    public void loginTest() {
        System.out.println(accountDao.login(6217003639684433L));
    }

    @Test
    public void testUpdateMoney() {

        accountDao.updateMoney(200, "sub", 6217003639684433L);
    }

    @Test
    public void testInsertRecord() {
        Record record = new Record();
        record.setCardNo(6217003639684433L);
        record.setTransaction_date(new Date());
        record.setExpense(0);
        record.setIncome(100);
        record.setBalance(100100);
        record.setTransaction_type("消费");
        recordDao.insertRecord(record);
    }
}
