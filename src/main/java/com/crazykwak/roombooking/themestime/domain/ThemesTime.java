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
    @Column(name = "themes_time_id")
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    private Integer round;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "themes_id")
    private Themes themes;

    @OneToOne(mappedBy = "themesTime")
    private Booking booking;

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
