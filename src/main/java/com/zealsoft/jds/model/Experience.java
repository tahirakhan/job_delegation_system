package com.zealsoft.jds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Experience {
    private String designation;
    private String organization;
    private Date fromDate;
    private Date toDate;
}
