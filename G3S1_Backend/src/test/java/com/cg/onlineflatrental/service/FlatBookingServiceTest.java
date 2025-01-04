package com.cg.onlineflatrental.service;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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



@SpringBootTest
public class FlatBookingServiceTest {

    @Autowired
    private FlatBookingService service;

    @MockBean
    private IFlatBookingRepository repository;

    Optional<FlatBooking> flatbookingo1,flatbookingo2;
    FlatBooking flatbooking1, flatbooking2,flatbooking3;

    private Flat flat1, flat2, flat3;
    private Tenant tenant1, tenant2, tenant3;
    
    FlatBookingDTO flatbookingd1, flatbookingd2;
    private FlatDTO flatd1, flatd2;
    private TenantDTO tenantd1, tenantd2;
    
    @BeforeEach		//Define flat list also for below test cases
    public void init() {
        LocalDate fromdate=LocalDate.of(2021,06, 20);
        LocalDate todate=LocalDate.of(2021,07, 19);
        flat1 = new Flat(1, 2000, new FlatAddress(10,"Street1","City1","State1",123456,"Country1"),"available");
        flat2 = new Flat(2, 4000, new FlatAddress(20,"Street2","City2","State2",234567,"Country2"),"available");
        flat3 = new Flat(3, 6000, new FlatAddress(30,"Street3","City3","State3",345678,"Country3"),"available");

        tenant1=new Tenant(1, 10, new FlatAddress(10,"Street1","City1","State1",123456,"Country1"));
        tenant2=new Tenant(2, 20, new FlatAddress(20,"Street2","City2","State2",234567,"Country2"));
        tenant3=new Tenant(3, 30, new FlatAddress(30,"Street3","City3","State3",345678,"Country3"));
        
        flatbooking1 = new FlatBooking(1, flat1, tenant1, fromdate, todate);
        flatbooking2 = new FlatBooking(2, flat2, tenant2, fromdate, todate);
        flatbooking3 = new FlatBooking(3, flat3, tenant3, fromdate ,todate);
        
        flatbookingo1=Optional.of(flatbooking1);
        flatbookingo2=Optional.of(flatbooking2);
        
        flatd1 = new FlatDTO(1, 2000, new FlatAddressDTO(10,"Street1","City1","State1",123456,"Country1"),"available");
        flatd2 = new FlatDTO(2, 4000, new FlatAddressDTO(20,"Street2","City2","State2",234567,"Country2"),"available");

        tenantd1=new TenantDTO(1, 10, new FlatAddressDTO(10,"Street1","City1","State1",123456,"Country1"));
        tenantd2=new TenantDTO(2, 20, new FlatAddressDTO(20,"Street2","City2","State2",234567,"Country2"));
        
        flatbookingd1 = new FlatBookingDTO(1, flatd1, tenantd1, fromdate, todate);
        flatbookingd2 = new FlatBookingDTO(2, flatd2, tenantd2, fromdate, todate);
    }

    @Test
    public void testAddFlatBooking() {
        when(repository.save(flatbooking1)).thenReturn(flatbooking1);
        assertEquals(flatbookingd1.getFlat().getFlatId(),service.addFlatBooking(flatbookingd1).getFlatId());
        assertEquals(flatbookingd1.getFlat().getCost(),service.addFlatBooking(flatbookingd1).getCost());
        assertEquals(flatbookingd1.getFlat().getFlatAddress(),service.addFlatBooking(flatbookingd1).getFlatAddress());
        assertEquals(flatbookingd1.getFlat().getAvailability(),service.addFlatBooking(flatbookingd1).getAvailability());
    }

    
    /** 
     * @throws FlatBookingNotFoundException
     */
    @Test
    public void testUpdateFlatBooking() throws FlatBookingNotFoundException {
        when(repository.findById(flatbooking2.getBookingNo())).thenReturn(flatbookingo2);
        when(repository.save(flatbooking2)).thenReturn(flatbooking2);
        assertEquals(flatbookingd2.getBookingNo(),service.updateFlatBooking(flatbookingd2,flatbookingd2.getBookingNo()).getBookingNo());
        assertEquals(flatbookingd2.getFlat().getFlatId(),service.updateFlatBooking(flatbookingd2,flatbookingd2.getBookingNo()).getFlat().getFlatId());
        assertEquals(flatbookingd2.getTenantId().getTenantId(),service.updateFlatBooking(flatbookingd2,flatbookingd2.getBookingNo()).getTenantId().getTenantId());
        assertEquals(flatbookingd2.getBookingFromDate(),service.updateFlatBooking(flatbookingd2,flatbookingd2.getBookingNo()).getBookingFromDate());
        assertEquals(flatbookingd2.getBookingToDate(),service.updateFlatBooking(flatbookingd2,flatbookingd2.getBookingNo()).getBookingToDate());
    }

    
    /** 
     * @throws FlatBookingNotFoundException
     */
    @Test
    public void testDeleteFlatBooking() throws FlatBookingNotFoundException {
        when(repository.findById(flatbooking2.getBookingNo())).thenReturn(flatbookingo2);
        service.deleteFlatBooking(flatbooking2.getBookingNo());
        verify(repository, times(1)).delete(flatbooking2);
    }

    
    /** 
     * @throws FlatBookingNotFoundException
     */
    @Test
    public void testViewFlatBooking() throws FlatBookingNotFoundException {
        when(repository.findById(flatbooking1.getBookingNo())).thenReturn(flatbookingo1);
        assertEquals(flatbookingd1.getBookingNo(),service.viewFlatBooking(flatbookingd1.getBookingNo()).getBookingNo());
        assertEquals(flatbookingd1.getFlat().getFlatId(),service.viewFlatBooking(flatbookingd1.getBookingNo()).getFlat().getFlatId());
        assertEquals(flatbookingd1.getTenantId().getTenantId(),service.viewFlatBooking(flatbookingd1.getBookingNo()).getTenantId().getTenantId());
        assertEquals(flatbookingd1.getBookingFromDate(),service.viewFlatBooking(flatbookingd1.getBookingNo()).getBookingFromDate());
        assertEquals(flatbookingd1.getBookingToDate(),service.viewFlatBooking(flatbookingd1.getBookingNo()).getBookingToDate());
    }

    @Test
    public void testViewAllFlatBooking() {
        List<FlatBooking> l = new ArrayList<FlatBooking>();
        l.add(flatbooking1);
        l.add(flatbooking2);
        l.add(flatbooking3);
        when(repository.findAll()).thenReturn(l);
        assertEquals(l.size(), service.viewAllFlatBooking().size());
    }

}