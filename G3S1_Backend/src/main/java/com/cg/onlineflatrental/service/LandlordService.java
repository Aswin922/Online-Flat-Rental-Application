package com.cg.onlineflatrental.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.DTO.LandlordDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.repository.ILandlordRepository;

@Service
@Transactional
public class LandlordService implements ILandlordService {

	@Autowired
	private ILandlordRepository landlordRepository;

	
	/** 
	 * @param landlord
	 * @return LandlordDTO
	 */
	@Override
	public LandlordDTO addLandlord(LandlordDTO landlord) {
		Landlord l=new Landlord();
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		List<Flat> fList = new ArrayList<>();
		landlord.getFlatList().forEach(flat->{
			Flat f= new Flat();
            f.setFlatId(flat.getFlatId());
            f.setCost(flat.getCost());
            f.setAvailability(flat.getAvailability());
            FlatAddress fa=new FlatAddress();
            fa.setHouseNo(flat.getFlatAddress().getHouseNo());
            fa.setStreet(flat.getFlatAddress().getStreet());
            fa.setCity(flat.getFlatAddress().getCity());
            fa.setState(flat.getFlatAddress().getState());
            fa.setPin(flat.getFlatAddress().getPin());
            fa.setCountry(flat.getFlatAddress().getCountry());
            f.setFlatAddress(fa);
            fList.add(f);
		});
		l.setFlatList(fList);
		landlordRepository.save(l);
		return landlord;
	}

	
	/** 
	 * @param landlordId
	 * @throws LandlordNotFoundException
	 */
	@Override
	public void deleteLandlord(Integer landlordId) throws LandlordNotFoundException {
		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		landlordRepository.deleteById(landlordId);
	}

	
	/** 
	 * @param landlordId
	 * @return LandlordDTO
	 * @throws LandlordNotFoundException
	 */
	@Override
	public LandlordDTO viewLandlord(Integer landlordId) throws LandlordNotFoundException {

		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		Landlord landlord=landlordRepository.findById(landlordId).get();
		LandlordDTO l=new LandlordDTO();
		l.setLandlordId(landlord.getLandlordId());
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		List<FlatDTO> fList = new ArrayList<>();
		landlord.getFlatList().forEach(flat->{
			FlatDTO f= new FlatDTO();
            f.setFlatId(flat.getFlatId());
            f.setCost(flat.getCost());
            f.setAvailability(flat.getAvailability());
            FlatAddressDTO fa=new FlatAddressDTO();
            fa.setHouseNo(flat.getFlatAddress().getHouseNo());
            fa.setStreet(flat.getFlatAddress().getStreet());
            fa.setCity(flat.getFlatAddress().getCity());
            fa.setState(flat.getFlatAddress().getState());
            fa.setPin(flat.getFlatAddress().getPin());
            fa.setCountry(flat.getFlatAddress().getCountry());
            f.setFlatAddress(fa);
            fList.add(f);
		});
		l.setFlatList(fList);
		return l;
	}

	
	/** 
	 * @return List<LandlordDTO>
	 */
	@Override
	public List<LandlordDTO> viewAllLandlord() {
		List<Landlord> list =(List<Landlord>) landlordRepository.findAll();
		List<LandlordDTO> lList = new ArrayList<>();
		list.forEach(landlord->{
			LandlordDTO l=new LandlordDTO();
			l.setLandlordId(landlord.getLandlordId());
			l.setLandlordName(landlord.getLandlordName());
			l.setLandlordAge(landlord.getLandlordAge());
			List<FlatDTO> fList = new ArrayList<>();
			landlord.getFlatList().forEach(flat->{
				FlatDTO f= new FlatDTO();
	            f.setFlatId(flat.getFlatId());
	            f.setCost(flat.getCost());
	            f.setAvailability(flat.getAvailability());
	            FlatAddressDTO fa=new FlatAddressDTO();
	            fa.setHouseNo(flat.getFlatAddress().getHouseNo());
	            fa.setStreet(flat.getFlatAddress().getStreet());
	            fa.setCity(flat.getFlatAddress().getCity());
	            fa.setState(flat.getFlatAddress().getState());
	            fa.setPin(flat.getFlatAddress().getPin());
	            fa.setCountry(flat.getFlatAddress().getCountry());
	            f.setFlatAddress(fa);
	            fList.add(f);
			});
			l.setFlatList(fList);
			lList.add(l);
		});
		return lList;
	}

	
	/** 
	 * @param landlordId
	 * @param landlord
	 * @return LandlordDTO
	 * @throws LandlordNotFoundException
	 */
	@Override
	public LandlordDTO updateLandlord(Integer landlordId, LandlordDTO landlord) throws LandlordNotFoundException {
		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		Landlord l = landlordRepository.findById(landlordId).get();
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		List<Flat> fList = new ArrayList<>();
		landlord.getFlatList().forEach(flat->{
			Flat f= new Flat();
            f.setFlatId(flat.getFlatId());
            f.setCost(flat.getCost());
            f.setAvailability(flat.getAvailability());
            FlatAddress fa=new FlatAddress();
            fa.setHouseNo(flat.getFlatAddress().getHouseNo());
            fa.setStreet(flat.getFlatAddress().getStreet());
            fa.setCity(flat.getFlatAddress().getCity());
            fa.setState(flat.getFlatAddress().getState());
            fa.setPin(flat.getFlatAddress().getPin());
            fa.setCountry(flat.getFlatAddress().getCountry());
            f.setFlatAddress(fa);
            fList.add(f);
		});
		l.setFlatList(fList);
		landlordRepository.save(l);
		return landlord;
	}
}
