package com.org.rss.Sangthan.Entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Designation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Transient
	private Rank rank;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "designation")
	private List<Person> person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() { 
		return name;
	}
	public void setName( String name) {
		this.name = name;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public List<Person> getPerson() {
		return person;
	}
	public void setPerson(List<Person> person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Designation [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}

}
