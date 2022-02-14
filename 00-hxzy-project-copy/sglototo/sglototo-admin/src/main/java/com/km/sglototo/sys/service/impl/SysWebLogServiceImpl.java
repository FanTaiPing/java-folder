package com.km.sglototo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.km.sglototo.sys.entity.SysWebLog;
import com.km.sglototo.sys.mapper.SysWebLogMapper;
import com.km.sglototo.sys.service.ISysWebLogService;
import com.km.sglototo.vo.LogParam;
import com.km.sglototo.vo.LogStatisc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * 
 * @since 2019-04-14
 */
@Service
public class SysWebLogServiceImpl extends ServiceImpl<SysWebLogMapper, SysWebLog> implements ISysWebLogService {

    @Resource
    private SysWebLogMapper logMapper;

    @Override
    public List<LogStatisc> selectPageExt(LogParam entity) {
        return logMapper.getLogStatisc(entity);
    }
}
