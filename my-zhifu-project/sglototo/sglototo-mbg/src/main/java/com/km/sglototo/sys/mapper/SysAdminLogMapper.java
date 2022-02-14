package com.km.sglototo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.km.sglototo.sys.entity.SysAdminLog; 
import com.km.sglototo.vo.LogParam;
import com.km.sglototo.vo.LogStatisc;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * 
 * @since 2019-04-14
 */
public interface SysAdminLogMapper extends BaseMapper<SysAdminLog> {

    List<LogStatisc> getLogStatisc(LogParam entity);


}
