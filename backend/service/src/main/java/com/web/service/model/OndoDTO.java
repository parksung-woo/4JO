package com.web.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OndoDTO {
    private String temperature;
    private String humidity;
    private String nowDatetime;
}
