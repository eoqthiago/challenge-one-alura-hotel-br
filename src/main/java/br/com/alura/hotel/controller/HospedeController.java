package br.com.alura.hotel.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.hotel.dao.HospedeDAO;
import br.com.alura.hotel.modelo.Hospede;
import br.com.alura.hotel.modelo.Reserva;
import br.com.alura.util.JPAUtil;

public class HospedeController {

	private HospedeDAO hospedeDao;
	
	public HospedeController() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		this.hospedeDao = new HospedeDAO(entityManager);
	}
	
	public void cadastrar(Hospede hospede) {
		this.hospedeDao.cadastrar(hospede);
	}
	
	public void atualizar(Hospede hospede) {
		this.hospedeDao.atualizar(hospede);;
	}
	
	public List<Hospede> buscarTodosHospedes() {
		return this.hospedeDao.buscarTodos();
	}
	
	
	
	public void remover(Hospede hospede) {
		this.hospedeDao.remover(hospede);
	}
	
	public Hospede buscarPorId(Long id) {
		return this.hospedeDao.buscarPorId(id);
	}
	
	public List<Hospede> buscarTodos() {
		return this.hospedeDao.buscarTodos();
	}
	
	public Hospede buscarPorIdDaReserva(Long id) {
		return this.hospedeDao.buscarPorIdDaReserva(id);
	}
	
	public void deletar(Long id) {
		this.hospedeDao.deletar(id);
	}
	
	
	public void deletarIdReserva(Long idReserva) {
    	this.hospedeDao.deletarIdReserva(idReserva);
    }
	
	public void editar(Long id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) throws SQLException {
    	this.hospedeDao.editar(id, nome, sobrenome, dataNascimento, nacionalidade, telefone);
    }
	
}