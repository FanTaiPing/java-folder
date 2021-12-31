package com.fan;

import com.fan.dao.AccountDao;
import com.fan.dao.RecordDao;
import com.fan.entity.Record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        record.setTransactionDate(new Date());
        record.setExpense(0);
        record.setIncome(100);
        record.setBalance(100100);
        record.setTransactionType("消费");
        recordDao.insertRecord(record);
    }
    @Test
    public void testFindRecord() throws ParseException {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        recordDao.findRecord(dateFormat.parse("2021-12-25 01:32:21"),dateFormat.parse("2021-12-25 01:33:08"));
    }
    @Test
    public void testUpdatePassword(){

        System.out.println(accountDao.updatePassword("111111",6217003639684433L));
    }
}
