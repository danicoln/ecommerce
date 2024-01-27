package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.CategoriaProduto;
import com.luv2code.ecommerce.entity.Produto;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MeusDadosRestConfig implements RepositoryRestConfigurer {

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

    }
}
