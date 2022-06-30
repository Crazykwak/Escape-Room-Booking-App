package com.crazykwak.roombooking.themestag.domain;

import com.crazykwak.roombooking.tag.domain.Tag;
import com.crazykwak.roombooking.themes.domain.Themes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ThemesTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "themes_id")
    private Themes themes;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;


}
