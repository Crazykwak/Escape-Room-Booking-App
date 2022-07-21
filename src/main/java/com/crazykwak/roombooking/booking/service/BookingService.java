package com.crazykwak.roombooking.booking.service;

import com.crazykwak.roombooking.booking.domain.Booking;
import com.crazykwak.roombooking.booking.repository.BookingJpaRepository;
import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.repository.MemberRepository;
import com.crazykwak.roombooking.themestime.domain.ThemesTime;
import com.crazykwak.roombooking.themestime.repository.ThemesTimeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.crazykwak.roombooking.exception.ExceptionCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookingService {

    private final MemberRepository memberRepository;
    private final ThemesTimeJpaRepository themesTimeJpaRepository;
    private final BookingJpaRepository bookingJpaRepository;


    @Transactional
    public Booking createBook(Integer people, String payment, Long price, Long memberId, Long themesTimeId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(MEMBER_NOT_FOUND));

        ThemesTime themesTime = themesTimeJpaRepository.findById(themesTimeId)
                .orElseThrow(() -> new BusinessException(THEMESTIME_NOT_FOUND));

        Booking booking = new Booking(LocalDateTime.now(), people, payment, price, member, themesTime);
        themesTime.setBooking(booking);

        return bookingJpaRepository.save(booking);
    }
}
