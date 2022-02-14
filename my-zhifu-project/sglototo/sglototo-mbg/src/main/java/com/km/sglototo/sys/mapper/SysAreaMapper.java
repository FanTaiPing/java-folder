package com.km.sglototo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.km.sglototo.sys.entity.SysArea;
import com.km.sglototo.sys.vo.AreaWithChildrenItem;
import com.km.sglototo.sys.entity.SysArea;
import com.km.sglototo.sys.vo.AreaWithChildrenItem;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * 
 * @since 2019-04-14
 */
public interface SysAreaMapper extends BaseMapper<SysArea> {

    List<AreaWithChildrenItem> listWithChildren();
}
