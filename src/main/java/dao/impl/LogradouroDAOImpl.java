package dao.impl;

import dao.LogradouroDAO;
import model.Bairro;
import model.Logradouro;

import javax.persistence.EntityManager;

public class LogradouroDAOImpl extends GenericDAOImpl<Integer, Logradouro> implements LogradouroDAO {
    public LogradouroDAOImpl(EntityManager em) {
        super(em);
    }
}
