package br.com.alura.hotel.dao;

import java.sql.SQLException;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;
import br.com.alura.hotel.modelo.Hospede;


public class HospedeDAO {
	
	private EntityManager entityManager;

	public HospedeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Hospede hospede) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(hospede);
		this.entityManager.getTransaction().commit();
	}
	
	public void atualizar(Hospede hospede) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(hospede);
		this.entityManager.getTransaction().commit();
	}
	
	public void remover(Hospede hospede) {
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(hospede);
		this.entityManager.getTransaction().commit();
	}
	
	public Hospede buscarPorId(Long id) {
		return entityManager.find(Hospede.class, id);
	}
	
	public List<Hospede> buscarTodos() {
		String jpql = "SELECT h FROM Hospede h";
		return entityManager.createQuery(jpql, Hospede.class).getResultList();
	}
	
	public Hospede buscarPorIdDaReserva(Long id) {
		String jpql = "SELECT h FROM Hospede h WHERE h.reserva.id = :id";
		return entityManager.createQuery(jpql,Hospede.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public List<Hospede> buscarPorParametros(String nome, String sobrenome, LocalDate dataNascimento,
			String nacionalidade, String telefone) {
		String jpql = "SELECT h FROM Hospede h WHERE 1=1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql += " AND h.nome = :nome ";
		}
		if (sobrenome != null && !sobrenome.trim().isEmpty()) {
			jpql += " AND h.sobrenome = :sobrenome ";
		}
		if (dataNascimento != null) {
			jpql += " AND h.dataNascimento = :dataNascimento";
		}
		if (nacionalidade != null && !nacionalidade.trim().isEmpty()) {
			jpql += " AND h.nacionalidade = :nacionalidade";
		}
		if (telefone != null && !telefone.trim().isEmpty()) {
			jpql += " AND h.telefone = :telefone";
		}
		TypedQuery<Hospede> query = entityManager.createQuery(jpql, Hospede.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (sobrenome != null && !sobrenome.trim().isEmpty()) {
			query.setParameter("sobrenome", sobrenome);
		}
		if (dataNascimento != null) {
			query.setParameter("dataNascimento", dataNascimento);
		}
		if (nacionalidade != null && !nacionalidade.trim().isEmpty()) {
			query.setParameter("nacionalidade", nacionalidade);
		}
		if (telefone != null && !telefone.trim().isEmpty()) {
			query.setParameter("telefone", telefone);
		}
		
		return query.getResultList();
	}
	
	public void deletarIdReserva(Long idReserva) {
		String jpql = "DELETE FROM Hospedes h WHERE h.reserva.id = :idReserva";
		entityManager.createQuery(jpql).setParameter("idReserva", idReserva);
	}
	
	public void deletar(Long id) {
		String jpql = "DELETE FROM Hospede h WHERE h.id = :id";
	    entityManager.createQuery(jpql)
	            .setParameter("id", id)
	            .executeUpdate();
		
	}
	
	public void editar(Long id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) throws SQLException {
		String jpql = "UPDATE Hospedes h SET h.nome = :nome, h.sobrenome = :sobrenome, h.dataNascimento = :dataNascimento, h.nacionalidade = :nacionalidade, h.telefone = :telefone WHERE h.id = :id";
		entityManager.createQuery(jpql)
		.setParameter("nome", nome)
		.setParameter("sobrenome", sobrenome)
		.setParameter("dataNascimento", dataNascimento)
		.setParameter("nacionalidade", nacionalidade)
		.setParameter("telefone", telefone)
		.executeUpdate();
	}
	
	
	

}
