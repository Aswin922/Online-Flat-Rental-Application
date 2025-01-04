package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.exception.TenantNotFoundException;

public interface ITenantService {

	TenantDTO addTenant(TenantDTO tenant);
	TenantDTO updateTenant(int tenantId, TenantDTO tenant) throws TenantNotFoundException;
	void deleteTenant(int tenantId) throws TenantNotFoundException;
	TenantDTO viewTenant(int tenantId) throws TenantNotFoundException;
	boolean validateTenant(int tenantId) throws TenantNotFoundException;
	List<TenantDTO> viewAllTenant();

}
