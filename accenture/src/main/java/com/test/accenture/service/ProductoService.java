package com.test.accenture.service;

import com.test.accenture.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto addProductoToSucursal(Long sucursalId, Producto producto);
    Producto getTopStockProducto(Long sucursalId);
    public Producto deleteProductoToSucursal(Long productoId);
    List<Producto> getProductoList(Long sucursalId);}
