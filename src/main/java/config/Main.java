package config;

import dao.impl.CidadeDAOImpl;
import dao.impl.EstadoDAOImpl;
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

        estadoDAO.findAll().stream().map(Estado::toString).forEachOrdered(System.out::println);
    }
}
