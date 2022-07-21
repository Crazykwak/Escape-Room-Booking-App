package com.crazykwak.roombooking.booking.repository;

import com.crazykwak.roombooking.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingJpaRepository extends JpaRepository<Booking, Long> {
}
