package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.FlatBookingDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {
    public FlatDTO addFlatBooking(FlatBookingDTO flat);
    public FlatBookingDTO updateFlatBooking(FlatBookingDTO flat,int id) throws FlatBookingNotFoundException;
    public void deleteFlatBooking(int id) throws FlatBookingNotFoundException;
    public FlatBookingDTO viewFlatBooking(int id) throws FlatBookingNotFoundException;
    public List<FlatBookingDTO> viewAllFlatBooking();

}