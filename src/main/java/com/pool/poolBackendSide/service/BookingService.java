package com.pool.poolBackendSide.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.pool.poolBackendSide.dto.BookingDTO;
import com.pool.poolBackendSide.dto.DeletedBookingDTO;
import com.pool.poolBackendSide.entity.AppUser;
import com.pool.poolBackendSide.entity.Booking;
import com.pool.poolBackendSide.entity.Customer;
import com.pool.poolBackendSide.entity.SwimmingPool;
import com.pool.poolBackendSide.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SwimmingPoolService swimmingPoolService;

    public Booking save(BookingDTO bookingDTO)
    {
        AppUser appUser = appUserService.findByEmail(bookingDTO.getEmail());
        Customer customer = customerService.findByAppUser(appUser);
        Optional<SwimmingPool> sp = swimmingPoolService.findPool(bookingDTO.getPoolId());
        SwimmingPool swimmingPool = sp.get();
        String ownerMail = swimmingPool.getUsername();
        Booking booking = new Booking();

        booking.setPid(bookingDTO.getPoolId());
        booking.setCustomer(customer);
        booking.setSwimmingPool(swimmingPool);
        booking.setSwimmingPoolName(swimmingPool.getTitle());
        booking.setUserEmail(ownerMail);
        booking.setCustEmail(bookingDTO.getEmail());
        booking.setDate(bookingDTO.getDate());
        booking.setTime(bookingDTO.getTime());
        booking.setQuantity(bookingDTO.getQuantity());

        return bookingRepository.save(booking);
    }

    public Iterable<Booking> load(String email)
    {
        List<Booking> booking = new ArrayList<>();
        Iterable<Booking> bookings = bookingRepository.findAll();
        for(Booking book : bookings)
        {
            if(book.getUserEmail().equals(email))
            {
                booking.add(book);
            }
        }
        return booking;
    }


    public DeletedBookingDTO delete(Integer id)
    {
        DeletedBookingDTO deletedBookingDTO = new DeletedBookingDTO();
        deletedBookingDTO.setMessage("Booking deleted successfully");
        deletedBookingDTO.setStatus(true);
        bookingRepository.deleteById(id);
        return deletedBookingDTO ;
    }

    // listing all the bookings for customer side.
    public Iterable<Booking> loadCustBooking(String email)
    {
        List<Booking> booking = new ArrayList<>();
        Iterable<Booking> bookings = bookingRepository.findAll();
        for(Booking book : bookings)
        {
            if(book.getCustEmail().equals(email))
            {
                booking.add(book);
            }
        }
        return booking;
    }

    //find booking by id
    public Optional<Booking> findBooking(Integer id)
    {
        return bookingRepository.findById(id);
    }


    public Booking update(BookingDTO bookingDTO) {
        AppUser appUser = appUserService.findByEmail(bookingDTO.getEmail());
        Customer customer = customerService.findByAppUser(appUser);
        Optional<SwimmingPool> sp = swimmingPoolService.findPool(bookingDTO.getPoolId());
        SwimmingPool swimmingPool = sp.get();
        String ownerMail = swimmingPool.getUsername();
        Booking booking = new Booking();

        booking.setPid(bookingDTO.getId());
        booking.setId(bookingDTO.getId());
        booking.setCustomer(customer);
        booking.setSwimmingPool(swimmingPool);
        booking.setSwimmingPoolName(swimmingPool.getTitle());
        booking.setUserEmail(ownerMail);
        booking.setCustEmail(bookingDTO.getEmail());
        booking.setDate(bookingDTO.getDate());
        booking.setTime(bookingDTO.getTime());
        booking.setQuantity(bookingDTO.getQuantity());

        return bookingRepository.save(booking);
    }
}
