package com.cbt.adminservicesep23;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullUserDetail {

    Userdetail userdetail;
    List<String> types; // SHOULD BE A SET OF POSSIBLE VALUES (BUYER|SELLER|ADMIN|LP)

}
