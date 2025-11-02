package com.example.airBnbApp.service.serviceInterface;

import com.example.airBnbApp.dto.HotelDto;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);

}
