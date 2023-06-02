package br.com.ads.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ads.cursouml.domain.Categoria;
import br.com.ads.cursouml.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
	
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
		
	}

}
