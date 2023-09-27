package com.zealsoft.jds.repository;

import com.zealsoft.jds.model.Location;
import com.zealsoft.jds.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "place", path = "place")
public interface PlaceRepository extends MongoRepository<Place, String> {

    List<Place> findAllByLocation(@Param("location") Location location);

}
