package br.com.ads.cursouml;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ads.cursouml.domain.Categoria;
import br.com.ads.cursouml.domain.Produto;
import br.com.ads.cursouml.repositories.CategoriaRepository;
import br.com.ads.cursouml.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica", new ArrayList<Produto>());
		Categoria cat2 = new Categoria(null, "Escritório", new ArrayList<Produto>());
		
		Produto p1 = new Produto(null, "Computator", 2000.00, new ArrayList<Categoria>());
		Produto p2 = new Produto(null, "Impressora", 800.00, new ArrayList<Categoria>());
		Produto p3 = new Produto(null, "Mouse", 80.00, new ArrayList<Categoria>());
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList( p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2,p3));
		
	}

}
