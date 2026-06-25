package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;

import com.sky.service.impl.DishServiceImpl;
import com.sky.vo.DishVO;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishControl {

    @Autowired
    DishServiceImpl dishService;
    @GetMapping("/list")
    @ApiOperation("根据id查询菜品信息")
    public Result<List<DishVO>> list(Long categoryid) {

        Dish dish = new Dish();
        dish.setCategoryId(categoryid);
        dish.setStatus(StatusConstant.ENABLE);///查询起售中的菜品

        List<DishVO> list = dishService.listWithFlavor(dish);
        return Result.success(list);
    }

}
