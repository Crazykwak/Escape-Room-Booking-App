package com.crazykwak.roombooking.store.domain;

import com.crazykwak.roombooking.franchise.domain.Franchise;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "store_name")
    String storeName;
    String tel;
    String address;
    String info;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    Franchise franchise;
}
