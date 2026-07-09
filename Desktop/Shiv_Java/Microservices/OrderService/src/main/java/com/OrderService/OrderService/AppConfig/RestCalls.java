package com.OrderService.OrderService.AppConfig;

import com.OrderService.OrderService.UserData.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class RestCalls {

    @Autowired
    private RestTemplate restTemplate;

    protected UserDTO getResponse(int id){
        String url = "http://userservice/User/getUser/"+id;
        UserDTO userDTO = restTemplate.getForObject(url,UserDTO.class);
        return restTemplate.getForObject(url,UserDTO.class);
    }


}
