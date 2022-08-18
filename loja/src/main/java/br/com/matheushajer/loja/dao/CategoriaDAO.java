package br.com.matheushajer.loja.dao;

import javax.persistence.EntityManager;

import br.com.matheushajer.loja.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria produto) {
		this.em.persist(produto);
	}

}
