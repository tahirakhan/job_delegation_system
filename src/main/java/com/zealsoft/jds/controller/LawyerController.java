package com.zealsoft.jds.controller;

import com.zealsoft.jds.model.Job;
import com.zealsoft.jds.model.Lawyer;
import com.zealsoft.jds.repository.JobRepository;
import com.zealsoft.jds.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/lawyer")
public class LawyerController {


    private final JobRepository jobRepository;
    private final LawyerRepository lawyerRepository;

    @Autowired
    public LawyerController(JobRepository jobRepository, LawyerRepository lawyerRepository) {
        this.jobRepository = jobRepository;
        this.lawyerRepository = lawyerRepository;
    }

    @PostMapping("/signin")
    public Lawyer signin(@RequestBody Lawyer request ) {
        Optional<Lawyer> lawyer = lawyerRepository.findByEmailAndPassword(request.getEmail(),request.getPassword());

        if (lawyer.isPresent()) {

            return lawyer.get();
        }
        return null;
    }

    @PostMapping("/signup")
    public Lawyer signup(@RequestBody Lawyer request ) {
        Lawyer lawyer = lawyerRepository.save(request);

        if (lawyer != null) {

            return lawyer;
        }
        return null;
    }
}
