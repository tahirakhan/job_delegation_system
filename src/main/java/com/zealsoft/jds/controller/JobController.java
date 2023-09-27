package com.zealsoft.jds.controller;

import com.zealsoft.jds.model.JOBSTATUS;
import com.zealsoft.jds.model.Job;
import com.zealsoft.jds.model.Lawyer;
import com.zealsoft.jds.repository.JobRepository;
import com.zealsoft.jds.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job")
public class JobController {

    private final JobRepository jobRepository;
    private final LawyerRepository lawyerRepository;

    @Autowired
    public JobController(JobRepository jobRepository, LawyerRepository lawyerRepository) {
        this.jobRepository = jobRepository;
        this.lawyerRepository = lawyerRepository;
    }

    @PostMapping("/apply-for-job/{jobId}/lawyer/{lawyerId}")
    public Job applyForJob(@PathVariable String jobId, @PathVariable String lawyerId) {
        Optional<Lawyer> lawyer = lawyerRepository.findById(lawyerId);
        Optional<Job> job = jobRepository.findById(jobId);

        if (job.isPresent() && lawyer.isPresent()) {
            Job jobToUpdate = job.get();
            jobToUpdate.getApplicantsList().add(lawyerId);
            return jobRepository.save(jobToUpdate);
        }

        return null;
    }

    @PostMapping("/assign-job-to-applicant/{jobId}/lawyer/{lawyerId}")
    public Job assignJobToApplicant(@PathVariable String jobId, @PathVariable String lawyerId) {
        Optional<Lawyer> lawyer = lawyerRepository.findById(lawyerId);
        Optional<Job> job = jobRepository.findById(jobId);

        if (job.isPresent() && lawyer.isPresent()) {
            Job jobToUpdate = job.get();
            jobToUpdate.setAssignedTo(lawyerId);
            jobToUpdate.setAssignedOn(new Date());
            jobToUpdate.setStatus(JOBSTATUS.ASSIGNED);
            return jobRepository.save(jobToUpdate);
        }

        return null;
    }
    @GetMapping("/find-by-status")
    public Page<Job> getEntitiesByStatus(
            @RequestParam(name = "status", required = false) String status ,
            Pageable pageable) {
        if(status != null){
            return jobRepository.findByStatus(status, pageable);
        }
        else
            return jobRepository.findAll(pageable);
    }

    @GetMapping("/jobs-applied-for-by-lawyer/lawyer/{lawyerId}")
    public List<Job> getListOfJobsLawyerHasAppliedFor(@PathVariable String lawyerId) {
        Optional<Lawyer> lawyer = lawyerRepository.findById(lawyerId);

        if (lawyer.isPresent()) {
            Lawyer applicant = lawyer.get();
            return jobRepository.findAllByApplicantsListContaining(applicant.getId());
        }

        return null;
    }

    @GetMapping("/jobs-assigned-to-lawyer/lawyer/{lawyerId}")
    public List<Job> getListOfJobsAssignedToLawyer(@PathVariable String lawyerId) {
        Optional<Lawyer> lawyer = lawyerRepository.findById(lawyerId);

        if (lawyer.isPresent()) {
            Lawyer applicant = lawyer.get();
            return jobRepository.findAllByAssignedTo(applicant.getId());
        }

        return null;
    }


    @GetMapping("/jobs-created-by-lawyer/lawyer/{lawyerId}")
    public List<Job> getListOfJobsICreated(@PathVariable String lawyerId) {
        Optional<Lawyer> lawyer = lawyerRepository.findById(lawyerId);

        if (lawyer.isPresent()) {
            Lawyer applicant = lawyer.get();
            return jobRepository.findAllByCreator(applicant.getId());
        }

        return null;
    }

    @PostMapping("/create-job")
    public Job createJob(@RequestBody Job request ) {
        Job job = jobRepository.save(request);

        if (job != null) {

            return job;
        }
        return null;
    }
}