package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the lophoc database table.
 * 
 */
@Entity
public class Lophoc implements Serializable {
	private static final long serialVersionUID = 1L;

	private int siso;

	//bi-directional many-to-one association to Sinhvien
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_sv")
	private Sinhvien sinhvien;

	//bi-directional many-to-one association to Khoahoc
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_kh")
	private Khoahoc khoahoc;

	public Lophoc() {		
	}
	
	

	public Lophoc(int siso, Sinhvien sinhvien, Khoahoc khoahoc) {
		super();
		this.siso = siso;
		this.sinhvien = sinhvien;
		this.khoahoc = khoahoc;
	}



	public int getSiso() {
		return this.siso;
	}

	public void setSiso(int siso) {
		this.siso = siso;
	}

	public Sinhvien getSinhvien() {
		return this.sinhvien;
	}

	public void setSinhvien(Sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public Khoahoc getKhoahoc() {
		return this.khoahoc;
	}

	public void setKhoahoc(Khoahoc khoahoc) {
		this.khoahoc = khoahoc;
	}

	@Override
	public String toString() {
		return "Lophoc [  sinhvien= " + sinhvien.getName() + ", khoahoc= " + khoahoc.getName() + ", siso= " + siso  + "]";
	}

	
}