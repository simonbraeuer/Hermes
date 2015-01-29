package at.gov.parlament.documentation.hermes.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import at.gov.parlament.documentation.hermes.dao.entities.IEntity;
import at.gov.parlament.documentation.hermes.dao.interfaces.GenericDao;

public abstract class GenericDaoImpl<T extends IEntity> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    @SuppressWarnings("rawtypes")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public long countAll(final Map<String, Object> params) {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");
        //queryString.append(em.getCriteriaBuilder().createQuery(params)
        //queryString.append(this.get ()

        final Query query = this.em.createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }

   // protected abstract Object getQueryClauses(Map<String, Object> params, Object object);
    
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
