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

import com.cg.onlineflatrental.DTO.LandlordDTO;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.service.LandlordService;

@RestController
@RequestMapping(value = "/landlord")

@CrossOrigin(origins="http://localhost:3000")

@Validated
public class LandlordController {

	@Autowired
	private LandlordService landlordService;

	@Autowired
	private Environment environment;

	
	/** 
	 * @return ResponseEntity<List<LandlordDTO>>
	 */
	@GetMapping(value = "/viewalllandlord")
	public ResponseEntity<List<LandlordDTO>> viewAllLandlord() {
		List<LandlordDTO> landlordList = landlordService.viewAllLandlord();
		return new ResponseEntity<>(landlordList, HttpStatus.OK);
	}

	
	/** 
	 * @param landlordId
	 * @return ResponseEntity<LandlordDTO>
	 * @throws LandlordNotFoundException
	 */
	@GetMapping(value = "/viewlandlord/{landlordId}")
	public ResponseEntity<LandlordDTO> viewLandlord(@PathVariable Integer landlordId) throws LandlordNotFoundException {
		LandlordDTO landlord = landlordService.viewLandlord(landlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}

	
	/** 
	 * @param landlord
	 * @return ResponseEntity<String>
	 */
	@PostMapping(value = "/addlandlord")
	public ResponseEntity<String> addLandlord(@Valid @RequestBody LandlordDTO landlord) {
		LandlordDTO landlordId = landlordService.addLandlord(landlord);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + landlordId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	
	/** 
	 * @param landlordId
	 * @param landlord
	 * @return ResponseEntity<String>
	 * @throws LandlordNotFoundException
	 */
	@PutMapping(value = "/updatelandlord/{landlordId}")
	public ResponseEntity<String> updateLandlord(@PathVariable Integer landlordId,@Valid @RequestBody LandlordDTO landlord)
			throws LandlordNotFoundException {
		landlordService.updateLandlord(landlordId, landlord);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	
	/** 
	 * @param landlordId
	 * @return ResponseEntity<String>
	 * @throws LandlordNotFoundException
	 */
	@DeleteMapping(value = "/deletelandlord/{landlordId}")
	public ResponseEntity<String> deleteLandlord(@PathVariable Integer landlordId) throws LandlordNotFoundException {
		landlordService.deleteLandlord(landlordId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}

