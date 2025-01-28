package com.test.accenture.serviceImpl;

import com.test.accenture.model.Franquicia;
import com.test.accenture.repository.FranquiciaRepository;
import com.test.accenture.service.FranquiciaService;
import org.springframework.stereotype.Service;

@Service
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaServiceImpl(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    @Override
    public Franquicia addFranchise(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public Franquicia findById(Long id) {
        return franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
    }
}
