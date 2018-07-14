package cn.krynn.product.exception;

import cn.krynn.product.enums.ResultEnum;

/**
 * Created by RaistlinD
 * 2018/7/14 上午9:49
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}