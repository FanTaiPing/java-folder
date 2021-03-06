package com.km.sglototo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.km.sglototo.annotation.SysLog;
import com.km.sglototo.sys.entity.SysPermission;
import com.km.sglototo.sys.entity.SysPermissionNode;
import com.km.sglototo.sys.service.ISysPermissionService;
import com.km.sglototo.ums.service.RedisService;
import com.km.sglototo.utils.CommonResult;
import com.km.sglototo.utils.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台用户权限表
 * </p>
 *
 * 
 * @since 2019-04-19
 */
@Slf4j
@RestController
@Api(tags = "SysPermissionController", description = "后台用户权限表管理")
@RequestMapping("/sys/SysPermission")
public class SysPermissionController extends BaseController {
    @Resource
    private ISysPermissionService ISysPermissionService;

    @Resource
    private RedisService redisService;

    @SysLog(MODULE = "sys", REMARK = "根据条件查询所有后台用户权限表列表")
    @ApiOperation("根据条件查询所有后台用户权限表列表")
    @GetMapping(value = "/list")
    @PreAuthorize("hasAuthority('sys:SysPermission:read')")
    public Object getRoleByPage(SysPermission entity,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        try {
            if (ValidatorUtils.notEmpty(entity.getName())) {
                return new CommonResult().success(ISysPermissionService.list(new QueryWrapper<SysPermission>(new SysPermission()).like("name", entity.getName()).orderByAsc("sort")));
            }
            return new CommonResult().success(ISysPermissionService.list(new QueryWrapper<>(entity).orderByAsc("sort")));
        } catch (Exception e) {
            log.error("根据条件查询所有后台用户权限表列表：%s", e.getMessage(), e);
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "sys", REMARK = "保存后台用户权限表")
    @ApiOperation("保存后台用户权限表")
    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('sys:SysPermission:create')")
    public Object saveRole(@RequestBody SysPermission entity) {
        try {
            entity.setStatus(1);
            entity.setCreateTime(new Date());
            entity.setSort(0);
            if (ISysPermissionService.save(entity)) {
                return new CommonResult().success();
            }
        } catch (Exception e) {
            log.error("保存后台用户权限表：%s", e.getMessage(), e);
            return new CommonResult().failed();
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "sys", REMARK = "更新后台用户权限表")
    @ApiOperation("更新后台用户权限表")
    @PostMapping(value = "/update/{id}")
    @PreAuthorize("hasAuthority('sys:SysPermission:update')")
    public Object updateRole(@RequestBody SysPermission entity) {
        try {
            if (ISysPermissionService.updateById(entity)) {
                return new CommonResult().success();
            }
        } catch (Exception e) {
            log.error("更新后台用户权限表：%s", e.getMessage(), e);
            return new CommonResult().failed();
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "sys", REMARK = "更新后台用户权限表")
    @ApiOperation("更新后台用户权限表")
    @PostMapping(value = "/update/showStatus")
    @PreAuthorize("hasAuthority('sys:SysPermission:update')")
    public Object updateRoleStatus(@RequestParam("ids") Long ids, @RequestParam("showStatus") Integer showStatus) {
        try {
            SysPermission entity = new SysPermission();
            entity.setId(ids);
            entity.setStatus(showStatus);
            if (ISysPermissionService.updateById(entity)) {
                return new CommonResult().success();
            }
        } catch (Exception e) {
            log.error("更新后台用户权限表：%s", e.getMessage(), e);
            return new CommonResult().failed();
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "sys", REMARK = "删除后台用户权限表")
    @ApiOperation("删除后台用户权限表")
    @GetMapping(value = "/delete/{id}")
    @PreAuthorize("hasAuthority('sys:SysPermission:delete')")
    public Object deleteRole(@ApiParam("后台用户权限表id") @PathVariable Long id) {
        try {
            if (ValidatorUtils.empty(id)) {
                return new CommonResult().paramFailed("后台用户权限表id");
            }
            if (ISysPermissionService.removeById(id)) {
                return new CommonResult().success();
            }
        } catch (Exception e) {
            log.error("删除后台用户权限表：%s", e.getMessage(), e);
            return new CommonResult().failed();
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "sys", REMARK = "给后台用户权限表分配后台用户权限表")
    @ApiOperation("查询后台用户权限表明细")
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('sys:SysPermission:read')")
    public Object getRoleById(@ApiParam("后台用户权限表id") @PathVariable Long id) {
        try {
            if (ValidatorUtils.empty(id)) {
                return new CommonResult().paramFailed("后台用户权限表id");
            }
            SysPermission coupon = ISysPermissionService.getById(id);
            return new CommonResult().success(coupon);
        } catch (Exception e) {
            log.error("查询后台用户权限表明细：%s", e.getMessage(), e);
            return new CommonResult().failed();
        }

    }

    @ApiOperation(value = "批量删除后台用户权限表")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.GET)
    @ResponseBody
    @SysLog(MODULE = "pms", REMARK = "批量删除后台用户权限表")
    @PreAuthorize("hasAuthority('sys:SysPermission:delete')")
    public Object deleteBatch(@RequestParam("ids") List<Long> ids) {
        boolean count = ISysPermissionService.removeByIds(ids);
        if (count) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @SysLog(MODULE = "sys", REMARK = "获取所有权限列表")
    @ApiOperation("获取所有权限列表")
    @RequestMapping(value = "/findPermissions", method = RequestMethod.GET)
    @ResponseBody
    public Object findPermissions() {
        Long userId = getCurrentUser().getId();
        if (getCurrentUser().getSupplyId() != null && getCurrentUser().getSupplyId() == 1L) {
            return new CommonResult().success(ISysPermissionService.getAllPermission());
        }
        return new CommonResult().success(ISysPermissionService.getPermissionsByUserId(userId));
    }

    @SysLog(MODULE = "sys", REMARK = "以层级结构返回所有权限")
    @ApiOperation("以层级结构返回所有权限")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public Object treeList() {
        List<SysPermissionNode> permissionNodeList = ISysPermissionService.treeList();
        return new CommonResult().success(permissionNodeList);
    }


}
