package br.com.alura.hotel.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private BigDecimal valor;
	private String formaDePagamento;
	
	@OneToOne(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Hospede hospede;
	
	
	
	
	public Reserva() {
	}
	


	public Reserva(LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valor, String formaDePagamento) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
	}

	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	
	
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	
	
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
	public BigDecimal getValor() {
		return valor;
	}
	
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	
	
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	

	public Hospede getHospede() {
		return hospede;
	}



	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
	
	

	

}
