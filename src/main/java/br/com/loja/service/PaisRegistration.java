package br.com.loja.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.loja.model.Pais;

public class PaisRegistration {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		
		private Logger logger;
	
		//Cadastrar um novo pais
		public void CriarPais(Pais pais) {
			em.getTransaction().begin();
			em.persist(pais);
			em.getTransaction().commit();
		}
		
		//remove o país do banco
		public void RemoverPais(Integer id) {
			//em.getTransaction().begin();
			Pais pais = em.find(Pais.class, id);
			em.remove(pais);
			logger.info("Removido país " + pais.getNome());
		}
		
		//editar o nome do país
		public void EditarPais(Pais pais, String nome) {
			//TypedQuery<Pais> paisEdit = em.createQuery("Select * from paises", Pais.class);
			
		}
		
		//lista os países cadastrados
		public List<Pais> listarPaises(){
			TypedQuery<Pais> listapaises = em.createQuery("Select * from paises", Pais.class);
			return listapaises.getResultList();
		}

}
