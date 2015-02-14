package at.gov.parlament.documentation.hermes.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericDaoImpl<T extends IEntity> implements IGenericDao<T> {
    protected EntityManager em;
    
    private Class<T> type;

    @SuppressWarnings({ "unchecked" })
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

	@Override
    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public T find(final Object id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public T update(final T t) {
        return this.em.merge(t);    
    }
}
