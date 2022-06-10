package dao.impl;

import dao.GenericDAO;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAOImpl<K, V> implements GenericDAO<K,V> {

    protected EntityManager em;

    private final Class<V> clazz;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl(EntityManager em) {
        this.em = em;
        clazz = (Class<V>) ((ParameterizedType)getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(V entity) {
        em.persist(entity);
    }

    public void update(V entity) {
        em.merge(entity);
    }

    public void delete(K codigo)  {
        V entidade = find(codigo);
        if (entidade == null){
            throw new RuntimeException("Entidade não encontrada");
        }
        em.remove(entidade);
    }

    public V find(K codigo) {
        return em.find(clazz, codigo);
    }


    public List<V> findAll(){
        return em.createQuery("from "+ clazz.getName(), clazz).getResultList();
    }
}
