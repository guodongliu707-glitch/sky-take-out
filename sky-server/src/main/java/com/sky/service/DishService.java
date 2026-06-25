package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    void add(DishDTO dishDTO);

    List<DishVO> listWithFlavor(Dish dish);
}
