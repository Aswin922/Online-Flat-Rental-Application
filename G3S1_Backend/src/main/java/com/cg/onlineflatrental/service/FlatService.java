package com.cg.onlineflatrental.service;

import java.util.ArrayList;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.repository.IFlatRepository;

@Service
public class FlatService implements IFlatService{
		 
		@Autowired
		private IFlatRepository flatRepository;

		
		/** 
		 * @param flat
		 * @return FlatDTO
		 */
		@Override
		public FlatDTO addFlat(FlatDTO flat) {
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
			flatRepository.save(f);
			return flat;
		}
	
		
		/** 
		 * @param flat
		 * @param flatId
		 * @return FlatDTO
		 * @throws FlatNotFoundException
		 */
		@Override	
		public FlatDTO updateFlat(FlatDTO flat,int flatId) throws FlatNotFoundException {
			Flat f = flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
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
			flatRepository.save(f);
			return flat;
		}
		
		
		/** 
		 * @param flatId
		 * @throws FlatNotFoundException
		 */
		@Override	
		public void deleteFlat(int flatId)throws FlatNotFoundException{
			Flat f=flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
			flatRepository.delete(f);
		}
		
		
		/** 
		 * @param flatId
		 * @return FlatDTO
		 * @throws FlatNotFoundException
		 */
		@Override
		public FlatDTO viewFlat(int flatId) throws FlatNotFoundException {
			Flat flat=flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
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
            return f;
		}
		
		
		/** 
		 * @return List<FlatDTO>
		 */
		@Override
		public List<FlatDTO> viewAllFlat() {
			List<Flat> list=(List<Flat>) flatRepository.findAll();
			List<FlatDTO> fList = new ArrayList<>();
			list.forEach(flat->{
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
			return fList;
		}
		
		
		/** 
		 * @param cost
		 * @param availability
		 * @return List<FlatDTO>
		 */
		@Override
		public List<FlatDTO> findByCostAndAvailability(float cost,String availability){
			List<Flat> list=flatRepository.findByCostAndAvailability(cost,availability);
			List<FlatDTO> fList = new ArrayList<>();
			list.forEach(flat->{
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
			return fList;
	     }	
}
