package com.cg.onlineflatrental.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.repository.ITenantRepository;
import com.cg.onlineflatrental.exception.TenantNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class TenantService implements ITenantService {
	private static final Logger logger = LogManager.getLogger(TenantService.class);
	@Autowired
	private ITenantRepository tenantRepository;
	
	
	/** 
	 * @param tenant
	 * @return TenantDTO
	 */
	@Override
	public TenantDTO addTenant(TenantDTO tenant) {
		logger.info("Called addTenant() method of TenantService");
		Tenant t=new Tenant();
        t.setTenantId(tenant.getTenantId());
        t.setAge(tenant.getAge());
        FlatAddress fa=new FlatAddress();
        fa.setHouseNo(tenant.getTaddress().getHouseNo());
        fa.setStreet(tenant.getTaddress().getStreet());
        fa.setCity(tenant.getTaddress().getCity());
        fa.setState(tenant.getTaddress().getState());
        fa.setPin(tenant.getTaddress().getPin());
        fa.setCountry(tenant.getTaddress().getCountry());
        t.setTaddress(fa);
        tenantRepository.save(t);
		return tenant;
	}
	
	
	/** 
	 * @param tenantId
	 * @param tenant
	 * @return TenantDTO
	 * @throws TenantNotFoundException
	 */
	@Override
	public TenantDTO updateTenant(int tenantId, TenantDTO tenant) throws TenantNotFoundException{
		logger.info("Called updateTenant() method of TenantService");
		Optional<Tenant> optional = tenantRepository.findById(tenantId);
		Tenant value = optional.orElseThrow(() -> new TenantNotFoundException("Tenant with ID: " + tenantId +"does not exist."));
		value.setAge(tenant.getAge());
		FlatAddress fa=new FlatAddress();
        fa.setHouseNo(tenant.getTaddress().getHouseNo());
        fa.setStreet(tenant.getTaddress().getStreet());
        fa.setCity(tenant.getTaddress().getCity());
        fa.setState(tenant.getTaddress().getState());
        fa.setPin(tenant.getTaddress().getPin());
        fa.setCountry(tenant.getTaddress().getCountry());
        value.setTaddress(fa);
		tenantRepository.save(value);
		return tenant;
	}

	
	/** 
	 * @param tenantId
	 * @throws TenantNotFoundException
	 */
	@Override
	public void deleteTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called deleteTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant with id " + tenantId + " does not exist."));
		tenantRepository.delete(value);
	}

	
	/** 
	 * @param tenantId
	 * @return TenantDTO
	 * @throws TenantNotFoundException
	 */
	@Override
	public TenantDTO viewTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called viewTenant() method of TenantService");
		Tenant value =tenantRepository.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant With Given Id :" + tenantId + " Not Available!"));

		TenantDTO tenant=new TenantDTO();
		tenant.setTenantId(value.getTenantId());
		tenant.setAge(value.getAge());
        FlatAddressDTO fa=new FlatAddressDTO();
        fa.setHouseNo(value.getTaddress().getHouseNo());
        fa.setStreet(value.getTaddress().getStreet());
        fa.setCity(value.getTaddress().getCity());
        fa.setState(value.getTaddress().getState());
        fa.setPin(value.getTaddress().getPin());
        fa.setCountry(value.getTaddress().getCountry());
        tenant.setTaddress(fa);
        return tenant;
	}
	
	
	/** 
	 * @return List<TenantDTO>
	 */
	@Override
	public List<TenantDTO> viewAllTenant() {
		logger.info("Called viewAllTenant() method of TenantService");
		List<Tenant> list=(List<Tenant>) tenantRepository.findAll();
		List<TenantDTO> tList = new ArrayList<>();
		list.forEach(value->{
			TenantDTO tenant=new TenantDTO();
			tenant.setTenantId(value.getTenantId());
			tenant.setAge(value.getAge());
	        FlatAddressDTO fa=new FlatAddressDTO();
	        fa.setHouseNo(value.getTaddress().getHouseNo());
	        fa.setStreet(value.getTaddress().getStreet());
	        fa.setCity(value.getTaddress().getCity());
	        fa.setState(value.getTaddress().getState());
	        fa.setPin(value.getTaddress().getPin());
	        fa.setCountry(value.getTaddress().getCountry());
	        tenant.setTaddress(fa);
	        tList.add(tenant);
		});
		return tList;
	}

	
	/** 
	 * @param tenantId
	 * @return boolean
	 * @throws TenantNotFoundException
	 */
	@Override
	public boolean validateTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called validateTenant() method of TenantService");
		boolean flag = false;

		Optional<Tenant> tenant = tenantRepository.findById(tenantId);

		if (tenant == null)
			throw new TenantNotFoundException("Please check Tenant Id");
		else if (tenant.isPresent()) {
			flag = true;
		}

		else
			throw new TenantNotFoundException("Please check Tenant ID");
		
		return flag;
	}

}
