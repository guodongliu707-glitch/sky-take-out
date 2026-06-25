package com.sky.mapper;

import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {


    /// 向dish表输入数据，除口味属性外
    void add(Dish dish);

    List<Dish> list(Dish dish);
    /// 向口味表输入多条数据

}
