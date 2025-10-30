package com.example.airBnbApp.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HotelContactInfo {
    private String address;
    private String phoneNumber;
    private String email;
    private String Location;

}
