package com.test.accenture.repository;

import com.test.accenture.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findBySucursalId(Long sucursalId);
    Producto findTopBySucursalIdOrderByStockDesc(Long branchId);
}
