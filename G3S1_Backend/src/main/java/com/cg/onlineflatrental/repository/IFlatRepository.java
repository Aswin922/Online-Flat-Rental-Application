package com.cg.onlineflatrental.repository;

import java.util.List;  
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.Flat;

@Repository
public interface IFlatRepository extends CrudRepository <Flat,Integer>{
	List<Flat> findByCostAndAvailability(float cost, String availability);
}
