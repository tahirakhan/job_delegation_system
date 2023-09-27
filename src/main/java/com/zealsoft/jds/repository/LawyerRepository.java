package com.zealsoft.jds.repository;

import com.zealsoft.jds.model.Lawyer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "lawyer", path = "lawyer")
public interface LawyerRepository extends MongoRepository<Lawyer, String> {

    Optional<Lawyer> findByEmailAndPassword(String email, String password);

}
