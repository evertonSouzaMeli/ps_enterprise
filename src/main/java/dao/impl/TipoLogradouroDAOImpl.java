package dao.impl;

import dao.TipoLogradouroDAO;
import model.TipoLogradouro;

import javax.persistence.EntityManager;

public class TipoLogradouroDAOImpl extends GenericDAOImpl<Integer, TipoLogradouro> implements TipoLogradouroDAO {

    public TipoLogradouroDAOImpl(EntityManager em) {
        super(em);
    }
}
