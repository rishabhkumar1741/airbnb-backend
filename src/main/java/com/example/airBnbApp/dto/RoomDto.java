package com.example.airBnbApp.dto;
import com.example.airBnbApp.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;
    private Hotel hotel;
    private String type;
    private BigDecimal basePrice;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;

}
