package com.web.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
    private String member_id;
    private String member_name;
    private String member_password;
    private String member_email;
    private String member_phone;

}
