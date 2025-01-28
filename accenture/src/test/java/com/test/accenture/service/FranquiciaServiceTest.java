package com.test.accenture.service;

import com.test.accenture.model.Franquicia;
import com.test.accenture.repository.FranquiciaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FranquiciaServiceTest {

    @Mock
    private FranquiciaRepository franquiciaRepository;

    private FranquiciaService franquiciaService;
    

@Test
public void shouldSuccessfullyAddNewFranchiseWhenGivenValidInput() {
    Franquicia franquicia = new Franquicia();
    franquicia.setId(1L);
    franquicia.setName("Test Franchise");

    when(franquiciaRepository.save(any(Franquicia.class))).thenReturn(franquicia);

    Franquicia result = franquiciaService.addFranchise(franquicia);

    assertNotNull(result);
    assertEquals(1L, result.getId());
    assertEquals("Test Franchise", result.getName());
    verify(franquiciaRepository, times(1)).save(franquicia);
}
}
