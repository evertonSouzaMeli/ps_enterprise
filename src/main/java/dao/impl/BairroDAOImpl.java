package dao.impl;

import dao.BairroDAO;
import model.Bairro;
import model.Logradouro;

import javax.persistence.EntityManager;
import java.util.List;

public class BairroDAOImpl extends GenericDAOImpl<Integer, Bairro> implements BairroDAO {

    public BairroDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Logradouro> findAllLogradouroByBairroName(String nome) {
        return em.createQuery("from Logradouro l where l.bairro.nome = :nome order by l.bairro.nome asc ")
                .setParameter("nome", nome)
                .getResultList();
    }
}