package cn.krynn.product.service;

import cn.krynn.product.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:50
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
