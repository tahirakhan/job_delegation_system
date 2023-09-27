package com.zealsoft.jds.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Lawyer {

    @Id
    String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private String gender;
    private String linkedinLink;
    private String imageURL;
    private Place address;

    private List<Experience> experiences;
    private List<Skill> skills;
    private Qualification qualification;
    private String password;




}
