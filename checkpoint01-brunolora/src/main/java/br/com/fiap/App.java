package br.com.fiap;

import java.time.LocalDate;

import br.com.fiap.entity.Livro;
import br.com.fiap.service.impl.LivroServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();
		
		Livro livro = new Livro("Vento nevou", "Clarice Lispector", "123456789-3", LocalDate.of(2003, 10, 23));
		Livro livro2 = new Livro("Jogos Vorazes", "Lora", "32197422-2", LocalDate.of(2014, 2, 13));
		Livro livro3 = new Livro("As aventuras do menega", "Bruno","4982783472-2", LocalDate.of(2020, 12, 10));
		livroService.cadastrar(livro);
		livroService.cadastrar(livro2);
		livroService.cadastrar(livro3);
		
		livroService.listar().forEach(System.out::println);
		
		livroService.remover(3L);
		
		livroService.atualizar(new Livro("As aventuras do menega", "Bruno", "4982783472-2", LocalDate.of(2022, 10, 03)));
	}

}
