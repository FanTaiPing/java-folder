package com.km.sglototo.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.km.sglototo.product.entity.PmsProductCategory;
import com.km.sglototo.product.mapper.PmsProductCategoryMapper;
import com.km.sglototo.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements ProductService {
}
