package com.fabricadeprogramador.persistencia.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil", initialValue = 1)
	@GeneratedValue(generator = "seq_perfil", strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String descricao;

	public Perfil() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Hash code e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Perfil [id=" + id + ", descricao=" + descricao + "]";
	}

}
