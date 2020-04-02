package com.abu.mpgenerator.test;

import com.abu.ums.mapper.EmployeeMapper;
import com.abu.ums.pojo.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class mytest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void testDelete() {
        this.employeeMapper.deleteById(5);
    }

    @Test
    void testInsert() {
        Employee employee = new Employee();
        employee.setEmail("824335342@qq.com");
        this.employeeMapper.insert(employee);
    }

    @Test
    void testUpdate() {
        Employee employee1 = this.employeeMapper.selectById("1245679124119343106");
        employee1.setEmail("q12q.com");
        this.employeeMapper.update(employee1, new QueryWrapper<Employee>().eq("id", "1245679124119343106"));
    }
}
