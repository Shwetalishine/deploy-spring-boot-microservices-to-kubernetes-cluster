package com.app.user.service;

import VO.Department;
import VO.ResponseTemplateVO;
import com.app.user.entity.User;
import com.app.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {


    public static final String DEPARTMENT_SERVICE="departmentService";
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        log.info("Inside saveUser of User Service");
        return userRepository.save(user);
    }

//    @CircuitBreaker(name=DEPARTMENT_SERVICE, fallbackMethod = "fallback")
    public ResponseTemplateVO getUserWithDepartment(String userId) {
        log.info("Inside getUserWithDepartment of User Service");
        ResponseTemplateVO vo =new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);
        System.out.println("in user service method");
//        Department department =restTemplate.getForObject("http://localhost:9091/departments/"+user.getDepartmentId(),Department.class);
        Department department =restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        System.out.println(user);
        System.out.println(user.getDepartmentId());
        System.out.println(department);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

//
//    public Department fallback(RuntimeException e){
//        System.out.println("Calling fallback method and returning a message");
////        return "DEPARTMENT SERVICE IS TAKING LONGER THAN EXPECTED. PLEASE TRY AGAIN LATER!";
//
//        return null;
//    }

}
