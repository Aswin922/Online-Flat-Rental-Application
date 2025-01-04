package com.cg.onlineflatrental.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.cg.onlineflatrental.entity.FlatAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlineflatrental.DTO.FlatAddressDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.repository.IFlatRepository;

@SpringBootTest
public class FlatServiceTest {

    @Autowired
    private FlatService flatService;

    @MockBean
    private IFlatRepository flatRepository;

    private static final Logger LOGGER = LogManager.getLogger(FlatServiceTest.class);

    Flat f1, f2, f3;
    FlatDTO fd1,fd2,fd3;
    Optional<Flat> f4, f5, f6;

    @BeforeAll
    public static void initBefore() {
        LOGGER.info("Flat module testing initialized");
    }

    @BeforeEach
    public void init() {
        f1 = new Flat(1, 2000, new FlatAddress(10,"Street1","City1","State1",123456,"Country1"),"available");
        f2 = new Flat(2, 4000, new FlatAddress(20,"Street2","City2","State2",234567,"Country2"),"available");
        f3 = new Flat(3, 6000, new FlatAddress(30,"Street3","City3","State3",345678,"Country3"),"available");

        fd1 = new FlatDTO(1, 2000, new FlatAddressDTO(10,"Street1","City1","State1",123456,"Country1"),"available");
        fd2 = new FlatDTO(2, 4000, new FlatAddressDTO(20,"Street2","City2","State2",234567,"Country2"),"available");
        fd3 = new FlatDTO(3, 6000, new FlatAddressDTO(30,"Street3","City3","State3",345678,"Country3"),"available");
        
        f4 = Optional.of(f1);
        f5 = Optional.of(f2);
        f6 = Optional.of(f3);
    }

    @Test
    public void testAddFlat1() {
        when(flatRepository.save(f1)).thenReturn(f1);
        assertEquals(fd1.getFlatId(),flatService.addFlat(fd1).getFlatId());
        assertEquals(fd1.getCost(),flatService.addFlat(fd1).getCost());
        assertEquals(fd1.getFlatAddress(),flatService.addFlat(fd1).getFlatAddress());
        assertEquals(fd1.getAvailability(),flatService.addFlat(fd1).getAvailability());
    }

    @Test
    public void testAddFlat2() {
        when(flatRepository.save(f1)).thenReturn(f1);
        assertNotNull(flatService.addFlat(fd1));
    }

    
    /** 
     * @throws FlatNotFoundException
     */
    @Test
    public void testUpdateFlat1() throws FlatNotFoundException {
        when(flatRepository.existsById(f2.getFlatId())).thenReturn(true);
        when(flatRepository.findById(f2.getFlatId())).thenReturn(f5);
        when(flatRepository.save(f2)).thenReturn(f2);
        assertEquals(fd2.getCost(),flatService.updateFlat(fd2, fd2.getFlatId()).getCost());
        assertEquals(fd2.getFlatAddress(),flatService.updateFlat(fd2,fd2.getFlatId()).getFlatAddress());
        assertEquals(fd2.getAvailability(),flatService.updateFlat(fd2,fd2.getFlatId()).getAvailability());
    }

    
    /** 
     * @throws FlatNotFoundException
     */
    @Test
    public void testUpdateFlat2() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(false);
        FlatNotFoundException exception=assertThrows(FlatNotFoundException.class,()->flatService.updateFlat(fd1,fd1.getFlatId()));
        assertEquals("Service.FLAT_NOT_FOUND", exception.getMessage());
    }

    
    /** 
     * @throws FlatNotFoundException
     */
    @Test
    public void testDeleteFlat1() throws FlatNotFoundException{
        when(flatRepository.existsById(f3.getFlatId())).thenReturn(true);
        when(flatRepository.findById(f3.getFlatId())).thenReturn(f6);
        flatService.deleteFlat(f3.getFlatId());
        verify(flatRepository).delete(f3);
    }

    
    /** 
     * @throws FlatNotFoundException
     */
    @Test
    public void testDeleteFlat2() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(false);
        FlatNotFoundException exception=assertThrows(FlatNotFoundException.class,()->flatService.deleteFlat(f1.getFlatId()));
        assertEquals("Service.FLAT_NOT_FOUND", exception.getMessage());
    }

    
    /** 
     * @throws FlatNotFoundException
     */
    @Test
    public void testViewFlat1() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(true);
        when(flatRepository.findById(f1.getFlatId())).thenReturn(f4);
        assertEquals(fd1.getFlatId(),flatService.viewFlat(fd1.getFlatId()).getFlatId());
        assertEquals(fd1.getCost(),flatService.viewFlat(fd1.getFlatId()).getCost());
        assertEquals(fd1.getFlatAddress().getHouseNo(),flatService.viewFlat(fd1.getFlatId()).getFlatAddress().getHouseNo());
        assertEquals(fd1.getAvailability(),flatService.viewFlat(fd1.getFlatId()).getAvailability());
    }

    
    /** 
     * @throws FlatNotFoundException
     */
    @Test
    public void testViewFlat2() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(false);
        FlatNotFoundException exception=assertThrows(FlatNotFoundException.class,()->flatService.viewFlat(fd1.getFlatId()));
        assertEquals("Service.FLAT_NOT_FOUND", exception.getMessage());
    }

    @Test
    public void testViewAllFlats() {
        List<Flat> f = new ArrayList<>();
        f.add(f1);
        f.add(f2);
        f.add(f3);
        when(flatRepository.findAll()).thenReturn(f);
        assertEquals(f.size(), flatService.viewAllFlat().size());
    }

    @Test
    public void testFindFlatsByCostAndAvailability() {
        List<Flat> f = new ArrayList<>();
        f.add(f1);
        f.add(f2);
        f.add(f3);
        List<Flat> fca = new ArrayList<>();
        for (Flat flat : f) {
            if (flat.getFlatId() == f2.getFlatId() && Objects.equals(flat.getAvailability(), f2.getAvailability())) {
                fca.add(flat);
            }
        }
        when(flatRepository.findByCostAndAvailability(f2.getCost(), f2.getAvailability())).thenReturn(fca);
        assertEquals(1,fca.size());
    }

    @AfterAll
    public static void end() {
        LOGGER.info("Flat module testing ended");
    }

}
