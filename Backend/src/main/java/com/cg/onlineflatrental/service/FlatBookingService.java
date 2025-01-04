package com.cg.onlineflatrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.FlatBookingDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.FlatBooking;
import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.repository.IFlatBookingRepository;

@Service
public class FlatBookingService implements IFlatBookingService {

    @Autowired
    private IFlatBookingRepository fbRepo;

    
    /** 
     * @param flat
     * @return FlatDTO
     */
    @Override
    public FlatDTO addFlatBooking(FlatBookingDTO flat) {
        
        FlatBooking fb=new FlatBooking();
        fb.setBookingNo(flat.getBookingNo());
        fb.setBookingFromDate(flat.getBookingFromDate());
        fb.setBookingToDate(flat.getBookingToDate());
        
        Flat f= new Flat();
        f.setFlatId(flat.getFlat().getFlatId());
        f.setCost(flat.getFlat().getCost());
        f.setAvailability(flat.getFlat().getAvailability());
        FlatAddress fa=new FlatAddress();
        fa.setHouseNo(flat.getFlat().getFlatAddress().getHouseNo());
        fa.setStreet(flat.getFlat().getFlatAddress().getStreet());
        fa.setCity(flat.getFlat().getFlatAddress().getCity());
        fa.setState(flat.getFlat().getFlatAddress().getState());
        fa.setPin(flat.getFlat().getFlatAddress().getPin());
        fa.setCountry(flat.getFlat().getFlatAddress().getCountry());
        f.setFlatAddress(fa);
        fb.setFlat(f);
        
        Tenant t=new Tenant();
        t.setTenantId(flat.getTenantId().getTenantId());
        t.setAge(flat.getTenantId().getAge());
        FlatAddress fa1=new FlatAddress();
        fa1.setHouseNo(flat.getTenantId().getTaddress().getHouseNo());
        fa1.setStreet(flat.getTenantId().getTaddress().getStreet());
        fa1.setCity(flat.getTenantId().getTaddress().getCity());
        fa1.setState(flat.getTenantId().getTaddress().getState());
        fa1.setPin(flat.getTenantId().getTaddress().getPin());
        fa1.setCountry(flat.getTenantId().getTaddress().getCountry());
        t.setTaddress(fa1);
        fb.setTenantId(t);
        
        fbRepo.save(fb);
        return flat.getFlat();
    }

    
    /** 
     * @return List<FlatBookingDTO>
     */
    @Override
    public List<FlatBookingDTO> viewAllFlatBooking() {
        List<FlatBooking> list=(List<FlatBooking>) fbRepo.findAll(); 
        List<FlatBookingDTO> fbList = new ArrayList<>();
        System.out.println("Data From DB :");
        list.forEach(FlatBooking->{
        	FlatBookingDTO fb=new FlatBookingDTO();
            fb.setBookingNo(FlatBooking.getBookingNo());
            fb.setBookingFromDate(FlatBooking.getBookingFromDate());
            fb.setBookingToDate(FlatBooking.getBookingToDate());
            
            FlatDTO f= new FlatDTO();
            f.setFlatId(FlatBooking.getFlat().getFlatId());
            f.setCost(FlatBooking.getFlat().getCost());
            f.setAvailability(FlatBooking.getFlat().getAvailability());
            FlatAddressDTO fa=new FlatAddressDTO();
            fa.setHouseNo(FlatBooking.getFlat().getFlatAddress().getHouseNo());
            fa.setStreet(FlatBooking.getFlat().getFlatAddress().getStreet());
            fa.setCity(FlatBooking.getFlat().getFlatAddress().getCity());
            fa.setState(FlatBooking.getFlat().getFlatAddress().getState());
            fa.setPin(FlatBooking.getFlat().getFlatAddress().getPin());
            fa.setCountry(FlatBooking.getFlat().getFlatAddress().getCountry());
            f.setFlatAddress(fa);
            fb.setFlat(f);
            
            TenantDTO t=new TenantDTO();
            t.setTenantId(FlatBooking.getTenantId().getTenantId());
            t.setAge(FlatBooking.getTenantId().getAge());
            FlatAddressDTO fa1=new FlatAddressDTO();
            fa1.setHouseNo(FlatBooking.getTenantId().getTaddress().getHouseNo());
            fa1.setStreet(FlatBooking.getTenantId().getTaddress().getStreet());
            fa1.setCity(FlatBooking.getTenantId().getTaddress().getCity());
            fa1.setState(FlatBooking.getTenantId().getTaddress().getState());
            fa1.setPin(FlatBooking.getTenantId().getTaddress().getPin());
            fa1.setCountry(FlatBooking.getTenantId().getTaddress().getCountry());
            t.setTaddress(fa1);
            fb.setTenantId(t);
            fbList.add(fb);
            
            System.out.println("Tenant Id :"+FlatBooking.getTenantId());
            System.out.println("Booking Number :"+FlatBooking.getBookingNo());
            System.out.println("Booking from Date :"+FlatBooking.getBookingFromDate());
            System.out.println("Booking to Date :"+FlatBooking.getBookingToDate());
        });
        return fbList;
    }

    
    /** 
     * @param id
     * @return FlatBookingDTO
     * @throws FlatBookingNotFoundException
     */
    @Override
    public FlatBookingDTO viewFlatBooking(int id) throws FlatBookingNotFoundException{
        Optional<FlatBooking> FlatBooking=fbRepo.findById(id);
        if(FlatBooking.isEmpty())
            throw new FlatBookingNotFoundException("flat booking does not exist");
        else {
        	
        	FlatBookingDTO fb=new FlatBookingDTO();
            fb.setBookingNo(FlatBooking.get().getBookingNo());
            fb.setBookingFromDate(FlatBooking.get().getBookingFromDate());
            fb.setBookingToDate(FlatBooking.get().getBookingToDate());
            
            FlatDTO f= new FlatDTO();
            f.setFlatId(FlatBooking.get().getFlat().getFlatId());
            f.setCost(FlatBooking.get().getFlat().getCost());
            f.setAvailability(FlatBooking.get().getFlat().getAvailability());
            FlatAddressDTO fa=new FlatAddressDTO();
            fa.setHouseNo(FlatBooking.get().getFlat().getFlatAddress().getHouseNo());
            fa.setStreet(FlatBooking.get().getFlat().getFlatAddress().getStreet());
            fa.setCity(FlatBooking.get().getFlat().getFlatAddress().getCity());
            fa.setState(FlatBooking.get().getFlat().getFlatAddress().getState());
            fa.setPin(FlatBooking.get().getFlat().getFlatAddress().getPin());
            fa.setCountry(FlatBooking.get().getFlat().getFlatAddress().getCountry());
            f.setFlatAddress(fa);
            fb.setFlat(f);
            
            TenantDTO t=new TenantDTO();
            t.setTenantId(FlatBooking.get().getTenantId().getTenantId());
            t.setAge(FlatBooking.get().getTenantId().getAge());
            FlatAddressDTO fa1=new FlatAddressDTO();
            fa1.setHouseNo(FlatBooking.get().getTenantId().getTaddress().getHouseNo());
            fa1.setStreet(FlatBooking.get().getTenantId().getTaddress().getStreet());
            fa1.setCity(FlatBooking.get().getTenantId().getTaddress().getCity());
            fa1.setState(FlatBooking.get().getTenantId().getTaddress().getState());
            fa1.setPin(FlatBooking.get().getTenantId().getTaddress().getPin());
            fa1.setCountry(FlatBooking.get().getTenantId().getTaddress().getCountry());
            t.setTaddress(fa1);
            fb.setTenantId(t);
        	return fb;
        }
    }

    
    /** 
     * @param id
     * @throws FlatBookingNotFoundException
     */
    @Override
    public void deleteFlatBooking(int id) throws FlatBookingNotFoundException {
        Optional<FlatBooking> fb= fbRepo.findById(id);
        if(fb.isEmpty())
            throw new FlatBookingNotFoundException("flat booking does not exist");
        else
            fbRepo.delete(fb.get());
    }

    
    /** 
     * @param flat
     * @param id
     * @return FlatBookingDTO
     * @throws FlatBookingNotFoundException
     */
    @Override
    public FlatBookingDTO updateFlatBooking(FlatBookingDTO flat, int id) throws FlatBookingNotFoundException {
        Optional<FlatBooking> fb= fbRepo.findById(id);
        if(fb.isEmpty())
            throw new FlatBookingNotFoundException("flat booking does not exist");
        else {
        	fb.get().setBookingNo(flat.getBookingNo());
        	fb.get().setBookingFromDate(flat.getBookingFromDate());
        	fb.get().setBookingToDate(flat.getBookingToDate());
            
            Flat f= new Flat();
            f.setFlatId(flat.getFlat().getFlatId());
            f.setCost(flat.getFlat().getCost());
            f.setAvailability(flat.getFlat().getAvailability());
            FlatAddress fa=new FlatAddress();
            fa.setHouseNo(flat.getFlat().getFlatAddress().getHouseNo());
            fa.setStreet(flat.getFlat().getFlatAddress().getStreet());
            fa.setCity(flat.getFlat().getFlatAddress().getCity());
            fa.setState(flat.getFlat().getFlatAddress().getState());
            fa.setPin(flat.getFlat().getFlatAddress().getPin());
            fa.setCountry(flat.getFlat().getFlatAddress().getCountry());
            f.setFlatAddress(fa);
            fb.get().setFlat(f);
            
            Tenant t=new Tenant();
            t.setTenantId(flat.getTenantId().getTenantId());
            t.setAge(flat.getTenantId().getAge());
            FlatAddress fa1=new FlatAddress();
            fa1.setHouseNo(flat.getTenantId().getTaddress().getHouseNo());
            fa1.setStreet(flat.getTenantId().getTaddress().getStreet());
            fa1.setCity(flat.getTenantId().getTaddress().getCity());
            fa1.setState(flat.getTenantId().getTaddress().getState());
            fa1.setPin(flat.getTenantId().getTaddress().getPin());
            fa1.setCountry(flat.getTenantId().getTaddress().getCountry());
            t.setTaddress(fa1);
            fb.get().setTenantId(t);
            
            fbRepo.save(fb.get());
        }
        return flat;
    }


}