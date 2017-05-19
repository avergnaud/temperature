package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEMPERATURE")
public class Temperature implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime ts;
	private int valeur;
	
	public Temperature(){}
	
	public Temperature(LocalDateTime ts, int valeur) {
		super();
		this.ts = ts;
		this.valeur = valeur;
	}
	public LocalDateTime getTs() {
		return ts;
	}
	public void setTs(LocalDateTime ts) {
		this.ts = ts;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
