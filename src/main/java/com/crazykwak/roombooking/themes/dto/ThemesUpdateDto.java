package com.crazykwak.roombooking.themes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThemesUpdateDto {

    String name;
    String hard;
    Integer people;
    Integer time;


}
