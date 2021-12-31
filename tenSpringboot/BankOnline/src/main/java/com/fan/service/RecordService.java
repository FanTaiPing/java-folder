package com.fan.service;

import com.fan.entity.Record;

import java.util.Date;
import java.util.List;

public interface RecordService {
    /**
     * 添加记录
     * @param record
     * @return
     */
    int insertRecord(Record record);
    /**
     * 查询所有的交易记录
     * @return
     */
    List<Record> findAllRecord();
    /**
     * 根据时间查询交易记录
     * @return
     */
    List<Record> findRecord(Date dateOne, Date dateTwo);
}
