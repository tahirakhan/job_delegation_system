package com.zealsoft.jds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class Job {
    @Id
    String id;
    String jobTitle;
    String description;
    long price;
    Date jobStartDate;
    Date jobEndDate;
    String creator;
    String assignedTo;
    List<String> applicantsList = new ArrayList<>();
    Date assignedOn;
    JOBSTATUS status;
    String offense;
    Place address;



}
