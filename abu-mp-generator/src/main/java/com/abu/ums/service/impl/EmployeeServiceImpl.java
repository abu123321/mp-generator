package com.abu.ums.service.impl;

import com.abu.ums.pojo.Employee;
import com.abu.ums.mapper.EmployeeMapper;
import com.abu.ums.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 阿布
 * @since 2020-04-02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> findAll() {
        return this.employeeMapper.selectList(null);
    }

    @Override
    public List<Employee> getUser(String username, Integer age) {
        return this.employeeMapper.selectByNameAndAge(username, age);
    }
}
