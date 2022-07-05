package com.crazykwak.roombooking.themes.domain;

import com.crazykwak.roombooking.store.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Themes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String hard;
    Integer people;
    Integer time;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Store store;

    public void setName(String name) {
        this.name = name;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Themes(String name, String hard, Integer people, Integer time, Store store) {
        this.name = name;
        this.hard = hard;
        this.people = people;
        this.time = time;
        this.store = store;
    }
}
