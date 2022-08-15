package br.com.matheushajer.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.matheushajer.loja.dao.ProdutoDAO;
import br.com.matheushajer.loja.modelo.Produto;
import br.com.matheushajer.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto();
		
		celular.setNome("Redmi");
		celular.setDescricao("Modelo novo");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
