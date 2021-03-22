package com.programming.user.service;

import com.programming.user.ValueObject.Department;
import com.programming.user.ValueObject.ResponseTemplateVO;
import com.programming.user.entity.User;
import com.programming.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO valueObject = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

        valueObject.setUser(user);
        valueObject.setDepartment(department);

        return valueObject;
    }
}
