package com.plm.dao;

import java.util.Collection;

import com.plm.model.LifeCycleTemplate;

public interface LifeCycleTemplateDAO {

	Collection<LifeCycleTemplate> all();
	
	void update(LifeCycleTemplate lifeCycleTemplate);

	void create(LifeCycleTemplate lifeCycleTemplate);

	void delete(LifeCycleTemplate lifeCycleTemplate);
}
