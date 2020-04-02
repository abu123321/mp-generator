package com.abu.ums.mapper;

import com.abu.ums.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 阿布
 * @since 2020-04-02
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> selectByNameAndAge(@Param("name") String username,@Param("age") Integer age);
}
