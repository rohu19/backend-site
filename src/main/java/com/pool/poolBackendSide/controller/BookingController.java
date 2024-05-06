package com.pool.poolBackendSide.controller;



import com.pool.poolBackendSide.dto.BookingDTO;
import com.pool.poolBackendSide.dto.DeletedBookingDTO;
import com.pool.poolBackendSide.entity.Booking;
import com.pool.poolBackendSide.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("booking")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;;


    @PostMapping("save")
    public ResponseEntity<Booking> save(@RequestBody BookingDTO bookingDTO)
    {
        return ResponseEntity.ok(bookingService.save(bookingDTO));
    }


    @GetMapping("load/{email}")
    public ResponseEntity<Iterable<Booking>> load(@PathVariable String email)
    {
        return ResponseEntity.ok(bookingService.load(email));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<DeletedBookingDTO> delete(@PathVariable Integer id)
    {
        return ResponseEntity.ok(bookingService.delete(id));
    }


    @GetMapping("loadCustBooking/{email}")
    public ResponseEntity<Iterable<Booking>> loadCustBooking(@PathVariable String email)
    {
        return ResponseEntity.ok(bookingService.loadCustBooking(email));
    }


    @GetMapping("findBooking/{id}")
    public ResponseEntity<Optional<Booking>> findBooking(@PathVariable Integer id)
    {
        return ResponseEntity.ok(bookingService.findBooking(id));
    }


    @PostMapping("update")
    public ResponseEntity<Booking> update(@RequestBody BookingDTO bookingDTO)
    {
        return ResponseEntity.ok(bookingService.update(bookingDTO));
    }
}

