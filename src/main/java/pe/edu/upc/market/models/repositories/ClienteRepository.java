package pe.edu.upc.market.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.market.models.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	// findBy, genera una sentencia JPQL que utiliza el operador =
	Optional<Cliente> findByNumeroDocumento(String numeroDocumento) throws Exception;
	
	// Se debe de implementa la Sentencia cuando se utiliza otro operador, utilizar el fetch
	//@Query("SELECT c FROM Cliente c WHERE UPPER(c.nombresApellidos) LIKE CONCAT('%',UPPER(:nombresApellidos),'%'")
	//List<Cliente> fetchByNombresApellidos(String nombresApellidos) throws Exception;
	List<Cliente> findByNombresApellidosContaining(String nombresApellidos) throws Exception;
	
	
}
