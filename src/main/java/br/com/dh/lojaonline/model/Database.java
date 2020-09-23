package br.com.dh.lojaonline.model;

import java.util.*;

public class Database {
	private static Map<String, List<Object>> database = new HashMap<>();
	private static List<Object> clientes = new ArrayList<>();
	private static List<Object> produtos = new ArrayList<>();
	private static List<Object> pedidos = new ArrayList<>();
	
	public Database() {
		database.put("clientes", clientes);
		database.put("produtos", produtos);
		database.put("pedidos", pedidos);
	}
	
	public void save(String tabela, Object obj) {
		database.get(tabela).add(obj);
	}
	
	public List<Object> list(String tabela){
		return database.get(tabela);
	}

}
