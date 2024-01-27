package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "produto", path = "produtos")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
