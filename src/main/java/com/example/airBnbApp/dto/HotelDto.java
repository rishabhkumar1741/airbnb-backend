package com.example.airBnbApp.dto;
import com.example.airBnbApp.entity.HotelContactInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private Boolean isActive;
    private String[] amenities;
    private HotelContactInfo hotelInfo;

}
