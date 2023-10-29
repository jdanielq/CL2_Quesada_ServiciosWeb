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

    Optional<Producto> findByNombre(String nombre);

    List<Producto> findByNombreContainingIgnoreCase(String filtro);

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:filtro%")
    List<Producto> filtrarProductosPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM Producto WHERE nombre LIKE %:filtro%",
            nativeQuery = true)
    List<Producto> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);

}
