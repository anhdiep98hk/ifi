package com.ifi;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifi.model.Khoahoc;
import com.ifi.model.Lophoc;
import com.ifi.model.Sinhvien;
import com.ifi.service.KhoaHocService;
import com.ifi.service.LopHocService;
import com.ifi.service.SinhVienService;

@SpringBootApplication
public class JpaApplicationStudentApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(JpaApplicationStudentApplication.class);

	@Autowired
	private LopHocService lopHocService;

	@Autowired
	private SinhVienService sinhVienService;

	@Autowired
	private KhoaHocService khoaHocService;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplicationStudentApplication.class, args);
	}

	static Scanner sc = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int menu;
		for(Lophoc kh: lopHocService.getKhoaHocBySinhVien(2)) {
			log.info(kh.toString());
		}
		while (true) {
			log.info("1. Insert");
			log.info("2. Update");
			log.info("3. Delete");
			log.info("4. Show All");
			log.info("5. Find by SinhVienId");
			log.info("6. Exit");
			System.out.print("Chon menu: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				this.insert();
				break;
			case 2:
				break;

			case 3:
				this.deleteLopHoc();
				break;

			case 4:
				this.showAll();
				break;
			case 5:
				this.findByIdSinhVien();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				log.error("Chon tu 1-6");
				break;
			}
		}

	}

	public void insert() {
		Sinhvien sv = new Sinhvien();
		Khoahoc kh = new Khoahoc();
		int siso;
		log.info("================================ Insert ================================");
		log.info("-------------------------Danh sach SinhVien-------------------------");
		for (Sinhvien s : sinhVienService.getAllSinhVien()) {
			log.info("\t\t\t\t" + s.toString());
		}
		System.out.print("Chon id sinhvien: ");
		sv.setId(Integer.parseInt(sc.nextLine()));

		log.info("-------------------------Danh sach KhoaHoc-------------------------");
		for (Khoahoc s : khoaHocService.getAllKhoaHoc()) {
			log.info("\t\t\t\t" + s.toString());
		}
		System.out.print("Chon id khoahoc: ");
		kh.setId(Integer.parseInt(sc.nextLine()));

		System.out.print("Nhap siso: ");
		siso = Integer.parseInt(sc.nextLine());

		Lophoc lh = new Lophoc(siso, sinhVienService.getSinhVienById(sv.getId()),
				khoaHocService.getKhoaHocById(kh.getId()));
		lopHocService.insert(lh);
		System.out.println("Inserted");
	}

	public void showAll() {
		for (Lophoc lh : lopHocService.getAllLopHoc()) {
			log.info(lh.toString());
		}
	}

	public void findByIdSinhVien() {
		System.out.print("Nhap idSV can tim: ");
		int idSV = Integer.parseInt(sc.nextLine());
		for(Lophoc kh: lopHocService.getKhoaHocBySinhVien(idSV)) {
			log.info(kh.toString());
		}
		
	}
	
	public void deleteLopHoc() {
		System.out.print("Nhap idSV can xoa: ");
		int idSv = Integer.parseInt(sc.nextLine());
		lopHocService.deleteLopHocBySinhVien(idSv);
		log.info("Deleted");
	}
}
