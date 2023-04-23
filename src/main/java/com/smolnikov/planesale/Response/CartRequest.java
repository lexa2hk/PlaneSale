package com.smolnikov.planesale.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private String flightCode;

    private String username;
    private String name;
    private String surname;
    private String email;
    private String phone;

}
