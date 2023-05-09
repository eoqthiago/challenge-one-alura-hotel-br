package br.com.alura.hotel.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.hotel.dao.HospedeDAO;
import br.com.alura.hotel.dao.ReservaDAO;
import br.com.alura.hotel.modelo.Hospede;
import br.com.alura.hotel.modelo.Reserva;
import br.com.alura.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();

		
		// List<Hospede> hospede = hospedeDAO.buscarPorParametros(null, null, null, null, null);
		// hospede.forEach(h -> System.out.println(h.getNome()));
		
		// List<Reserva> reserva = reservaDAO.buscarPorParametros(null, null, null, null);
		// reserva.forEach(r -> System.out.println(r.getId()));
		
		
		em.getTransaction().commit();
		em.close();
	}

}