package br.com.app.agrosetapi.fornecedor.repository;

import br.com.app.agrosetapi.fornecedor.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hramos
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
