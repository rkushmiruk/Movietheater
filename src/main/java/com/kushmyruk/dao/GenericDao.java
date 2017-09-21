package com.kushmyruk.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<DomainObject, ID> {
    /**
     * Retrieves domainObjects from database identified by id.
     *
     * @param id identifier of entity.
     * @return optional, which contains entity or null
     */
    Optional<DomainObject> findById(ID id);

    /**
     * Retrieves all domainObjects from database.
     *
     * @return List of entities
     */
    List<DomainObject> findAll();

    /**
     * Insert domainObject to a database.
     *
     * @param domainObject entity to insert
     * @return true if operation succeed
     */
    boolean insert(DomainObject domainObject);

    /**
     * Update domainObject in a database.
     *
     * @param domainObject entity to update
     * @return true if operation succeed
     */
    boolean update(DomainObject domainObject);

    /**
     * Delete certain domainObject, identified by id, from database.
     *
     * @param id identifier of the object.
     * @return true if operation succeed
     */
    boolean delete(ID id);

    /**
     * Find domainObject id
     *
     * @return domainObject id
     */
    Optional<Long> findId();

    /**
     * returns domainObject name
     *
     * @return domainObject name
     */
    String getName();
}
