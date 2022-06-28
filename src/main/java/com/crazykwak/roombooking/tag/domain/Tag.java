package com.crazykwak.roombooking.tag.domain;

import com.crazykwak.roombooking.themes.domain.Themes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    Themes themes;
}
