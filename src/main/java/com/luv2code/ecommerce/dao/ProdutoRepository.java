package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
@CrossOrigin
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByCategoriaId(@Param("id") Long id, Pageable pageable);

    Page<Produto> findByNomeContaining(@Param("nome") String nome, Pageable pageable);
}
