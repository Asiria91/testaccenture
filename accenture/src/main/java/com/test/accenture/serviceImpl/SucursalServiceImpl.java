package com.test.accenture.serviceImpl;

import com.test.accenture.model.Franquicia;
import com.test.accenture.model.Sucursal;
import com.test.accenture.repository.SucursalRepository;
import com.test.accenture.service.FranquiciaService;
import com.test.accenture.service.SucursalService;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;
    private final FranquiciaService franquiciaService;

    public SucursalServiceImpl(SucursalRepository sucursalRepository, FranquiciaService franquiciaService) {
        this.sucursalRepository = sucursalRepository;
        this.franquiciaService = franquiciaService;
    }

    @Override
    // Agregar una sucursal a una franquicia
    public Sucursal addSucursalToFranquicia(Long franquiciaId, Sucursal sucursal) {
        Franquicia franchise = franquiciaService.findById(franquiciaId);
        sucursal.setFranquicia(franchise);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal findSucursal(Long sucursalId) {
        return sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
    }
}
