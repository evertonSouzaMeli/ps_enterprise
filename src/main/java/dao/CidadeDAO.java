package dao;

import model.Cidade;

import java.util.List;

public interface CidadeDAO extends GenericDAO<Integer, Cidade>{

    List<Cidade> findCidadeByNameIgnoreCase(String nome);
}
