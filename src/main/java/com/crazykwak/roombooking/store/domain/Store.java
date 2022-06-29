package com.crazykwak.roombooking.store.domain;

import com.crazykwak.roombooking.franchise.domain.Franchise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public Store(String storeName, String tel, String address, String info, Franchise franchise) {
        this.storeName = storeName;
        this.tel = tel;
        this.address = address;
        this.info = info;
        this.franchise = franchise;
    }
}
