package com.cg.onlineflatrental.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.service.TenantService;

@RestController
@RequestMapping(value = "/tenant")
@CrossOrigin(origins="http://localhost:3000")
@Validated
  public class TenantController {
	
  @Autowired
  private TenantService tenantServ;
 
	
	/** 
	 * @param tenant
	 * @return ResponseEntity<TenantDTO>
	 */
	@PostMapping("/addtenant")
	public ResponseEntity<TenantDTO> addTenant(@Valid @RequestBody TenantDTO tenant) {
		return new ResponseEntity<>(tenantServ.addTenant(tenant), HttpStatus.CREATED);
	}
	
	
	/** 
	 * @param tenantId
	 * @param tenant
	 * @return ResponseEntity<TenantDTO>
	 * @throws TenantNotFoundException
	 */
	@PutMapping("/updatetenant/{tenantId}")
	public ResponseEntity<TenantDTO> updateTenant(@PathVariable int tenantId,@Valid @RequestBody TenantDTO tenant)
			throws TenantNotFoundException {
		TenantDTO t = tenantServ.updateTenant(tenantId, tenant);
		return new ResponseEntity<TenantDTO>(t, HttpStatus.ACCEPTED);
	}

	
	/** 
	 * @param tenantId
	 * @return ResponseEntity<String>
	 * @throws TenantNotFoundException
	 */
	@DeleteMapping("/deletetenant/{tenantId}")
	public ResponseEntity<String> deleteTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		tenantServ.deleteTenant(tenantId);
		return new ResponseEntity<String>("Tenant with Tenant Id " + tenantId + " deleted successfuly", HttpStatus.OK);

	}

	
	/** 
	 * @return ResponseEntity<List<TenantDTO>>
	 */
	@GetMapping("/gettenants")
	public ResponseEntity<List<TenantDTO>> viewAllTenant() {
		List<TenantDTO> list = (List<TenantDTO>) tenantServ.viewAllTenant();
		return new ResponseEntity<List<TenantDTO>>(list, HttpStatus.OK);
	}

	
	/** 
	 * @param tenantId
	 * @return ResponseEntity<TenantDTO>
	 * @throws TenantNotFoundException
	 */
	@GetMapping("/viewtenant/{tenantId}")
	public ResponseEntity<TenantDTO> viewTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		TenantDTO t = tenantServ.viewTenant(tenantId);
		return new ResponseEntity<TenantDTO>(t, HttpStatus.OK);

	}
	
	
	/** 
	 * @param tenantId
	 * @return ResponseEntity<String>
	 * @throws TenantNotFoundException
	 */
	@PatchMapping("/validatetenant/{tenantId}")
	public ResponseEntity<String>validateTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		if(!tenantServ.validateTenant(tenantId)) {
			return new ResponseEntity<String>("Tenant Id not match", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Tenant Id Matched", HttpStatus.ACCEPTED);
		}
	}



	}


