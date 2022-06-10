package dao.impl;

import dao.CidadeDAO;
import model.Cidade;
import singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Locale;

public class CidadeDAOImpl extends GenericDAOImpl<Integer, Cidade> implements CidadeDAO {

    public CidadeDAOImpl(EntityManager em) {
        super(em);
    }


    //Busca Cidade por nome sem diferenciar maiscula da miniscula
    public List<Cidade> findCidadeByNameIgnoreCase(String nome){
        return em.createQuery("Select c from Cidade c where c.nome = :nome")
                .setParameter("nome", nome.toLowerCase(Locale.ROOT))
                .setMaxResults(50)
                .getResultList();
    }
}
