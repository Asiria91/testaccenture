package com.test.accenture.serviceImpl;

import com.test.accenture.model.Producto;
import com.test.accenture.model.Sucursal;
import com.test.accenture.repository.ProductoRepository;
import com.test.accenture.service.ProductoService;
import com.test.accenture.service.SucursalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalService sucursalService;
    private final ProductoService productoService;

    public ProductoServiceImpl(ProductoRepository productoRepository, SucursalService sucursalService, ProductoService productoService) {
        this.productoRepository = productoRepository;
        this.sucursalService = sucursalService;
        this.productoService = productoService;
    }

    @Override
    public Producto addProductoToSucursal(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalService.findSucursal(sucursalId);
        producto.setSucursal(sucursal);
        return productoRepository.save(producto);
    }



    @Override
    public Producto getTopStockProducto(Long sucursalId) {
        return productoRepository.findTopBySucursalIdOrderByStockDesc(sucursalId);
    }


    @Override
    public Producto deleteProductoToSucursal(Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no existe"));
        productoRepository.delete(producto);
        return producto;
    }

    @Override
    public List<Producto> getProductoList(Long sucursalId) {
        return productoRepository.findBySucursalId(sucursalId);
    }
}
