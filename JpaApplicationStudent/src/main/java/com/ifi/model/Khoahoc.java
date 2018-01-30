package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the khoahoc database table.
 * 
 */
@Entity
public class Khoahoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Lophoc
	@OneToMany(mappedBy="khoahoc")
	@Fetch(FetchMode.SELECT)
	private List<Lophoc> lophocs;

	public Khoahoc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Lophoc> getLophocs() {
		return this.lophocs;
	}

	public void setLophocs(List<Lophoc> lophocs) {
		this.lophocs = lophocs;
	}

	public Lophoc addLophoc(Lophoc lophoc) {
		getLophocs().add(lophoc);
		lophoc.setKhoahoc(this);

		return lophoc;
	}

	public Lophoc removeLophoc(Lophoc lophoc) {
		getLophocs().remove(lophoc);
		lophoc.setKhoahoc(null);

		return lophoc;
	}

	@Override
	public String toString() {
		return "Khoahoc [id=" + id + ", name=" + name + "]";
	}

	
}