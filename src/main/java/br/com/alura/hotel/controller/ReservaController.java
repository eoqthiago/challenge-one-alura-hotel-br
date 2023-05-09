package br.com.alura.hotel.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.hotel.dao.ReservaDAO;
import br.com.alura.hotel.modelo.Reserva;
import br.com.alura.util.JPAUtil;

public class ReservaController {

	private ReservaDAO reservaDao;
	
	public ReservaController() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		this.reservaDao = new ReservaDAO(entityManager);
	}
	
	public void cadastrar(Reserva reserva) {
		this.reservaDao.cadastrar(reserva);
	}
	
	public void atualizar(Reserva reserva) {
		this.reservaDao.atualizar(reserva);
	}
	
	public void deletar(Long id) {
		this.reservaDao.deletar(id);
	}
	
	public Reserva buscarPorId(Long id) {
		return this.reservaDao.buscarPorId(id);
	}
	
	public List<Reserva> buscarTodos() {
		return this.reservaDao.buscarTodos();
	}
	
	public Reserva buscarPorIdDoHospede(Long id) {
		return this.reservaDao.buscarPorIdDoHospede(id);
	}
	
	public void editar(Long id, Date dataE, Date dataS) {
		this.reservaDao.editar(id, dataE, dataS);
	}
	
	public List<Reserva> buscarPorParametros(LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valor,
			String formaPagamento) {
		return this.buscarPorParametros(dataEntrada, dataSaida, valor, formaPagamento);
	}
	
}