package com.sky.controller.admin;

import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    public Result save(@RequestBody Dish dish) {
        log.info("save dish:{}", dish);
        dishService.add(dish);
        return Result.success();
    }
}
