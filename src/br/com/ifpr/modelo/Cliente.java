package br.com.ifpr.modelo;

public class Cliente {
	private int codigo;
	private String nome;
	private String email;
	private String dataNascimento;
	private Long telefone;
	
	public int getCodigo() {
		return codigo;
	}
		
	public void setCodigo(int c) {
		this.codigo = c;
	}
	
	public String getNome() {
		return nome;
	}
		
	public void setNome(String n) {
		this.nome = n;
	}

	public String getEmail() {
		return email;
	}
		
	public void setEmail(String e) {
		this.email = e;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
		
	public void setDataNascimento(String d) {
		this.dataNascimento = d;
	}	
		
	public Long getTelefone() {
		return telefone;
	}
		
	public void setTelefone(Long t) {
		this.telefone = t;
	}		
}