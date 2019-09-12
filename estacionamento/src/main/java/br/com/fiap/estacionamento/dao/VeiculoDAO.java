package br.com.fiap.estacionamento.dao;


import java.util.ArrayList;

import br.com.fiap.estacionamento.model.entities.Veiculo;

	public class VeiculoDAO {
		private static ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		public void adicionarModelo(Veiculo v) {
			if(v != null) veiculo.add(v);
		}
		
		public ArrayList<Veiculo> consultarTodosVeiculos() {
			return veiculo;
		}
		
		public Veiculo consultarVeiculo(String modelo) {
			for(Veiculo v : veiculo) {
				if(v.getModelo() == modelo) {
					return v;
				}
			}
			return null;
		}

	}



