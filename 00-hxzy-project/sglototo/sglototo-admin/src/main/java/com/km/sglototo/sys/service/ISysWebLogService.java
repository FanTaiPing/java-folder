package com.km.sglototo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.km.sglototo.sys.entity.SysWebLog;
import com.km.sglototo.vo.LogParam;
import com.km.sglototo.vo.LogStatisc;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * 
 * @since 2019-04-14
 */
public interface ISysWebLogService extends IService<SysWebLog> {

    List<LogStatisc> selectPageExt(LogParam entity);
}
