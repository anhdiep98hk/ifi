package com.ifi.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifi.model.Sinhvien;

@Service
@Transactional
public class SinhVienService {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Sinhvien> getAllSinhVien(){
//		String hql = String.format("select sv from %s sv", Sinhvien.class.getName());
		String hql ="FROM Sinhvien";
		return em.createQuery(hql).getResultList();
	}
	
	public Sinhvien getSinhVienById(int id) {
		return em.find(Sinhvien.class, id);
	}
	
	
}
