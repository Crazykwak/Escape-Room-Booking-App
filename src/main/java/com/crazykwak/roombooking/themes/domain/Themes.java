package com.crazykwak.roombooking.themes.domain;

import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.themestime.domain.ThemesTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Themes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "themes_id")
    private Long id;
    private String name;
    private String hard;
    private Integer people;
    private Integer time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "themes")
    private List<ThemesTime> themesTimes = new ArrayList<>();

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
