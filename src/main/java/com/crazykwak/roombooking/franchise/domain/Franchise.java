package com.crazykwak.roombooking.franchise.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Franchise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long franchiseId;
    String name;
    String address;
    String tel;
    String homepage;

}
