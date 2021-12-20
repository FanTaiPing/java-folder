package com.fan.service.impl;

import com.fan.dao.RecordDao;
import com.fan.entity.Record;
import com.fan.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public int insertRecord(Record record) {
        return recordDao.insertRecord(record);
    }
}
