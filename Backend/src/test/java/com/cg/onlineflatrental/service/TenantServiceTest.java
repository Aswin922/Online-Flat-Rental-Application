package com.cg.onlineflatrental.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.repository.ITenantRepository;

@SpringBootTest
public class TenantServiceTest {
	@Autowired
	private TenantService tenantService;

	@MockBean
	private ITenantRepository tenantRepository;

	FlatAddress add1, add2, add3;
	Tenant c1,c2,c3;
	TenantDTO cd2;
	Optional<Tenant> c02;
	
	@BeforeEach		//Define flat list also for below test cases
	public void init() {
		add1= new FlatAddress(10,"jaipurroad", "jaipur", "rajasthan", 302000, "India");
		add2= new FlatAddress(11,"ajmerrroad", "ajmer", "rajasthan", 303015, "India");
		add3= new FlatAddress(12,"kotaroad", "kota", "rajasthan", 306605, "India");
		c1 = new Tenant(1, 22,add1);
		c2 = new Tenant(2, 18,add2);
		c3 = new Tenant(3, 19,add3);
		c02 = Optional.of(c2);
		
		cd2=new TenantDTO(2, 18,new FlatAddressDTO(11,"ajmerrroad", "ajmer", "rajasthan", 303015, "India"));
	}
	
	/** 
	 * @throws TenantNotFoundException
	 */
	//Test Case to UpdateTenant
	@Test
	public void test_UpdateTenant() throws TenantNotFoundException {
		when(tenantRepository.findById(c2.getTenantId())).thenReturn(c02);
		when(tenantRepository.save(c2)).thenReturn(c2);
		assertEquals(cd2.getTenantId(), tenantService.updateTenant(cd2.getTenantId(), cd2).getTenantId());
	}
	
	//Test Case to AddTenant

	@Test
	public void test_AddTenant() {

		when(tenantRepository.save(c2)).thenReturn(c2);
		assertEquals(cd2.getTenantId(), tenantService.addTenant(cd2).getTenantId());

	}
	
	
	/** 
	 * @throws Exception
	 */
	//Test Case to viewAllTenant

	@Test
	public void test_viewAllTenant() throws Exception {

		List<Tenant> tenantlist = new ArrayList<Tenant>();
		tenantlist.add(c1);
		tenantlist.add(c2);
		Mockito.when(tenantRepository.findAll()).thenReturn(tenantlist);
		List<TenantDTO> result = (List<TenantDTO>) tenantService.viewAllTenant();
		assertEquals(2, result.size());

	}
	
	//Test Case for TenantNotFoundException

	@Test
	public void test_viewTenant_ThrowTenantNotFoundException() {
		try {
			Mockito.when(tenantService.viewTenant(1)).thenThrow(new TenantNotFoundException("not found"));
		} catch (Exception c1) {

			Assertions.assertThat(c1 instanceof TenantNotFoundException);
		}

	}
}

