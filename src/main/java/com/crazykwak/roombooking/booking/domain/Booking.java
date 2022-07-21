package com.crazykwak.roombooking.booking.domain;

import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.themestime.domain.ThemesTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;
    private LocalDateTime bookingTime;
    private Integer people;
    private String payment;
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "themes_time_id")
    private ThemesTime themesTime;

    public Booking(LocalDateTime bookingTime, Integer people, String payment, Long price, Member member, ThemesTime themesTime) {
        this.bookingTime = bookingTime;
        this.people = people;
        this.payment = payment;
        this.price = price;
        this.member = member;
        this.themesTime = themesTime;
    }
}
