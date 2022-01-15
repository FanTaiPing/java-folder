package com.km.sglototo.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.km.sglototo.annotation.SysLog;
import com.km.sglototo.product.entity.PmsProductCategory;
import com.km.sglototo.product.service.ProductService;
import com.km.sglototo.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息控制器
 */
@Slf4j
@Api(value = "商品管理", tags = {"商品管理"})
@Controller
@RestController
@RequestMapping("/products/product")
public class ProductController extends ApiController {
    @Resource
    private ProductService productService;

    /**
     * 查询所有的商品信息
     *
     * @param pmsProductCategory
     * @param pageNum            当前页码
     * @param pageSize           每页显示的信息
     * @return
     */
    @GetMapping(value = "/productList/{searchName}")
    @SysLog(MODULE = "products", REMARK = "根据条件查询所有用户列表")
    @ApiOperation("根据条件查询所有用户列表")
    public Object findAllProduct(PmsProductCategory pmsProductCategory,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 @PathVariable String searchName) {
        try {
            Page<PmsProductCategory> page = new Page<>(pageNum, pageSize);
            QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
            if(searchName != null){
                queryWrapper.like("name",searchName);
            }

//            return new CommonResult().success(productService.page(new Page<PmsProductCategory>(pageNum, pageSize), new QueryWrapper<>(pmsProductCategory)));
            return new CommonResult().success(productService.page(page,queryWrapper));
        } catch (Exception e) {
            log.error("根据条件查询所有用户列表：%s", e.getMessage(), e);
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "products", REMARK = "添加商品信息")
    @ApiOperation("添加商品信息")
    @PostMapping("/insertProduct")
    public Object insertProduct(@RequestBody PmsProductCategory pmsProductCategory) {
        try {
            return new CommonResult().success(productService.save(pmsProductCategory));
        } catch (Exception e) {
            log.error("添加商品信息：%s", e.getMessage(), e);
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "products", REMARK = "根据商品id删除商品信息")
    @ApiOperation("根据商品id删除商品信息")
    @GetMapping("/deleteProductById")
    public Object deleteProductById(Long id) {
        try {
            return new CommonResult().success(productService.removeById(id));
        } catch (Exception e) {
            log.error("根据商品id删除商品信息：%s", e.getMessage(), e);
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "products", REMARK = "根据id查询商品信息")
    @ApiOperation("根据id查询商品信息")
    @GetMapping("getProductById")
    public Object getProductById(Long id) {
        try {
            PmsProductCategory p = productService.getById(id);
            return new CommonResult().success(p);
        } catch (Exception e) {
            log.error("根据商品id商品信息：%s", e.getMessage(), e);
        }
        return new CommonResult().failed();
    }

    @SysLog(MODULE = "products", REMARK = "根据id修改商品信息")
    @ApiOperation("根据id修改商品信息")
    @PostMapping("updateProduct")
    public Object updateProductById(@RequestBody PmsProductCategory pmsProductCategory) {
        try {
            if(pmsProductCategory.getId()==null|| pmsProductCategory.getId().equals(null)){
//                insert
            }else {
//                update
            }
            return new CommonResult().success(productService.updateById(pmsProductCategory));
//            return new CommonResult().success(productService.saveOrUpdate(pmsProductCategory));
        } catch (Exception e) {
            log.error("根据id修改商品信息：%s", e.getMessage(), e);
        }
        return new CommonResult().failed();
    }
}
