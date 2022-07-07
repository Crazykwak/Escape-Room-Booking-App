package com.crazykwak.roombooking.themestag.domain;

import com.crazykwak.roombooking.tag.domain.Tag;
import com.crazykwak.roombooking.themes.domain.Themes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThemesTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "themes_id")
    private Themes themes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public ThemesTag(Themes themes, Tag tag) {
        this.themes = themes;
        this.tag = tag;
    }
}
