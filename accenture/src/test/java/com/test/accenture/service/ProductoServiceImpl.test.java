package com.test.accenture.service;

import com.test.accenture.model.Producto;
import com.test.accenture.model.Sucursal;
import com.test.accenture.repository.ProductoRepository;
import com.test.accenture.serviceImpl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private SucursalService sucursalService;

    private ProductoServiceImpl productoService;


@Test
public void testAddProductoToSucursal() {
    // Arrange
    Long sucursalId = 1L;
    Sucursal sucursal = new Sucursal();
    sucursal.setId(sucursalId);

    Producto producto = new Producto();
    producto.setName("Test Product");
    producto.setStock(10);

    when(sucursalService.findSucursal(sucursalId)).thenReturn(sucursal);
    when(productoRepository.save(any(Producto.class))).thenReturn(producto);

    // Act
    Producto result = productoService.addProductoToSucursal(sucursalId, producto);

    // Assert
    assertNotNull(result);
    assertEquals("Test Product", result.getName());
    assertEquals(sucursal, result.getSucursal());
    verify(sucursalService).findSucursal(sucursalId);
    verify(productoRepository).save(producto);
}
}
