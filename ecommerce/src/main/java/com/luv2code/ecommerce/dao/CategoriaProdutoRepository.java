package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**A anotação RepositoryRestResource ajuda a personalizar o nome do objeto e o path para personalizar o endpoint*/
@RepositoryRestResource(collectionResourceRel = "categoriaProduto", path = "categoria-produto")
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
}
