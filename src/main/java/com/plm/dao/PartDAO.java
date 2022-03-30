package com.plm.dao;

import java.util.Collection;
import java.util.Set;

import com.plm.model.Document;
import com.plm.model.Part;

public interface PartDAO {
	void update(Part part);


	Set<Document> getLinkedDocuments(Part part);

	boolean update(String userId, String reference, String version, int iteration, String documentAttribute1,
			String documentAttribute2);

	void create(Part part);

	void delete(Part part);

	boolean reserve(String userId, String reference, String version, int iteration);

	boolean free(String userId, String reference, String version, int iteration);

	boolean setState(String userId, String reference, String version, int iteration, String state);

	boolean revise(String userId, String reference, String version, int iteration);
	
	Collection<Part> all();

}
