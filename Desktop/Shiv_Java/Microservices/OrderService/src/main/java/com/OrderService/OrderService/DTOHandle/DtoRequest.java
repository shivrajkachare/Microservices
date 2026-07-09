package com.OrderService.OrderService.DTOHandle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRequest {
    public int userid;
    public String productName;
    public int quantity;
    public double price;
}
