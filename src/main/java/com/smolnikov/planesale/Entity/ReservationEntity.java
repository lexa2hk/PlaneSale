package com.smolnikov.planesale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "reservation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {
    @Id
    @SequenceGenerator(name = "departure_seq", sequenceName =
        "departure_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departure_seq", strategy =
        GenerationType.SEQUENCE)
    private int id;

    private String flightCode;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
