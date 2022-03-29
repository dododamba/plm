package com.plm.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plm.dao.DocumentDAO;
import com.plm.model.Document;
import com.plm.repository.DocumentRepository;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Service  Document
|
|
|
|*/

@Service
public class DocumentService implements DocumentDAO {

	private DocumentRepository repository;

	@Autowired
	public DocumentService(DocumentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Document> all() {

		return repository.findAll();
	}

	@Override
	public void update(String userId, String reference, String version, int iteration, String documentAttribute1,
			String documentAttribute2) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (document.isReserved() && document.getReservedBy().equals(userId)) {

			document.setDocumentAttribute1(documentAttribute1);
			document.setDocumentAttribute2(documentAttribute2);

			repository.saveAndFlush(document);
		}

	}

	@Override
	public void create(Document document) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Document document) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserve(String userId, String reference, String version, int iteration) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);
    	
    	if (isNotLinkedToPart(document) && !document.isReserved() && !document.getLifeCycleTemplate().isFinal()) {

    		Document nextIteration = new Document(document.getReference(), document.getVersion(), iteration + 1);
    		
    		nextIteration.setReserved(true);
    		nextIteration.setReservedBy(userId);
    		
    		nextIteration.setLifeCycleTemplate(document.getLifeCycleTemplate());
    		nextIteration.setLifeCycleState(document.getLifeCycleState());

    		nextIteration.setVersionSchema(document.getVersionSchema());
    		
    		nextIteration.setDocumentAttribute1(document.getDocumentAttribute1());
    		nextIteration.setDocumentAttribute2(document.getDocumentAttribute2());
    		
    		repository.save(nextIteration);
    	}

	}

	@Override
	public void free(String userId, String reference, String version, int iteration) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (isNotLinkedToPart(document) && document.isReserved() && document.getReservedBy().equals(userId)) {

			document.setReserved(false);
			document.setReservedBy(null);

			repository.saveAndFlush(document);
		}

	}

	@Override
	public void setState(String userId, String reference, String version, int iteration, String state) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (isNotLinkedToPart(document) && !document.isReserved() && document.getLifeCycleTemplate().isKnow()) {

			document.setLifeCycleState(state);

			repository.saveAndFlush(document);
		}

	}

	@Override
	public void revise(String userId, String reference, String version, int iteration) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (isNotLinkedToPart(document) && !document.isReserved() && !document.getLifeCycleTemplate().isFinal()) {

			Document nextIteration = new Document(document.getReference(), document.getVersion(), iteration + 1);

			nextIteration.setReserved(true);
			nextIteration.setReservedBy(userId);

			nextIteration.setLifeCycleTemplate(document.getLifeCycleTemplate());
			nextIteration.setLifeCycleState(document.getLifeCycleState());

			nextIteration.setVersionSchema(document.getVersionSchema());

			nextIteration.setDocumentAttribute1(document.getDocumentAttribute1());
			nextIteration.setDocumentAttribute2(document.getDocumentAttribute2());

			repository.save(nextIteration);
		}

	}

	@Override
	public boolean isNotLinkedToPart(Document document) {
		// TODO Auto-generated method stub
		return false;
	}

}
