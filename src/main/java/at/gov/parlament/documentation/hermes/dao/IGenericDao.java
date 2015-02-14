package at.gov.parlament.documentation.hermes.dao;

import java.util.Map;

public interface IGenericDao<T extends IEntity> {
    
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
