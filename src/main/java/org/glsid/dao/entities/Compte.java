package org.glsid.dao.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
include=JsonTypeInfo.As.PROPERTY,
property="type")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE", value=CompteEpargne.class)
})
public abstract class Compte implements Serializable{
	@Id
	private String code;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe employe;
	@OneToMany(mappedBy="compte")
	Collection<Operation> operations;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String code, Date dateCreation, double solde) {
		super();
		this.code = code;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
@JsonIgnore
	public Client getClient() {
		return client;
	}
@JsonSetter
	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnore
	public Employe getEmploye() {
		return employe;
	}
	@JsonSetter
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	

}
