package dao;

import java.util.List;

public interface GenericDAO<K, V> {

        List<V> findAll();

        void save(V entity);

        void update(V entity);

        void delete(K codigo);

        V find(K codigo);
}
