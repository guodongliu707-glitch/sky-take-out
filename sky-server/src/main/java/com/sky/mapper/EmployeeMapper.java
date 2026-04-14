package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee (password,name,phone,sex,username,id_number) values (#{password},#{name},#{phone},#{sex},#{username},#{idNumber})")
    int add(Employee employee1);

    //分页查询的方法
    Page<Employee> pagequery(EmployeePageQueryDTO employeePageQueryDTO);


    //根据id查信息
    @Select("select * from employee where id = #{id}")
    Employee getemployee(Integer id);


    void update(Employee employeeDTO);
}
