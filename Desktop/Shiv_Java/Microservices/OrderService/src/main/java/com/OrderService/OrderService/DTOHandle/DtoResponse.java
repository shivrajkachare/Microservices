package com.OrderService.OrderService.DTOHandle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoResponse {
    public Long orderId;
    public String productName;
    public int quantity;
    public double price;
    public String userName;
    public int userid;
}
