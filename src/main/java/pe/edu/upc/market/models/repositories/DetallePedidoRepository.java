package pe.edu.upc.market.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.market.models.entities.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

}
