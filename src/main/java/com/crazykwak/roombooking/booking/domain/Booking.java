package com.crazykwak.roombooking.booking.domain;

import com.crazykwak.roombooking.member.domain.Member;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date;
    Integer people;
    String payment;
    Long price;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;
}
