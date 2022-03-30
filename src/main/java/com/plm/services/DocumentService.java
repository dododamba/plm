package com.plm.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
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
	public boolean update(String userId, String reference, String version, int iteration, String documentAttribute1,
			String documentAttribute2) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (document.isReserved() && document.getReservedBy().equals(userId)) {

			document.setDocumentAttribute1(documentAttribute1);
			document.setDocumentAttribute2(documentAttribute2);

			repository.saveAndFlush(document);

			return true;
		}

		return false;

	}

	@Override
	public void create(Document document) {
		repository.save(document);

	}

	@Override
	public void delete(Document document) {
		repository.delete(document);

	}

	@Override
	public boolean reserve(String userId, String reference, String version, int iteration) {
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
			return true;
		}

		return false;
	}

	@Override
	public boolean free(String userId, String reference, String version, int iteration) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (isNotLinkedToPart(document) && document.isReserved() && document.getReservedBy().equals(userId)) {

			document.setReserved(false);
			document.setReservedBy(null);

			repository.saveAndFlush(document);
			return true;
		}

		return false;

	}

	@Override
	public boolean setState(String userId, String reference, String version, int iteration, String state) {
		Document document = repository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (isNotLinkedToPart(document) && !document.isReserved() && document.getLifeCycleTemplate().isKnow()) {

			document.setLifeCycleState(state);

			repository.saveAndFlush(document);
			return true;
		}

		return false;

	}

	@Override
	public boolean revise(String userId, String reference, String version, int iteration) {
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
			return true;
		}

		return false;
	}

	@Override
	public boolean isNotLinkedToPart(Document document) {
		// TODO Auto-generated method stub
		return false;
	}

}
