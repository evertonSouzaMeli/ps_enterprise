package dao;

import model.Bairro;
import model.Logradouro;

import java.util.List;

public interface BairroDAO extends GenericDAO<Integer, Bairro> {

    public List<Logradouro> findAllLogradouroByBairroName(String nome);
}
