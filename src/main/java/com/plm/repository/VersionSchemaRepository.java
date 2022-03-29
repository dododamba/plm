package com.plm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plm.model.VersionSchema;


/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Repository  VersionSchema
|
|
|
|*/

@Repository

public interface VersionSchemaRepository extends JpaRepository<VersionSchema, Long> {

}
