package com.plm.model;

import java.io.Serializable;
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
public class Part implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	@Column(name = "id")
	private Long id;
	
	@Column
	private String version;
	
	@Column
	private String reference;
	
	
	@Column
	private int iteration;
	
	@Column
	private boolean reserved;
	@Column
	private String  reservedBy;

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
	
	public Part() 
	{
		
	}
	
	
	

	public Part(String reference, String version , int iteration) {
		
		this.version = version;
		this.reference = reference;
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
	 * @return the partAttribute1
	 */
	public String getPartAttribute1() {
		return partAttribute1;
	}

	/**
	 * @param partAttribute1 the partAttribute1 to set
	 */
	public void setPartAttribute1(String partAttribute1) {
		this.partAttribute1 = partAttribute1;
	}

	/**
	 * @return the partAttribute2
	 */
	public String getPartAttribute2() {
		return partAttribute2;
	}

	/**
	 * @param partAttribute2 the partAttribute2 to set
	 */
	public void setPartAttribute2(String partAttribute2) {
		this.partAttribute2 = partAttribute2;
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
	
	
	
	
}
