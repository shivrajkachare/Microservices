package com.OrderService.OrderService;

import com.OrderService.OrderService.DTOHandle.DtoRequest;
import com.OrderService.OrderService.DTOHandle.DtoResponse;

public interface OrderService {

    public DtoResponse addOrder(DtoRequest dtoRequest);
    public  DtoResponse getOrder(Long orderId);

}
