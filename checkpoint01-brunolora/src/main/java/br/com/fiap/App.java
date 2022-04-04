package br.com.fiap;

import java.time.LocalDate;

import br.com.fiap.entity.Livro;
import br.com.fiap.service.impl.LivroServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();
		
		Livro livro = new Livro("O vento nevou", "Clarice Lispector", "49827983217-8", LocalDate.of(2004, 5, 24));
		livroService.cadastrar(new Livro("Xablau", "Lora", "4024124-2", LocalDate.of(2014, 1, 14)));
		livroService.cadastrar(new Livro("Anjo caido", "Bruno", "50985843-2", LocalDate.of(2020, 12, 30)));
		livroService.cadastrar(livro);
		
		livroService.listar();
		
		Livro livro2 = livroService.obter(3L);
		System.out.println(livro2);
		
		livroService.remover(3L);
		
		livroService.atualizar(new Livro("Anjo caido", "Bruno", "50985843-2", LocalDate.of(2022, 10, 03)));
	}

}
