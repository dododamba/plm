package com.plm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plm.model.Document;
import org.springframework.stereotype.Repository;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Repository  Document
|
|
|
|*/


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	Document findByReferenceAndVersionAndIteration(String reference, String version, int iteration);
}
