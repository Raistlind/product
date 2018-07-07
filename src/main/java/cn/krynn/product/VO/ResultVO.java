package cn.krynn.product.VO;

import lombok.Data;

/**
 * http返回的最外层对象
 * Created by RaistlinD
 * 2018/7/7 下午10:59
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
