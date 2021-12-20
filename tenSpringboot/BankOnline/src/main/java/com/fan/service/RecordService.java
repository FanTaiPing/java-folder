package com.fan.service;

import com.fan.entity.Record;

public interface RecordService {
    /**
     * 添加记录
     * @param record
     * @return
     */
    int insertRecord(Record record);
}
