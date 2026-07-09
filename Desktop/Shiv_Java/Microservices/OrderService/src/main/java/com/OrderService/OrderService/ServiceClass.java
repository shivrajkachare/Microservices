package com.OrderService.OrderService;

import com.OrderService.OrderService.AppConfig.OpenFeignClient;
import com.OrderService.OrderService.AppConfig.RestCalls;
import com.OrderService.OrderService.DTOHandle.DtoRequest;
import com.OrderService.OrderService.DTOHandle.DtoResponse;
import com.OrderService.OrderService.DTOMapper.DtoMapper;
import com.OrderService.OrderService.UserData.UserDTO;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ServiceClass implements OrderService{

    @Autowired
    OrderRepository repo;


    @Autowired
    RestCalls restCalls;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Autowired
    StateCheck stateChek;

    @Autowired
    OpenFeignClient openfeign;

    @Autowired
    private Tracer tracer;

    int count=0;
    @Override
    //@CircuitBreaker(name = "userService" , fallbackMethod="fallback")
    //@Retry(name = "userService", fallbackMethod = "fallback")
    public DtoResponse addOrder(DtoRequest dtorequest){
        log.info("Started the process of user creation.");
        Order order = DtoMapper.dtoTOEntity(dtorequest);

        //Fetching the Username through the userid
        //Using OpenFeign
        log.info("Current TraceId Before Feign : {}",
                tracer.currentSpan().context().traceId());
        UserDTO userDTO = openfeign.getUser(dtorequest.getUserid());
        log.info("Current TraceId After Feign : {}",
                tracer.currentSpan().context().traceId());
        log.info("User name is the : "+userDTO.getName());
        log.info("After calling User Service");
        //Using RestTemplate
        //UserDTO userDTO = restCalls.getResponse(dtorequest.getUserid());
        order.setUsername(userDTO.getUserName());

        Order saveorder = repo.save(order);
        log.info("Order is Save in the Repo..!!");
        Order findorder = repo.findById(saveorder.getId()).get();
        DtoResponse dtoResponse = DtoMapper.entityTODto(findorder);
        stateChek.checkState();
        System.out.println("Call goes to service...!!"+count);
        count++;
        log.info("final oder With Id is the : "+dtoResponse.toString());
        return dtoResponse;
    }

    @Override
    public DtoResponse getOrder(Long orderId){
        log.info("Started the process of user reading.");
        Order order = repo.findById(orderId).get();
        DtoResponse dtoResponse = DtoMapper.entityTODto(order);
        log.info("final oder With Id is the : "+dtoResponse.toString());
        return dtoResponse;
    }

    protected  DtoResponse fallback(DtoRequest dtorequest, Exception e){
        log.info("Falling back to service...!!!"+e.getMessage());
        Order order = DtoMapper.dtoTOEntity(dtorequest);

        double rand = Math.random();
        order.setUserid(dtorequest.getUserid());
        order.setUsername("default"+rand);
        Order saveorder = repo.save(order);
        Order findorder = repo.findById(saveorder.getId()).get();
        DtoResponse dtoResponse = DtoMapper.entityTODto(findorder);
        stateChek.checkState();
        log.info("final oder With Id is the : "+dtoResponse.toString());
        return DtoMapper.entityTODto(findorder);
    }


}
