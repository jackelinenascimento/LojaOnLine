package br.com.dh.lojaonline.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	private String nfe;
	private LocalDate data_emissao;
	private double valor_total;
	private String status_pedido;
	private int fk_produto;
	private int fk_cliente;
	
	public Pedido() {}
	
	public Pedido(String nfe, LocalDate data_emissao, double valor_total, String status_pedido,
			int fk_produto, int fk_cliente) {
		this.nfe = nfe;
		this.data_emissao = data_emissao;
		this.valor_total = valor_total;
		this.status_pedido = status_pedido;
		this.fk_produto = fk_produto;
		this.fk_cliente = fk_cliente;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public String getNfe() {
		return nfe;
	}

	public void setNfe(String nfe) {
		this.nfe = nfe;
	}

	public LocalDate getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(LocalDate data_emissao) {
		this.data_emissao = data_emissao;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public String getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}

	public int getFk_produto() {
		return fk_produto;
	}

	public void setFk_produto(int fk_produto) {
		this.fk_produto = fk_produto;
	}

	public int getFk_cliente() {
		return fk_cliente;
	}

	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}
	
}
