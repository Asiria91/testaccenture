package com.test.accenture.controller;

import com.test.accenture.model.Franquicia;
import com.test.accenture.model.Producto;
import com.test.accenture.model.Sucursal;
import com.test.accenture.service.FranquiciaService;
import com.test.accenture.service.ProductoService;
import com.test.accenture.service.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FranquiciaController {
    private final FranquiciaService franquiciaService;
    private final SucursalService sucursalService;
    private final ProductoService productoService;

    public FranquiciaController(FranquiciaService franquiciaService, SucursalService sucursalService, ProductoService productoService) {
        this.franquiciaService = franquiciaService;
        this.sucursalService = sucursalService;
        this.productoService = productoService;
    }

    @PostMapping("/franquicia")
    public ResponseEntity<Franquicia> addFranquicia(@RequestBody Franquicia franquicia) {
        return ResponseEntity.ok(franquiciaService.addFranchise(franquicia));
    }

    @PostMapping("/franquicias/{franquiciaId}/sucursales")
    public ResponseEntity<Sucursal> addSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.addSucursalToFranquicia(franquiciaId, sucursal));
    }

    @PostMapping("/sucursales/{sucursalId}/products")
    public ResponseEntity<Producto> addProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.addProductoToSucursal(sucursalId, producto));
    }

    @GetMapping("/sucursales/{sucursalId}/top-product")
    public ResponseEntity<Producto> getTopStockProducto(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(productoService.getTopStockProducto(sucursalId));
    }


}
