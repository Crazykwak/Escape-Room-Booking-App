package com.crazykwak.roombooking.franchise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiseUpdateDto {

    private Long franchiseId;
    private String name;
    private String address;
    private String tel;
    private String homepage;

}
