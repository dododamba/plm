package com.plm.dao;

import java.util.Set;

import com.plm.model.Document;
import com.plm.model.Part;

public interface PartDAO {
	void update(Part part);
	void create(Part part);
	void reserve(String userId, String reference, String version, int iteration);

	void free(String userId, String reference, String version, int iteration);

	void setState(String userId, String reference, String version, int iteration, String state);

	void revise(String userId, String reference, String version, int iteration);

	Set<Document> getLinkedDocuments(Part part);
}
