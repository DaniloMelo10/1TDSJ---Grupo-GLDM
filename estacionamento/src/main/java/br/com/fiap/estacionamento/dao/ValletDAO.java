package br.com.fiap.estacionamento.dao;

import java.util.Date;
import br.com.fiap.estacionamento.model.entities.Vallet;

public class ValletDAO {
	private static final long TEMPO_MINIMO = 0;
	private static final double PRECO_BASE = 4;
	private static final double PRECO_ADICIONAL = 2.50;
	
	public double calcularPagamento(Date entrada, Date saida) {
		double preco = 0.0;
		long tempoPermanecia = (saida.getTime() - entrada.getTime()) / 1000 / 60;
		long horas = tempoPermanecia / 60;
		long minutos = tempoPermanecia % 60;
		if (this.temHorasAdicionais(this.qtdeHorasAdicionais(horas))) {
		preco = this.PRECO_BASE;
		preco = preco + this.qtdeHorasAdicionais(horas) * this.PRECO_ADICIONAL;
		if (minutos > 0) {
		preco = preco + this.PRECO_ADICIONAL;
		}
		} else {
		preco = this.PRECO_BASE;
		}
		return preco;
		}
		public long qtdeHorasAdicionais(long horas) {
		return horas - this.TEMPO_MINIMO;
		}
		public boolean temHorasAdicionais(long horasAdicionais) {
		return horasAdicionais > 0;
		}
		 

}
