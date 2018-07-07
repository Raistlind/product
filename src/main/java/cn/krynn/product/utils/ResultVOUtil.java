package cn.krynn.product.utils;

import cn.krynn.product.VO.ResultVO;

/**
 * Created by RaistlinD
 * 2018/7/7 下午11:41
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
