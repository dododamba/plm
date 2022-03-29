package com.plm.model;


import java.io.Serializable;
import javax.persistence.*;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Model  LifeCycleTemplate
|
|
|
|*/

@Entity
@Table(name = "life_cycles_templates")
public class LifeCycleTemplate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	@Column(name = "id")
	private Long id;
	
    private String initialState;
    private boolean know;
    private boolean isFinal;
    
    public LifeCycleTemplate() {
	}
    
    

	public LifeCycleTemplate(String initialState, boolean know, boolean isFinal) {
		this.initialState = initialState;
		this.know = know;
		this.isFinal = isFinal;
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
	 * @return the initialState
	 */
	public String getInitialState() {
		return initialState;
	}



	/**
	 * @param initialState the initialState to set
	 */
	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}



	/**
	 * @return the know
	 */
	public boolean isKnow() {
		return know;
	}



	/**
	 * @param know the know to set
	 */
	public void setKnow(boolean know) {
		this.know = know;
	}



	/**
	 * @return the isFinal
	 */
	public boolean isFinal() {
		return isFinal;
	}



	/**
	 * @param isFinal the isFinal to set
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}



	@Override
	public String toString() {
		return "LifeCycleTemplate [id=" + id + ", initialState=" + initialState + ", know=" + know + ", isFinal="
				+ isFinal + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((initialState == null) ? 0 : initialState.hashCode());
		result = prime * result + (isFinal ? 1231 : 1237);
		result = prime * result + (know ? 1231 : 1237);
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
		LifeCycleTemplate other = (LifeCycleTemplate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initialState == null) {
			if (other.initialState != null)
				return false;
		} else if (!initialState.equals(other.initialState))
			return false;
		if (isFinal != other.isFinal)
			return false;
		if (know != other.know)
			return false;
		return true;
	}
	
	
	
	
	
    
    
    
    
}
