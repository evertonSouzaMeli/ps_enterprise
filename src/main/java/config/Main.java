package config;

import dao.impl.BairroDAOImpl;
import dao.impl.CidadeDAOImpl;
import dao.impl.EstadoDAOImpl;
import dao.impl.LogradouroDAOImpl;
import model.*;
import singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
        EntityManager em = fabrica.createEntityManager();

        EstadoDAOImpl estadoDAO = new EstadoDAOImpl(em);
        CidadeDAOImpl cidadeDAO = new CidadeDAOImpl(em);
        BairroDAOImpl bairroDAO = new BairroDAOImpl(em);
        LogradouroDAOImpl logradouroDAO = new LogradouroDAOImpl(em);

        //Criar Tipo de Logradouro
        TipoLogradouro rua = TipoLogradouro.builder().nome("Rua").build();

        //Criar Logradouro
        Logradouro logradouro1 = Logradouro.builder()
                .codigoTipoLogradouro(81)
                .descricaoLogradouro("Rua da Glória")
                .cep(01510001)
                .tipoLogradouro(rua)
                .build();

        Logradouro logradouro2 = Logradouro.builder()
                .codigoTipoLogradouro(100)
                .descricaoLogradouro("Rua Alcides Bezerra")
                .cep(01510001)
                .tipoLogradouro(rua)
                .build();

        //Criar Bairros
        Bairro bairro = Bairro.builder().nome("Sé").logradouros(Arrays.asList(logradouro1, logradouro2)).build();

        //Criar Cidade
        Cidade cidade = Cidade.builder().nome("São Paulo").bairros(Arrays.asList(bairro)).build();

        //Criar Estado
        Estado estado = Estado.builder().nome("São Paulo").sigla("SP").cidades(Arrays.asList(cidade)).build();

        //estadoDAO.save(estado);
        //estadoDAO.find(1);
        //estadoDAO.update(estado);
        //estadoDAO.delete(1);

        //cidadeDAO.save(cidade);
        //cidadeDAO.find(1);
        //cidadeDAO.update(cidade);
        //cidadeDAO.delete(1);

        //bairroDAO.save(bairro);
        //bairroDAO.find(1);
        //bairroDAO.update(bairro);
        //bairroDAO.delete(1);

        //logradouroDAO.save(logradouro1)
        //logradouroDAO.save(logradouro2);
        //logradouroDAO.find(1);
        //logradouroDAO.update(logradouro1);
        //logradouroDAO.delete(1);

        estadoDAO.findAll().stream().map(Estado::toString).forEachOrdered(System.out::println);
        cidadeDAO.findAll().stream().map(Cidade::toString).forEachOrdered(System.out::println);
        bairroDAO.findAll().stream().map(Bairro::toString).forEachOrdered(System.out::println);
        logradouroDAO.findAll().stream().map(Logradouro::toString).forEachOrdered(System.out::println);

        cidadeDAO.findCidadeByNameIgnoreCase("SÃO").stream().map(Cidade::toString).forEachOrdered(System.out::println);
        System.out.println(cidadeDAO.countCidadesByName("São"));
        bairroDAO.findAllLogradouroByBairroName("Sé").stream().map(Logradouro::toString).forEachOrdered(System.out::println);
    }
}
