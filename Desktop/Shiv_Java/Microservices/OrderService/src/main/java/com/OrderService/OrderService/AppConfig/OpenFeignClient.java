package com.OrderService.OrderService.AppConfig;

import com.OrderService.OrderService.UserData.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//@FeignClient(name="userservice" , url="http://localhost:8081")
@FeignClient(name="USERSERVICE")
public interface OpenFeignClient {

    @GetMapping("/User/getUser/{id}")
    public UserDTO getUser(@PathVariable int id);

}
