package com.zealsoft.jds.repository;

import com.zealsoft.jds.model.Job;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "job", path = "job")
public interface JobRepository extends MongoRepository<Job,String> {
    List<Job> findAllByApplicantsListContaining(@Param("applicant") String applicant);
    List<Job> findAllByAssignedTo(@Param("lawyer") String lawyer);
    List<Job> findAllByCreator(@Param("lawyer") String lawyer);
    Page<Job> findByStatus(@Param("status") String status, Pageable pageable);

}