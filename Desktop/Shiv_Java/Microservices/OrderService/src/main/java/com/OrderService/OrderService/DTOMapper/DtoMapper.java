package com.OrderService.OrderService.DTOMapper;

import com.OrderService.OrderService.DTOClass.DTO;
import com.OrderService.OrderService.DTOHandle.DtoRequest;
import com.OrderService.OrderService.DTOHandle.DtoResponse;
import com.OrderService.OrderService.Order;

public class DtoMapper {
    public static Order dtoTOEntity(DtoRequest dto){
        Order order = new Order(dto.getUserid(), dto.getProductName(), dto.getQuantity(),  dto.getPrice());
        return order;
    }

    public static DtoResponse entityTODto(Order order){
        DtoResponse dto = new DtoResponse();
        dto.setOrderId(order.getId());
        dto.setProductName(order.getProductName());
        dto.setQuantity(order.getQuantity());
        dto.setPrice(order.getPrice());
        dto.setUserName(order.getUsername());
        dto.setUserid(order.getUserid());

        return dto;
    }

}
