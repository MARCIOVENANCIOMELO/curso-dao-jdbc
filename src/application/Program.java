package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seller FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TESTE 2: seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("=== TESTE 3: seller FindAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("=== TESTE 4: seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "gregmail.com", new Date(),4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("INSERTED new Id = " + newSeller.getId());
		
		System.out.println("=== TESTE 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update complete");
		
		System.out.println("=== TESTE 6: seller Delete ===");
		System.out.println("Entre com codigo para deleção: ");
		
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete");
		
		sc.close();
					
	}

}
