package cn.krynn.product.service;

import cn.krynn.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:26
 */
public interface ProductService {

    List<ProductInfo> findUpAll();
}
