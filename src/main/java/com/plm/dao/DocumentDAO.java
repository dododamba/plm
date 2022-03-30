package com.plm.dao;

import java.util.Collection;

import com.plm.model.Document;

public interface DocumentDAO {
	

	Collection<Document> all();	
	
	boolean update(String userId, String reference, String version, int iteration, String documentAttribute1, String documentAttribute2);

	void create(Document document);

	void delete(Document document);
	
	boolean reserve(String userId, String reference, String version, int iteration);
	boolean free(String userId, String reference, String version, int iteration);
	boolean setState(String userId, String reference, String version, int iteration, String state);
	boolean revise(String userId, String reference, String version, int iteration);
	boolean isNotLinkedToPart(Document document);
	
	
}
