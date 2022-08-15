package br.com.matheushajer.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.matheushajer.loja.dao.ProdutoDAO;
import br.com.matheushajer.loja.modelo.Categoria;
import br.com.matheushajer.loja.modelo.Produto;
import br.com.matheushajer.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto("Redmi", "Modelo novo", new BigDecimal("800"), Categoria.CELULARES );
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
