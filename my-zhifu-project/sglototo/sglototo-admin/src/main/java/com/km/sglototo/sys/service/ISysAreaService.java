package com.km.sglototo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.km.sglototo.sys.entity.SysArea;
import com.km.sglototo.sys.vo.AreaWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * 
 * @since 2019-04-14
 */
public interface ISysAreaService extends IService<SysArea> {

    List<AreaWithChildrenItem> listWithChildren();
}
