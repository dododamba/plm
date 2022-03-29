package com.plm.model;

import java.io.Serializable;
import javax.persistence.*;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Model  VersionSchema
|
|
|
|*/


@Entity
@Table(name = "version_schemas")

public class VersionSchema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	@Column(name = "id")
	private Long id;
	
	@Column
	private String nextVersionLabel;
	
	public VersionSchema() {
		// TODO Auto-generated constructor stub
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
	 * @return the nextVersionLabel
	 */
	public String getNextVersionLabel() {
		return nextVersionLabel;
	}

	/**
	 * @param nextVersionLabel the nextVersionLabel to set
	 */
	public void setNextVersionLabel(String nextVersionLabel) {
		this.nextVersionLabel = nextVersionLabel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nextVersionLabel == null) ? 0 : nextVersionLabel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionSchema other = (VersionSchema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nextVersionLabel == null) {
			if (other.nextVersionLabel != null)
				return false;
		} else if (!nextVersionLabel.equals(other.nextVersionLabel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VersionSchema [id=" + id + ", nextVersionLabel=" + nextVersionLabel + "]";
	}
	
	
}
