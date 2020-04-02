package com.abu.ums.service;

import com.abu.ums.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 阿布
 * @since 2020-04-02
 */
public interface EmployeeService extends IService<Employee> {


    List<Employee> findAll();

    List<Employee> getUser(String username, Integer age);
}
