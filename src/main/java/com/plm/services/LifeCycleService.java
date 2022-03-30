package com.plm.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plm.dao.LifeCycleTemplateDAO;
import com.plm.model.LifeCycleTemplate;
import com.plm.repository.LifeCycleTemplateRepository;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Service  LifeCyleTemplate
|
|
|
|*/

@Service
@Transactional
public class LifeCycleService implements LifeCycleTemplateDAO {
	
	private LifeCycleTemplateRepository lifeCycleTemplateRepository;

	@Autowired
	public LifeCycleService(LifeCycleTemplateRepository lifeCycleTemplateRepository) {
		this.lifeCycleTemplateRepository = lifeCycleTemplateRepository;
	}

	@Override
	public Collection<LifeCycleTemplate> all() {
		return lifeCycleTemplateRepository.findAll();
	}

	@Override
	public void update(LifeCycleTemplate lifeCycleTemplate) {
		lifeCycleTemplateRepository.saveAndFlush(lifeCycleTemplate);
		
	}

	@Override
	public void create(LifeCycleTemplate lifeCycleTemplate) {
		lifeCycleTemplateRepository.save(lifeCycleTemplate);
		
	}

	@Override
	public void delete(LifeCycleTemplate lifeCycleTemplate) {
		lifeCycleTemplateRepository.delete(lifeCycleTemplate);		
	}
	
	

}
