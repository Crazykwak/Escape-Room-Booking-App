package com.crazykwak.roombooking.franchise.domain;

import com.crazykwak.roombooking.store.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY)
    List<Store> stores = new ArrayList<>();

    public Franchise(String name, String address, String tel, String homepage) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.homepage = homepage;
    }
}
