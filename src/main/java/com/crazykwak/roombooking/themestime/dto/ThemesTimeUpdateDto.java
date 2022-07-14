package com.crazykwak.roombooking.themestime.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThemesTimeUpdateDto {

    LocalDateTime startTime;
    Integer round;
}
