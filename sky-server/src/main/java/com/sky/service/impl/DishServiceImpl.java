package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorsMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class DishServiceImpl implements DishService {
    @Autowired
    private DishFlavorsMapper dishFlavorsMapper;

    @Autowired
    private DishMapper dishMapper;

    @Transactional
    //トランザクション　：开启事务管理
    ///向dish表输入数据，除口味属性外
    public void add(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.add(dish);
        Long dishId = dish.getId();
        /// 向口味表输入多条数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        ///确保数据存在且至少有一条
        if (flavors != null && flavors.size() > 0) {
            flavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            dishFlavorsMapper.insertBatch(flavors);
        }
    }

    @Override
    public List<DishVO> listWithFlavor(Dish dish) {
            return null;

    }


  
}


