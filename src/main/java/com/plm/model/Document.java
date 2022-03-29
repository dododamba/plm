package com.plm.model;

import java.io.Serializable;
import javax.persistence.*;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Model  Document
|
|
|
|*/

@Entity
@Table(name = "documents")

public class Document implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	@Column(name = "id")
	private Long id;

	@Column
	private String reference;
	@Column
	private String version;
	@Column
	private int iteration;

	@Column
	private boolean reserved;
	@Column
	private String reservedBy;

	@ManyToOne
	private LifeCycleTemplate lifeCycleTemplate;
	@Column
	private String lifeCycleState;

	@ManyToOne
	private VersionSchema versionSchema;

	@Column
	private String documentAttribute1;
	@Column
	private String documentAttribute2;

	public Document() {

	}

	public Document(String reference, String version, int iteration) {
		this.reference = reference;
		this.version = version;
		this.iteration = iteration;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the reserved
	 */
	public boolean isReserved() {
		return reserved;
	}

	/**
	 * @param reserved the reserved to set
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	/**
	 * @return the reservedBy
	 */
	public String getReservedBy() {
		return reservedBy;
	}

	/**
	 * @param reservedBy the reservedBy to set
	 */
	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}

	/**
	 * @return the lifeCycleTemplate
	 */
	public LifeCycleTemplate getLifeCycleTemplate() {
		return lifeCycleTemplate;
	}

	/**
	 * @param lifeCycleTemplate the lifeCycleTemplate to set
	 */
	public void setLifeCycleTemplate(LifeCycleTemplate lifeCycleTemplate) {
		this.lifeCycleTemplate = lifeCycleTemplate;
	}

	/**
	 * @return the lifeCycleState
	 */
	public String getLifeCycleState() {
		return lifeCycleState;
	}

	/**
	 * @param lifeCycleState the lifeCycleState to set
	 */
	public void setLifeCycleState(String lifeCycleState) {
		this.lifeCycleState = lifeCycleState;
	}

	/**
	 * @return the versionSchema
	 */
	public VersionSchema getVersionSchema() {
		return versionSchema;
	}

	/**
	 * @param versionSchema the versionSchema to set
	 */
	public void setVersionSchema(VersionSchema versionSchema) {
		this.versionSchema = versionSchema;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentAttribute1 == null) ? 0 : documentAttribute1.hashCode());
		result = prime * result + ((documentAttribute2 == null) ? 0 : documentAttribute2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + iteration;
		result = prime * result + ((lifeCycleState == null) ? 0 : lifeCycleState.hashCode());
		result = prime * result + ((lifeCycleTemplate == null) ? 0 : lifeCycleTemplate.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + (reserved ? 1231 : 1237);
		result = prime * result + ((reservedBy == null) ? 0 : reservedBy.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((versionSchema == null) ? 0 : versionSchema.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", reference=" + reference + ", version=" + version + ", iteration=" + iteration
				+ ", reserved=" + reserved + ", reservedBy=" + reservedBy + ", lifeCycleTemplate=" + lifeCycleTemplate
				+ ", lifeCycleState=" + lifeCycleState + ", versionSchema=" + versionSchema + ", documentAttribute1="
				+ documentAttribute1 + ", documentAttribute2=" + documentAttribute2 + "]";
	}

    

}
