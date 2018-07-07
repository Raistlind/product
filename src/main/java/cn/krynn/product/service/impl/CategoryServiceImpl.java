package cn.krynn.product.service.impl;

import cn.krynn.product.dataobject.ProductCategory;
import cn.krynn.product.repository.ProductCategoryRepository;
import cn.krynn.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:51
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
