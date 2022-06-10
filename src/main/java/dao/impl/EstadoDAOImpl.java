package dao.impl;

import dao.EstadoDAO;
import model.Estado;

import javax.persistence.EntityManager;

public class EstadoDAOImpl extends GenericDAOImpl<Integer, Estado> implements EstadoDAO {

    public EstadoDAOImpl(EntityManager em) {
        super(em);
    }
}
