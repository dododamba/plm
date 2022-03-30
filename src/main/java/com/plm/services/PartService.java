package com.plm.services;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plm.dao.PartDAO;
import com.plm.model.Document;
import com.plm.model.Part;
import com.plm.repository.DocumentRepository;
import com.plm.repository.PartRepository;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Service  Part
|
|
|
|*/

@Service
@Transactional
public class PartService implements PartDAO {
	private PartRepository partRepository;
	private DocumentRepository documentRepository;

	@Autowired
	public PartService(PartRepository partRepository, DocumentRepository documentRepository) {
		this.partRepository = partRepository;
		this.documentRepository = documentRepository;
	}

	public boolean reserve(String userId, String reference, String version, int iteration) {

		Part part = partRepository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (!part.isReserved() && !part.getLifeCycleTemplate().isFinal()) {

			Part nextPartIteration = new Part(part.getReference(), part.getVersion(), iteration + 1);

			nextPartIteration.setReserved(true);
			nextPartIteration.setReservedBy(userId);

			nextPartIteration.setLifeCycleTemplate(part.getLifeCycleTemplate());
			nextPartIteration.setLifeCycleState(part.getLifeCycleState());

			nextPartIteration.setVersionSchema(part.getVersionSchema());

			nextPartIteration.setPartAttribute1(part.getPartAttribute1());
			nextPartIteration.setPartAttribute2(part.getPartAttribute2());

			partRepository.save(nextPartIteration);

			for (Document document : getLinkedDocuments(part)) {
				Document nextIteration = new Document(document.getReference(), document.getVersion(), iteration + 1);

				nextIteration.setReserved(true);
				nextIteration.setReservedBy(userId);

				nextIteration.setLifeCycleTemplate(document.getLifeCycleTemplate());
				nextIteration.setLifeCycleState(document.getLifeCycleState());

				nextIteration.setVersionSchema(document.getVersionSchema());

				nextIteration.setDocumentAttribute1(document.getDocumentAttribute1());
				nextIteration.setDocumentAttribute2(document.getDocumentAttribute2());

				documentRepository.save(nextIteration);
				return true;
			}

		}

		return false;
	}

	public boolean update(String userId, String reference, String version, int iteration, String partAttribute1,
			String partAttribute2) {

		Part part = partRepository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (part.isReserved() && part.getReservedBy().equals(userId)) {

			part.setPartAttribute1(partAttribute1);
			part.setPartAttribute2(partAttribute2);

			partRepository.saveAndFlush(part);
			return true;
		}
		return false;
	}

	public boolean free(String userId, String reference, String version, int iteration) {

		Part part = partRepository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (part.isReserved() && part.getReservedBy().equals(userId)) {

			part.setReserved(false);
			part.setReservedBy(null);

			partRepository.saveAndFlush(part);

			for (Document document : getLinkedDocuments(part)) {

				document.setReserved(false);
				document.setReservedBy(null);

				documentRepository.saveAndFlush(document);
				return true;
			}
		}

		return false;
	}

	public boolean setState(String userId, String reference, String version, int iteration, String state) {

		Part part = partRepository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (!part.isReserved() && part.getLifeCycleTemplate().isKnow()) {

			part.setLifeCycleState(state);

			partRepository.saveAndFlush(part);

			for (Document document : getLinkedDocuments(part)) {

				document.setLifeCycleState(state);

				documentRepository.saveAndFlush(document);

				return false;
			}
		}

		return false;
	}

	public boolean revise(String userId, String reference, String version, int iteration) {

		Part part = partRepository.findByReferenceAndVersionAndIteration(reference, version, iteration);

		if (!part.isReserved() && part.getLifeCycleTemplate().isFinal()) {

			Part nextPartVersion = new Part(part.getReference(), part.getVersionSchema().getNextVersionLabel(), 1);

			nextPartVersion.setReserved(false);
			nextPartVersion.setReservedBy(null);

			nextPartVersion.setLifeCycleTemplate(part.getLifeCycleTemplate());
			nextPartVersion.setLifeCycleState(part.getLifeCycleTemplate().getInitialState());

			nextPartVersion.setVersionSchema(part.getVersionSchema());

			nextPartVersion.setPartAttribute1(part.getPartAttribute1());
			nextPartVersion.setPartAttribute2(part.getPartAttribute2());

			partRepository.save(nextPartVersion);

			for (Document document : getLinkedDocuments(part)) {

				Document nextDocumentVersion = new Document(document.getReference(),
						document.getVersionSchema().getNextVersionLabel(), 1);

				nextDocumentVersion.setReserved(false);
				nextDocumentVersion.setReservedBy(null);

				nextDocumentVersion.setLifeCycleTemplate(document.getLifeCycleTemplate());
				nextDocumentVersion.setLifeCycleState(document.getLifeCycleTemplate().getInitialState());

				nextDocumentVersion.setVersionSchema(document.getVersionSchema());

				nextDocumentVersion.setDocumentAttribute1(document.getDocumentAttribute1());
				nextDocumentVersion.setDocumentAttribute2(document.getDocumentAttribute2());

				documentRepository.save(nextDocumentVersion);

				return true;
			}

		}
		return false;
	}

	@Override
	public void update(Part part) {
		partRepository.saveAndFlush(part);

	}

	@Override
	public void create(Part part) {
		partRepository.save(part);

	}

	@Override
	public Set<Document> getLinkedDocuments(Part part) {

		return null;
	}

	@Override
	public void delete(Part part) {
	  partRepository.delete(part);

	}

	@Override
	public Collection<Part> all() {
		// TODO Auto-generated method stub
		return partRepository.findAll();
	}

}
