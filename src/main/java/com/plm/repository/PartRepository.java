package com.plm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plm.model.Part;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Repository  Part
|
|
|
|*/

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
	
	Part findByReferenceAndVersionAndIteration(String reference,String version,int iteration);

}
