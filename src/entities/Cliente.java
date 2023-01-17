package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNome() + " " );
		sb.append(this.getDataNascimento().format(fmt) + " ");
		sb.append(this.getEmail() + "\n");
		return sb.toString();
	}
}
