package at.gov.parlament.documentation.hermes.dao.interfaces;

import java.util.Map;

import at.gov.parlament.documentation.hermes.dao.entities.IEntity;

public interface GenericDao<T extends IEntity> {
    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @param params
     *            sql parameters
     * @return the number of records meeting the criteria
     */
    long countAll(Map<String, Object> params);

    /**
     * Create given entity
     * @param entity
     * @return The entity which was created. With created id.
     */
    T create(T entity);
    
    /**
     * Read entity with given id.
     * @param id
     * @return
     */
    T find(Object id);

    /**
     * Update given entity.
     * @param entity
     * @return The updated entity
     */
    T update(T t); 
    
    /**
     * Deletes the entity with given id.
     * @param id
     */
    void delete(Object id);

      
}
