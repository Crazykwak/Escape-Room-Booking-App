package com.crazykwak.roombooking.themes.domain;

import com.crazykwak.roombooking.store.domain.Store;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Themes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String hard;
    Integer people;
    Integer time;

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
}
