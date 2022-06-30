package com.crazykwak.roombooking.franchise.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Franchise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long franchiseId;
    String name;
    String address;
    String tel;
    String homepage;

    public Franchise(String name, String address, String tel, String homepage) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.homepage = homepage;
    }
}
