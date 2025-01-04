package com.cg.onlineflatrental.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.DTO.LandlordDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.repository.ILandlordRepository;


@SpringBootTest
public class LandlordServiceTest {
	
	@Autowired 
	private LandlordService service;
	
	@MockBean
	private ILandlordRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(LandlordServiceTest.class);
	
	private Optional<Landlord> l3;
	private Landlord landlord1 ,landlord2,landlord3;
	private Flat flat1, flat2, flat3;
	
	private LandlordDTO landlordd1 ,landlordd2,landlordd3;
	private FlatDTO flatd1, flatd2, flatd3;

	
	@BeforeAll
	public static void initBefore() {
		LOGGER.info("Landlord module testing initialized");
	}
	
	@BeforeEach
	public void init() {
		flat1 = new Flat(1, 2000, new FlatAddress(10,"Street1","City1","State1",123456,"Country1"),"available");
        flat2 = new Flat(2, 4000, new FlatAddress(20,"Street2","City2","State2",234567,"Country2"),"available");
        flat3 = new Flat(3, 6000, new FlatAddress(30,"Street3","City3","State3",345678,"Country3"),"available");

        flatd1 = new FlatDTO(1, 2000, new FlatAddressDTO(10,"Street1","City1","State1",123456,"Country1"),"available");
        flatd2 = new FlatDTO(2, 4000, new FlatAddressDTO(20,"Street2","City2","State2",234567,"Country2"),"available");
        flatd3 = new FlatDTO(3, 6000, new FlatAddressDTO(30,"Street3","City3","State3",345678,"Country3"),"available");
		
        List<Flat> flat_list1 = new ArrayList<Flat>();
		flat_list1.add(flat1);
		flat_list1.add(flat2);
		List<Flat> flat_list2 = new ArrayList<Flat>();
		flat_list2.add(flat3);
		
		landlord1 = new Landlord(1,"John",33,flat_list1);
		landlord2 = new Landlord(2,"Ahmed",42,flat_list2);
		landlord3 = new Landlord(3,"Dev",38,flat_list1);
		l3 = Optional.of(landlord3);
		
		List<FlatDTO> flat_listd1 = new ArrayList<FlatDTO>();
		flat_listd1.add(flatd1);
		flat_listd1.add(flatd2);
		List<FlatDTO> flat_listd2 = new ArrayList<FlatDTO>();
		flat_listd2.add(flatd3);
		
		landlordd1 = new LandlordDTO(1,"John",33,flat_listd1);
		landlordd2 = new LandlordDTO(2,"Ahmed",42,flat_listd2);
		landlordd3 = new LandlordDTO(3,"Dev",38,flat_listd1);
		
	}
	
	@Test
	public void testAddLandlord1() {
		when(repository.save(landlord1)).thenReturn(landlord1);
		assertEquals(landlordd1.getLandlordAge(),service.addLandlord(landlordd1).getLandlordAge());
		assertEquals(landlordd1.getLandlordId(),service.addLandlord(landlordd1).getLandlordId());
		assertEquals(landlordd1.getLandlordName(),service.addLandlord(landlordd1).getLandlordName());
		assertEquals(landlordd1.getFlatList(),service.addLandlord(landlordd1).getFlatList());
	}
	
	@Test
	public void testAddLandlord2() {
		when(repository.save(landlord1)).thenReturn(landlord1);
		assertNotNull(service.addLandlord(landlordd1));
	}
	
	
	/** 
	 * @throws LandlordNotFoundException
	 */
	@Test
	public void testUpdateLandlord1() throws LandlordNotFoundException{
		when(repository.existsById(landlord3.getLandlordId())).thenReturn(true);
		when(repository.findById(landlord3.getLandlordId())).thenReturn(l3);
		when(repository.save(landlord3)).thenReturn(landlord3);
		assertEquals(landlordd3.getLandlordAge(),service.updateLandlord(landlord3.getLandlordId(),landlordd3).getLandlordAge());
		assertEquals(landlordd3.getLandlordName(),service.updateLandlord(landlord3.getLandlordId(),landlordd3).getLandlordName());
		assertEquals(landlordd3.getFlatList(),service.updateLandlord(landlord3.getLandlordId(),landlordd3).getFlatList());
	}
	
	
	/** 
	 * @throws LandlordNotFoundException
	 */
	@Test
	public void testUpdateLandlord2() throws LandlordNotFoundException {
		when(repository.existsById(landlord1.getLandlordId())).thenReturn(false);
		LandlordNotFoundException exception=assertThrows(LandlordNotFoundException.class,()->service.updateLandlord(landlordd1.getLandlordId(),landlordd1));
		assertEquals("Service.LANDLORD_NOT_FOUND", exception.getMessage());
	}
	
	
	/** 
	 * @throws LandlordNotFoundException
	 */
	@Test
	public void testDeleteLandlord1() throws LandlordNotFoundException{
		when(repository.existsById(landlord3.getLandlordId())).thenReturn(true);
		when(repository.findById(landlord3.getLandlordId())).thenReturn(l3);
		service.deleteLandlord(landlord3.getLandlordId());
		verify(repository).deleteById(landlord3.getLandlordId());
	}
	
	
	/** 
	 * @throws LandlordNotFoundException
	 */
	@Test
	public void testDeleteLandlord2() throws LandlordNotFoundException {
		when(repository.existsById(landlord1.getLandlordId())).thenReturn(false);
		LandlordNotFoundException exception=assertThrows(LandlordNotFoundException.class,()->service.deleteLandlord(landlord1.getLandlordId()));
		assertEquals("Service.LANDLORD_NOT_FOUND", exception.getMessage());
	}
	
	
	
	/** 
	 * @throws LandlordNotFoundException
	 */
	@Test
	public void testViewLandlord1() throws LandlordNotFoundException{
		when(repository.existsById(landlord3.getLandlordId())).thenReturn(true);
		when(repository.findById(landlord3.getLandlordId())).thenReturn(l3);
		assertEquals(landlordd3.getLandlordAge(),service.viewLandlord(landlordd3.getLandlordId()).getLandlordAge());
		assertEquals(landlordd3.getLandlordId(),service.viewLandlord(landlordd3.getLandlordId()).getLandlordId());
		assertEquals(landlordd3.getLandlordName(),service.viewLandlord(landlordd3.getLandlordId()).getLandlordName());
		assertEquals(landlordd3.getFlatList(),service.viewLandlord(landlordd3.getLandlordId()).getFlatList());
	}
	
	
	/** 
	 * @throws LandlordNotFoundException
	 */
	@Test
	public void testViewLandlord2() throws LandlordNotFoundException {
		when(repository.existsById(landlord1.getLandlordId())).thenReturn(false);
		LandlordNotFoundException exception=assertThrows(LandlordNotFoundException.class,()->service.viewLandlord(landlord1.getLandlordId()));
		assertEquals("Service.LANDLORD_NOT_FOUND", exception.getMessage());
	}
	
	@Test
	public void testViewAllLandlord() {
		List<Landlord> l = new ArrayList<Landlord>();
		l.add(landlord1);
		l.add(landlord2);
		when(repository.findAll()).thenReturn(l);
		assertEquals(l.size(), service.viewAllLandlord().size());
	
	}
	
	@AfterAll
	public static void end() {
		LOGGER.info("Landlord module testing ended");
	}

}
