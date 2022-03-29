package com.plm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plm.model.LifeCycleTemplate;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Repository  LifeCycle
|
|
|
|*/

@Repository
public interface LifeCycleTemplateRepository extends JpaRepository<LifeCycleTemplate, Long>{

}
