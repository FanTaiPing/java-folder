package com.fan.dao;

import com.fan.entity.Record;

public interface RecordDao {
    /**
     * 添加记录
     * @param record
     * @return
     */
    int insertRecord(Record record);
}
