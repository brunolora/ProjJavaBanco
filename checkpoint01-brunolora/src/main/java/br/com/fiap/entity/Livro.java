package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@Table(name = "tb_livro")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro implements Serializable{
	
	private static final long serialVersionUID = -7160909709727805596L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Long id;
	
	@Column(name = "ds_titulo", length = 40, nullable = false)
	private String titulo;
	
	@Column(name = "ds_nome", length = 50, nullable = false)
	private String autor;
	
	@Column(name = "ds_isbn", length = 25, nullable = false, unique = true)
	private String isbn;
	
	@Column(name = "dt_publicacao")
	private LocalDate dataPublicacao;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;

	public Livro(String titulo, String autor, String isbn, LocalDate dataPublicacao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
	}

	public Livro() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@Override
	public String toString() {
		
		return "\nTitulo: " + this.getTitulo()
				+ "\nAutor: " + this.getAutor()
				+ "\nIsbn: " + this.getIsbn()
				+ "\nPublicacao: " + this.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
