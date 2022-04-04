package br.com.fiap.dao.impl;

import br.com.fiap.entity.Livro;

public class LivroDAOImpl extends HibernateGenericDAO<Livro, Long> {

	private static LivroDAOImpl instance = null;
	
	public static LivroDAOImpl getInstance() {
		if (instance == null) {
			instance = new LivroDAOImpl();
		}
		
		return instance;
	}
	
	private LivroDAOImpl() {
		super(Livro.class);
	}

}

