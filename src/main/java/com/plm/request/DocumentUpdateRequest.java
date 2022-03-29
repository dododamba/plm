package com.plm.request;

import org.springframework.web.bind.annotation.RequestParam;

public class DocumentUpdateRequest {

	private String reference;
	private String version;
	private int iteration;
	private String documentAttribute1;
	private String documentAttribute2;
	
	public DocumentUpdateRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}

	/**
	 * @param iteration the iteration to set
	 */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	/**
	 * @return the documentAttribute1
	 */
	public String getDocumentAttribute1() {
		return documentAttribute1;
	}

	/**
	 * @param documentAttribute1 the documentAttribute1 to set
	 */
	public void setDocumentAttribute1(String documentAttribute1) {
		this.documentAttribute1 = documentAttribute1;
	}

	/**
	 * @return the documentAttribute2
	 */
	public String getDocumentAttribute2() {
		return documentAttribute2;
	}

	/**
	 * @param documentAttribute2 the documentAttribute2 to set
	 */
	public void setDocumentAttribute2(String documentAttribute2) {
		this.documentAttribute2 = documentAttribute2;
	}
	
	
}
