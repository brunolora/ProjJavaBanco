package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Livro;
import br.com.fiap.service.GenericService;

public class LivroServiceImpl extends GenericService<Livro, Long> {
	
	private static LivroServiceImpl instance = null;
	
	private LivroDAOImpl livroDAO;
	
	private LivroServiceImpl() {
		livroDAO = LivroDAOImpl.getInstance();
	}
	
	public static LivroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new LivroServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(Livro instance) {
		try {
			livroDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	public void inserirComEndereco(Livro livro) {
		try {
			livroDAO.salvar(livro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Livro instance) {
		try {
			livroDAO.atualizar(instance, getEntityManager());
		} catch (Exception e){
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			livroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Livro obter(Long id) {
		Livro livro = null;
		
		try {
			livro = livroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return livro;
	}

	@Override
	public List<Livro> listar() {
		List<Livro> livros = null;
		
		try {
			livros = livroDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return livros;
	}

}
