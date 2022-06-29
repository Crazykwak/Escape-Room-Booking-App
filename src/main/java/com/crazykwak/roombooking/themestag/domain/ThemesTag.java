package com.crazykwak.roombooking.themestag.domain;

import javax.persistence.*;

@Entity
public class ThemesTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "themes_id")
    private Long themesId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Long tagId;


}
