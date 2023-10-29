package pe.edu.cibertec.Cl2_Quesada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.Cl2_Quesada.model.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> findProductosBetween10And100();

    @Query(nativeQuery = true, value = "SELECT * FROM Producto p WHERE YEAR(p.fecha_vencimiento) = 2024")
    List<Producto> findProductosWith2024Expiration();

}
