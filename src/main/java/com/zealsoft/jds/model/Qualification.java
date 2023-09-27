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
public class Qualification {
    String qualificationSummary;
    String degree;
    String institute;
    String year;
    String pinNumber;
    Date enrollmentDate;
}
