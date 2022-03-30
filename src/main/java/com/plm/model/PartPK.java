package com.plm.model;

import java.io.Serializable;
import java.util.Objects;


public  class PartPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reference;
	private String version;
	private int iteration;
	public PartPK() {
		
	}
	public PartPK(String reference, String version, int iteration) {
		this.reference = reference;
		this.version = version;
		this.iteration = iteration;
	}
	@Override
	public int hashCode() {
		return Objects.hash(iteration, reference, version);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartPK other = (PartPK) obj;
		return iteration == other.iteration && Objects.equals(reference, other.reference)
				&& Objects.equals(version, other.version);
	}
	
}


