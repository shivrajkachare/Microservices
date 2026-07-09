package com.OrderService.OrderService;

import com.OrderService.OrderService.DTOHandle.DtoRequest;
import com.OrderService.OrderService.DTOHandle.DtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody DtoRequest dtoRequest){
        DtoResponse dtoresponse = orderService.addOrder(dtoRequest);
        return new ResponseEntity<>(dtoresponse, HttpStatus.OK);
    }

    @GetMapping("/getOrder/{userid}")
    public ResponseEntity<?> getOrder(@PathVariable Long userid){

        DtoResponse dtoresponse = orderService.getOrder(userid);
        return new ResponseEntity<>(dtoresponse, HttpStatus.OK);

    }

    @GetMapping("/logs")
    public String checkLogs(){
        log.info("Logs are working fine...!!");
        log.warn("Logs WARNING works fine..!!");
        log.error("Logs ERROR Works fine..!!");
        return "Logs are working...!";
    }

}
