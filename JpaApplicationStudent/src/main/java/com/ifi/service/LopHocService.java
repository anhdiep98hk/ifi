package com.ifi.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifi.model.Lophoc;



@Service
@Transactional
public class LopHocService {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Lophoc> getAllLopHoc(){
//		String hql = String.format("select lh from %s lh", Lophoc.class.getName());
		String hql = "FROM Lophoc";
		return em.createQuery(hql).getResultList();
	}

	public void insert(Lophoc lh) {
		em.persist(lh);
	}
	
	public Lophoc findByIdSinhVien(int id) {
		return em.find(Lophoc.class, id);
	}
	
	
	public void update(Lophoc lh) {
		Lophoc l = this.findByIdSinhVien(lh.getSinhvien().getId());
		l.setKhoahoc(lh.getKhoahoc());
		l.setSiso(lh.getSiso());
		em.flush();			
	}
	
	@SuppressWarnings("unchecked")
	public List<Lophoc> getKhoaHocBySinhVien(int id){
		String hql = String.format("SELECT sv FROM %s sv WHERE sv.sinhvien.id = :idSV", Lophoc.class.getName());
		return em.createQuery(hql).setParameter("idSV", id).getResultList();
	}
	
	public void deleteLopHocBySinhVien(int id) {
		em.createQuery("delete from Lophoc lh where lh.sinhvien.id = :idSV").setParameter("idSV", id).executeUpdate();		
	}
}
