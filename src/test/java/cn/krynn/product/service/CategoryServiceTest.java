package cn.krynn.product.service;

import cn.krynn.product.ProductApplicationTests;
import cn.krynn.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RaistlinD
 * 2018/7/7 下午10:53
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private  CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(list.size() > 0);
    }
}