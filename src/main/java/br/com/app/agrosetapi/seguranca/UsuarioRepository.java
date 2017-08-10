package br.com.app.agrosetapi.seguranca;

import br.com.app.agrosetapi.seguranca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hramos
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String email);
}
