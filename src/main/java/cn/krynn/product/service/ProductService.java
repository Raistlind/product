package cn.krynn.product.service;

import cn.krynn.product.dto.CartDTO;
import cn.krynn.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:26
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库货
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
