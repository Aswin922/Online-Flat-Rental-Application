package com.cg.onlineflatrental.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.FlatBooking;

@Repository
public interface IFlatBookingRepository extends CrudRepository<FlatBooking, Integer>{

}