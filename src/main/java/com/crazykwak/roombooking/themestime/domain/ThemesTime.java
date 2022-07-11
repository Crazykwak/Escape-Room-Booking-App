package com.crazykwak.roombooking.themestime.domain;

import com.crazykwak.roombooking.booking.domain.Booking;
import com.crazykwak.roombooking.themes.domain.Themes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ThemesTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "start_time")
    LocalDateTime startTime;

    Integer round;

    @ManyToOne
    @JoinColumn(name = "themes_id")
    Themes themes;

    @OneToOne
    @JoinColumn(name = "booking_id")
    Booking booking;

}
