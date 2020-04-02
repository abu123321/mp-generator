package com.abu.ums.controller;


import com.abu.ums.pojo.Employee;
import com.abu.ums.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 阿布
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/ums/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("findall")
    public ResponseEntity<List<Employee>> getData() {
        List<Employee> list = this.employeeService.findAll();
        if (CollectionUtils.isEmpty(list)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("findOneByNameAndAge")
    public List<Employee> getUser(@RequestParam("name")String username,@RequestParam("age")Integer age){
        return this.employeeService.getUser(username,age);
    }
}

