package br.com.alura.hotel.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import br.com.alura.hotel.modelo.Hospede;
import br.com.alura.hotel.modelo.Reserva;

public class ReservaDAO {

	private EntityManager emtityManager;

	public ReservaDAO(EntityManager em) {
		this.emtityManager = em;
	}

	public void cadastrar(Reserva reserva) {
		this.emtityManager.getTransaction().begin();
		this.emtityManager.persist(reserva);
		this.emtityManager.getTransaction().commit();
	}

	public void atualizar(Reserva reserva) {
		this.emtityManager.getTransaction().begin();
		this.emtityManager.merge(reserva);
		this.emtityManager.getTransaction().commit();
	}
	
	
	public void deletar(Long id) {
		String jpql = "DELETE FROM Reserva r WHERE r.id = :id";
	    emtityManager.createQuery(jpql)
	            .setParameter("id", id)
	            .executeUpdate();
		
	}
	
	public Reserva buscarPorId(Long id) {
		return emtityManager.find(Reserva.class, id);
	}
	
	public List<Reserva> buscarTodos() {
		String jpql = "SELECT r FROM Reserva r";
		return emtityManager.createQuery(jpql, Reserva.class).getResultList();
	}
	
	public Reserva buscarPorIdDoHospede(Long id) {
		String jpql = "SELECT r FROM Reserva r WHERE r.hospede.id = :id";
		return emtityManager.createQuery(jpql, Reserva.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public List<Reserva> buscarPorParametros(LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valor,
			String formaPagamento) {
		String jpql = "SELECT r FROM Reserva r WHERE 1=1 ";
		if (dataEntrada != null) {
			jpql += " AND r.dataEntrada = :dataEntrada ";
		}
		if (dataSaida != null) {
			jpql += " AND r.dataSaida = :dataSaida ";
		}
		if (valor != null) {
			jpql += " AND r.valor = :valor ";
		}
		if (formaPagamento != null && !formaPagamento.trim().isEmpty()) {
			jpql += " AND r.formaPagamento = :formaPagamento ";
		}
		TypedQuery<Reserva> query = emtityManager.createQuery(jpql, Reserva.class);
		if (dataEntrada != null){
			query.setParameter("dataEntrada", dataEntrada);
		}
		if (dataSaida != null) {
			query.setParameter("dataSaida", dataSaida);
		}
		if (valor != null) {
			query.setParameter("valor", valor);
		}
		if (formaPagamento != null && !formaPagamento.trim().isEmpty()) {
			query.setParameter("formaPagamento", formaPagamento);
		}
		
		return query.getResultList();
	}

	public void editar(Long id, Date dataE, Date dataS) {
		String jpql = "UPDATE Reserva r SET r.dataEntrada = :dataEntrada, r.dataSaida = :dataSaida WHERE r.id = :id";
		emtityManager.createQuery(jpql)
		.setParameter("dataEntrada", dataE)
		.setParameter("dataSaida", dataS)
		.executeUpdate();
    }

}