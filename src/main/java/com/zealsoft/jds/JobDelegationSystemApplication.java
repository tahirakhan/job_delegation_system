package com.zealsoft.jds;

import com.zealsoft.jds.model.Job;
import com.zealsoft.jds.model.Lawyer;
import com.zealsoft.jds.model.Notification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class JobDelegationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobDelegationSystemApplication.class, args);
    }

}
