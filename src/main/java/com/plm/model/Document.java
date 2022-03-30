package com.plm.model;

import java.io.Serializable;
import java.util.Objects;

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
@IdClass(DocumentPK.class)

public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String reference;
	@Id
	private String version;
	@Id
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
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}

	/**
	 * @return the reserved
	 */
	public boolean isReserved() {
		return reserved;
	}

	/**
	 * @return the reservedBy
	 */
	public String getReservedBy() {
		return reservedBy;
	}

	/**
	 * @return the lifeCycleTemplate
	 */
	public LifeCycleTemplate getLifeCycleTemplate() {
		return lifeCycleTemplate;
	}

	/**
	 * @return the lifeCycleState
	 */
	public String getLifeCycleState() {
		return lifeCycleState;
	}

	/**
	 * @return the versionSchema
	 */
	public VersionSchema getVersionSchema() {
		return versionSchema;
	}

	/**
	 * @return the documentAttribute1
	 */
	public String getDocumentAttribute1() {
		return documentAttribute1;
	}

	/**
	 * @return the documentAttribute2
	 */
	public String getDocumentAttribute2() {
		return documentAttribute2;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @param iteration the iteration to set
	 */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	/**
	 * @param reserved the reserved to set
	 */
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	/**
	 * @param reservedBy the reservedBy to set
	 */
	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}

	/**
	 * @param lifeCycleTemplate the lifeCycleTemplate to set
	 */
	public void setLifeCycleTemplate(LifeCycleTemplate lifeCycleTemplate) {
		this.lifeCycleTemplate = lifeCycleTemplate;
	}

	/**
	 * @param lifeCycleState the lifeCycleState to set
	 */
	public void setLifeCycleState(String lifeCycleState) {
		this.lifeCycleState = lifeCycleState;
	}

	/**
	 * @param versionSchema the versionSchema to set
	 */
	public void setVersionSchema(VersionSchema versionSchema) {
		this.versionSchema = versionSchema;
	}

	/**
	 * @param documentAttribute1 the documentAttribute1 to set
	 */
	public void setDocumentAttribute1(String documentAttribute1) {
		this.documentAttribute1 = documentAttribute1;
	}

	/**
	 * @param documentAttribute2 the documentAttribute2 to set
	 */
	public void setDocumentAttribute2(String documentAttribute2) {
		this.documentAttribute2 = documentAttribute2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentAttribute1, documentAttribute2, iteration, lifeCycleState, lifeCycleTemplate,
				reference, reserved, reservedBy, version, versionSchema);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		return Objects.equals(documentAttribute1, other.documentAttribute1)
				&& Objects.equals(documentAttribute2, other.documentAttribute2) && iteration == other.iteration
				&& Objects.equals(lifeCycleState, other.lifeCycleState)
				&& Objects.equals(lifeCycleTemplate, other.lifeCycleTemplate)
				&& Objects.equals(reference, other.reference) && reserved == other.reserved
				&& Objects.equals(reservedBy, other.reservedBy) && Objects.equals(version, other.version)
				&& Objects.equals(versionSchema, other.versionSchema);
	}

	@Override
	public String toString() {
		return "Document [reference=" + reference + ", version=" + version + ", iteration=" + iteration + ", reserved="
				+ reserved + ", reservedBy=" + reservedBy + ", lifeCycleTemplate=" + lifeCycleTemplate
				+ ", lifeCycleState=" + lifeCycleState + ", versionSchema=" + versionSchema + ", documentAttribute1="
				+ documentAttribute1 + ", documentAttribute2=" + documentAttribute2 + "]";
	}

}
