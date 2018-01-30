package com.ifi.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifi.model.Khoahoc;


@Service
@Transactional
public class KhoaHocService {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Khoahoc> getAllKhoaHoc(){
		String hql = String.format("select kh from %s kh", Khoahoc.class.getName());
		return em.createQuery(hql).getResultList();
	}
	
	public Khoahoc getKhoaHocById(int id) {
		return em.find(Khoahoc.class, id);
	}
}
