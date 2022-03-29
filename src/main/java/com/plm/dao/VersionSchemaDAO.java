package com.plm.dao;

import java.util.Collection;

import com.plm.model.VersionSchema;

public interface VersionSchemaDAO {
    Collection<VersionSchema> all();
	
	void update(VersionSchema versionSchema);

	void create(VersionSchema versionSchema);

	void delete(VersionSchema versionSchema);
}
