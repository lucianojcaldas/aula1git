package trabalho3;

import java.io.Serializable;

import javax.swing.JTextField;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String idade;

	public Pessoa() {
	}

	public Pessoa(String nome, String idade) {

		this.nome = nome;
		this.idade = idade;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String cx1) {
		this.nome = cx1;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String cx2) {
		this.idade = cx2;
	}

}











