package cn.krynn.product.service.impl;

import cn.krynn.product.dataobject.ProductInfo;
import cn.krynn.product.enums.ProductStatusEnum;
import cn.krynn.product.repository.ProductInfoRepository;
import cn.krynn.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:29
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
