package com.cg.onlineflatrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.service.FlatService;

@RestController
@RequestMapping(value = "/flat")
@CrossOrigin(origins="http://localhost:3000")
@Validated
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private Environment environment;

    
    /** 
     * @param flat
     * @return ResponseEntity<FlatDTO>
     */
    @PostMapping(value = "/addflat")
    public ResponseEntity<FlatDTO> addFlat(@Valid @RequestBody FlatDTO flat) {
        return new ResponseEntity<>(flatService.addFlat(flat), HttpStatus.CREATED);
    }

    
    /** 
     * @param flat
     * @param flatId
     * @return ResponseEntity<String>
     * @throws FlatNotFoundException
     */
    @PutMapping("/updateflat/{flatId}")
    public ResponseEntity<String> updateFlat(@Valid @RequestBody FlatDTO flat, @PathVariable Integer flatId)
            throws FlatNotFoundException {
        flatService.updateFlat(flat, flatId);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    
    /** 
     * @param flatId
     * @return ResponseEntity<String>
     * @throws FlatNotFoundException
     */
    @DeleteMapping(value = "/deleteflat/{flatId}")
    public ResponseEntity<String> deleteFlat(@PathVariable Integer flatId) throws FlatNotFoundException {
        flatService.deleteFlat(flatId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    
    /** 
     * @param flatId
     * @return ResponseEntity<FlatDTO>
     * @throws FlatNotFoundException
     */
    @GetMapping(value = "/viewflat/{flatId}")
    public ResponseEntity<FlatDTO> viewFlat(@PathVariable Integer flatId) throws FlatNotFoundException {
        FlatDTO flat = flatService.viewFlat(flatId);
        return new ResponseEntity<>(flat, HttpStatus.OK);
    }

    
    /** 
     * @return ResponseEntity<List<FlatDTO>>
     */
    @GetMapping(value = "/viewallflat")
    public ResponseEntity<List<FlatDTO>> viewAllFlat() {
        List<FlatDTO> flatList = flatService.viewAllFlat();
        return new ResponseEntity<>(flatList, HttpStatus.OK);
    }

    
    /** 
     * @param cost
     * @param availability
     * @return List<FlatDTO>
     */
    @GetMapping("findflat/{cost}/{availability}")
    public List<FlatDTO> findByCostAndAvailability(@PathVariable("cost") float cost, @PathVariable("availability") String availability) {
        return flatService.findByCostAndAvailability(cost, availability);
    }

}
