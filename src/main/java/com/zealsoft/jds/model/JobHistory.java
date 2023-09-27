package com.zealsoft.jds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JobHistory {
    @Id
    private String id;
    String jobTitle;
    String description;
    long price;
    Date jobStartDate;
    Date jobEndDate;
    Lawyer creator;
    Lawyer assignedTo;
    Date assignedOn;
    JOBSTATUS status;


}
