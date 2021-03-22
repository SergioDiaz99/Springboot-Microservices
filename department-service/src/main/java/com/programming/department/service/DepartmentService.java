package com.programming.department.service;

import com.programming.department.entity.Department;
import com.programming.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }


    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
}
