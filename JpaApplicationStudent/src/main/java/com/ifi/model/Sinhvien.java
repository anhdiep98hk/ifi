package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the sinhvien database table.
 * 
 */
@Entity
public class Sinhvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String name;

	private String phone;

	//bi-directional many-to-one association to Lophoc
	@OneToMany(mappedBy="sinhvien")
	@Fetch(FetchMode.SELECT)
	private List<Lophoc> lophocs;

	public Sinhvien() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Lophoc> getLophocs() {
		return this.lophocs;
	}

	public void setLophocs(List<Lophoc> lophocs) {
		this.lophocs = lophocs;
	}

	public Lophoc addLophoc(Lophoc lophoc) {
		getLophocs().add(lophoc);
		lophoc.setSinhvien(this);

		return lophoc;
	}

	public Lophoc removeLophoc(Lophoc lophoc) {
		getLophocs().remove(lophoc);
		lophoc.setSinhvien(null);

		return lophoc;
	}

	@Override
	public String toString() {
		return "Sinhvien [id=" + id + ", name=" + name + "]";
	}

	
}