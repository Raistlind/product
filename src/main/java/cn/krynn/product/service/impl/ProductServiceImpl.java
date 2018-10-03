package cn.krynn.product.service.impl;

import cn.krynn.product.dataobject.ProductInfoOutput;
import cn.krynn.product.dto.CartDTO;
import cn.krynn.product.dataobject.ProductInfo;
import cn.krynn.product.enums.ProductStatusEnum;
import cn.krynn.product.enums.ResultEnum;
import cn.krynn.product.exception.ProductException;
import cn.krynn.product.repository.ProductInfoRepository;
import cn.krynn.product.service.ProductService;
import cn.krynn.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:29
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            //判断库存是否足够
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            // 发送MQ消息
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(productInfo, output);
            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(output));

        }
    }
}
