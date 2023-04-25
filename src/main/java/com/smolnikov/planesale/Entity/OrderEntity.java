package com.smolnikov.planesale.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @SequenceGenerator(name = "departure_seq", sequenceName =
            "departure_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departure_seq", strategy =
            GenerationType.SEQUENCE)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;



    private String flightCode;

    private String name;
    private String surname;
    private String email;
    private String phone;
    private Date date;
    private String reciept;


}
