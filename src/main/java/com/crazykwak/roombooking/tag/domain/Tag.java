package com.crazykwak.roombooking.tag.domain;

import com.crazykwak.roombooking.themes.domain.Themes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
