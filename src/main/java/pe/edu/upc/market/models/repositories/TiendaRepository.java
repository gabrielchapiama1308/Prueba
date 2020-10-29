package pe.edu.upc.market.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.market.models.entities.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
	//@Query("SELECT t FROM Tienda t WHERE UPPER(t.nombre) LIKE CONCAT('%',UPPER(:nombre),'%'")
	//List<Tienda> fetchByNombre(String nombre) throws Exception;
	List<Tienda> findByNombreContaining(String nombre) throws Exception;
}
