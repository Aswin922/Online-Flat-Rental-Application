package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.LandlordDTO;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;

public interface ILandlordService {
	public LandlordDTO addLandlord(LandlordDTO landlord);
	public LandlordDTO updateLandlord(Integer landlordId, LandlordDTO landlord) throws LandlordNotFoundException;
	public void deleteLandlord(Integer landlordId) throws LandlordNotFoundException;
	public LandlordDTO viewLandlord(Integer landlordId) throws LandlordNotFoundException;
	public List<LandlordDTO> viewAllLandlord();
}
