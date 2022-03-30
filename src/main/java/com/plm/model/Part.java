package com.plm.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Model  Part
|
|
|
|*/

@Entity
@Table(name = "parts")
@IdClass(PartPK.class)

public class Part implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String version;

	@Id
	private String reference;

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
	private String partAttribute1;
	@Column
	private String partAttribute2;

	public Part() {

	}

	public Part(String reference, String version, int iteration) {

		this.version = version;
		this.reference = reference;
		this.iteration = iteration;
	}

	public Part(String version, String reference, int iteration, boolean reserved, String reservedBy,
			LifeCycleTemplate lifeCycleTemplate, String lifeCycleState, VersionSchema versionSchema,
			String partAttribute1, String partAttribute2) {
		
		this.version = version;
		this.reference = reference;
		this.iteration = iteration;
		this.reserved = reserved;
		this.reservedBy = reservedBy;
		this.lifeCycleTemplate = lifeCycleTemplate;
		this.lifeCycleState = lifeCycleState;
		this.versionSchema = versionSchema;
		this.partAttribute1 = partAttribute1;
		this.partAttribute2 = partAttribute2;
	}

	public String getVersion() {
		return version;
	}

	public String getReference() {
		return reference;
	}

	public int getIteration() {
		return iteration;
	}

	public boolean isReserved() {
		return reserved;
	}

	public String getReservedBy() {
		return reservedBy;
	}

	public LifeCycleTemplate getLifeCycleTemplate() {
		return lifeCycleTemplate;
	}

	public String getLifeCycleState() {
		return lifeCycleState;
	}

	public VersionSchema getVersionSchema() {
		return versionSchema;
	}

	public String getPartAttribute1() {
		return partAttribute1;
	}

	public String getPartAttribute2() {
		return partAttribute2;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}

	public void setLifeCycleTemplate(LifeCycleTemplate lifeCycleTemplate) {
		this.lifeCycleTemplate = lifeCycleTemplate;
	}

	public void setLifeCycleState(String lifeCycleState) {
		this.lifeCycleState = lifeCycleState;
	}

	public void setVersionSchema(VersionSchema versionSchema) {
		this.versionSchema = versionSchema;
	}

	public void setPartAttribute1(String partAttribute1) {
		this.partAttribute1 = partAttribute1;
	}

	public void setPartAttribute2(String partAttribute2) {
		this.partAttribute2 = partAttribute2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iteration, lifeCycleState, lifeCycleTemplate, partAttribute1, partAttribute2, reference,
				reserved, reservedBy, version, versionSchema);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		return iteration == other.iteration && Objects.equals(lifeCycleState, other.lifeCycleState)
				&& Objects.equals(lifeCycleTemplate, other.lifeCycleTemplate)
				&& Objects.equals(partAttribute1, other.partAttribute1)
				&& Objects.equals(partAttribute2, other.partAttribute2) && Objects.equals(reference, other.reference)
				&& reserved == other.reserved && Objects.equals(reservedBy, other.reservedBy)
				&& Objects.equals(version, other.version) && Objects.equals(versionSchema, other.versionSchema);
	}

	@Override
	public String toString() {
		return "Part [version=" + version + ", reference=" + reference + ", iteration=" + iteration + ", reserved="
				+ reserved + ", reservedBy=" + reservedBy + ", lifeCycleTemplate=" + lifeCycleTemplate
				+ ", lifeCycleState=" + lifeCycleState + ", versionSchema=" + versionSchema + ", partAttribute1="
				+ partAttribute1 + ", partAttribute2=" + partAttribute2 + "]";
	}

	
	
}
