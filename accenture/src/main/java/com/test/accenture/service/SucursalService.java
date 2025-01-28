package com.test.accenture.service;

import com.test.accenture.model.Sucursal;

public interface SucursalService {
    Sucursal addSucursalToFranquicia(Long franquiciaId, Sucursal sucursal);
    Sucursal findSucursal(Long sucursalId);
}
