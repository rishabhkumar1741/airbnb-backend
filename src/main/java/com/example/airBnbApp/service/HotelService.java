package com.example.airBnbApp.service;

import com.example.airBnbApp.dto.HotelDto;
import com.example.airBnbApp.entity.Hotel;
import com.example.airBnbApp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelService implements com.example.airBnbApp.service.serviceInterface.HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        // defensive checks
        if (hotelDto == null) {
            log.warn("createNewHotel called with null hotelDto");
            throw new IllegalArgumentException("hotelDto must not be null");
        }

        String hotelName = hotelDto.getName();
        log.info("Starting createNewHotel for name='{}'", hotelName);

        long start = System.nanoTime();
        try {
            // map DTO to entity
            Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
            hotel.setIsActive(false);

            // persist
            Hotel savedHotel = hotelRepository.save(hotel);

            long durationMs = (System.nanoTime() - start) / 1_000_000;
            // log after save with generated id and duration
            log.info("Created Hotel id={} name='{}' active={} (took {} ms)",
                    savedHotel.getId(),
                    savedHotel.getName(),
                    savedHotel.getIsActive(),
                    durationMs);

            return modelMapper.map(savedHotel, HotelDto.class);

        } catch (DataAccessException dae) {
            // log database-specific exception if using Spring Data
            log.error("Failed to create hotel name='{}' due to DB error", hotelName, dae);
            throw dae; // or wrap in a custom application exception
        } catch (Exception ex) {
            log.error("Unexpected error while creating hotel name='{}'", hotelName, ex);
            throw ex; // propagate or convert
        }
    }

    @Override
    public HotelDto getHotelById(Long id) {
        return null;
    }
}
