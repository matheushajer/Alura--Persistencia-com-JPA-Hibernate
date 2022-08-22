package br.com.matheushajer.loja.testes;

import javax.persistence.EntityManager;

import br.com.matheushajer.loja.modelo.Categoria;
import br.com.matheushajer.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("Celulares");
		
		//Produto celular = new Produto("Redmi", "Modelo novo", new BigDecimal("800"), celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		//ProdutoDAO produtoDAO = new ProdutoDAO(em);
		//CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		em.persist(celulares);
		celulares.setNome("testePreFechamento");
		
		//categoriaDAO.cadastrar(celulares);
		//produtoDAO.cadastrar(celular);
		
		em.flush();
		em.clear();;
		
		celulares = em.merge(celulares);
		celulares.setNome("TesteAposFechamento");
		em.flush();
		
		em.remove(celulares);
		em.flush();
		
	}
}
