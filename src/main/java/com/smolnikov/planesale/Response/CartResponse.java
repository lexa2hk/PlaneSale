package com.smolnikov.planesale.Response;

import com.smolnikov.planesale.Entity.ReservationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private String flightCode;

    private String username;
    private String name;
    private String surname;
    private String email;
    private String phone;

    public CartResponse(ReservationEntity reservationEntity) {
        this.flightCode = reservationEntity.getFlightCode();
        this.username = reservationEntity.getUser().getUsername();
        this.name = reservationEntity.getName();
        this.surname = reservationEntity.getSurname();
        this.email = reservationEntity.getEmail();
        this.phone = reservationEntity.getPhone();
    }
}

