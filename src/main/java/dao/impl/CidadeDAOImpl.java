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


    //Busca Cidade por nome sem diferenciar maiscula da miniscula(Exercicio 4a)
    @Override
    public List<Cidade> findCidadeByNameIgnoreCase(String nome){
        return em.createQuery("Select c from Cidade c where lower(c.nome) = lower(:nome)", Cidade.class)
                .setParameter("nome", nome)
                .setMaxResults(50)
                .getResultList();
    }

    //Busca Cidade por parte do nome e retorna quantidade encontrada(Exercicio 4b)
    @Override
    public Integer countCidadesByName(String nome) {
        return em.createQuery("select count(c) from Cidade c where c.nome like concat('%', :nome, '%')", Integer.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
