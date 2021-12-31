package com.fan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RecordDao extends BaseMapper<Record> {
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
    List<Record> findRecord(@Param("dateOne") Date dateOne, @Param("dateTwo") Date dateTwo);
}
