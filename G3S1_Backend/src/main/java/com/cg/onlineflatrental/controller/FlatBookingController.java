package com.cg.onlineflatrental.controller;

import java.util.List;

import javax.validation.Valid;

import com.cg.onlineflatrental.exception.FlatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.DTO.FlatBookingDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.service.FlatService;
import com.cg.onlineflatrental.service.IFlatBookingService;
import com.cg.onlineflatrental.service.ITenantService;


@RestController
@RequestMapping(value = "/flatbooking")
@CrossOrigin(origins="http://localhost:3000")
@Validated
public class FlatBookingController {

    @Autowired
    private IFlatBookingService fbs;

    @Autowired
    private ITenantService tenantServ;

    @Autowired
    FlatService flatService;

    
    /** 
     * @param flat
     * @return ResponseEntity<String>
     * @throws TenantNotFoundException
     * @throws FlatNotFoundException
     */
    @PostMapping("/addflatbooking")
    public ResponseEntity<String> addFlatBooking(@Valid @RequestBody FlatBookingDTO flat) throws TenantNotFoundException, FlatNotFoundException {
        flatService.viewFlat(flat.getFlat().getFlatId());
        tenantServ.viewTenant(flat.getTenantId().getTenantId());
        FlatDTO fb = fbs.addFlatBooking(flat);
        return new ResponseEntity<String>("FlatBooking created sucessfully.",HttpStatus.CREATED);
    }

    
    /** 
     * @return ResponseEntity<List<FlatBookingDTO>>
     */
    @GetMapping("/viewAllFlatBooking")
    public ResponseEntity<List<FlatBookingDTO>> viewAllFlatBooking() {
        List<FlatBookingDTO> list=fbs.viewAllFlatBooking();
        return new ResponseEntity<List<FlatBookingDTO>>(list,HttpStatus.OK);
    }

    
    /** 
     * @param id
     * @return ResponseEntity<FlatDTO>
     * @throws FlatBookingNotFoundException
     */
    @GetMapping("/viewflatbooking/{id}")
    public ResponseEntity<FlatBookingDTO> viewFlatBooking(@PathVariable int id) throws FlatBookingNotFoundException {
        FlatBookingDTO fb=fbs.viewFlatBooking(id);
        return new ResponseEntity<FlatBookingDTO>(fb,HttpStatus.OK);
    }

    
    /** 
     * @param id
     * @return ResponseEntity<String>
     * @throws FlatBookingNotFoundException
     */
    @DeleteMapping("/deleteflatbooking/{id}")
    public ResponseEntity<String> deleteFlatBooking(@PathVariable int id) throws FlatBookingNotFoundException{
        fbs.deleteFlatBooking(id);
        return new ResponseEntity<String>("FlatBooking with Booking No: "+id+" sucessfully deleted.",HttpStatus.OK);
    }

    
    /** 
     * @param flatbooking
     * @param id
     * @return ResponseEntity<FlatBookingDTO>
     * @throws FlatBookingNotFoundException
     * @throws TenantNotFoundException
     * @throws FlatNotFoundException
     */
    @PutMapping("/updateflatbooking/{id}")
    public ResponseEntity<FlatBookingDTO> updateFlatBooking(@Valid @RequestBody FlatBookingDTO flatbooking,@PathVariable int id) throws FlatBookingNotFoundException, TenantNotFoundException, FlatNotFoundException {
        FlatBookingDTO fb = fbs.updateFlatBooking(flatbooking,id);
        TenantDTO t = tenantServ.updateTenant(fb.getTenantId().getTenantId(), fb.getTenantId());
        FlatDTO f = flatService.updateFlat(fb.getFlat(),fb.getFlat().getFlatId());
        return new ResponseEntity<FlatBookingDTO>(fb,HttpStatus.ACCEPTED);

    }

}