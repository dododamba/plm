package com.plm.dao;

import java.util.Collection;

import com.plm.model.Document;

public interface DocumentDAO {
	

	Collection<Document> all();	
	
	void update(String userId, String reference, String version, int iteration, String documentAttribute1, String documentAttribute2);

	void create(Document document);

	void delete(Document document);
	
	void reserve(String userId, String reference, String version, int iteration);
	void free(String userId, String reference, String version, int iteration);
	void setState(String userId, String reference, String version, int iteration, String state);
	void revise(String userId, String reference, String version, int iteration);
	boolean isNotLinkedToPart(Document document);
	
	
}
