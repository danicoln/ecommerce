package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.CategoriaProduto;
import com.luv2code.ecommerce.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MeusDadosRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MeusDadosRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] acoesNaoSuportadas = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disabilitar os metodos para Produto
        config.getExposureConfiguration()
                .forDomainType(Produto.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(acoesNaoSuportadas))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(acoesNaoSuportadas));

        //disabilitar os metodos para Categoria
        config.getExposureConfiguration()
                .forDomainType(CategoriaProduto.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(acoesNaoSuportadas))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(acoesNaoSuportadas));

        //chamar um meétodo auxiliaar para nos ajudar a expor os IDs.
        expoeIds(config);
    }

    private void expoeIds(RepositoryRestConfiguration config) {
        // export os ids da entidade

        // pegar a coleção de todas as classes entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //Criação de uma matriz com a lista destes tipos de entidades
        List<Class> entityClasses = new ArrayList<>();

        // obter os tipos de entidades para entidades.
        for (EntityType entidades : entities) {
            entityClasses.add(entidades.getJavaType());
        }

        // expor os ids das entidades para um array de entidades/tipos de dominio
        Class[] tiposDominio = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(tiposDominio);
    }
}
