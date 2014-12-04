/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/*							 Product Management							       	*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.UI;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.omazon.Hiber.GetSessionFactory;
//import com.omazon.Hiber.Login;
import com.omazon.Hiber.Product;

public class ManageProduct {
	
/* Entry Function - Start */
	public void productHome(){
		
		Short userChoice;
		Scanner input = new Scanner(System.in);
		ManageProduct MP = new ManageProduct();
		Client OM = new Client();
		
		
		System.out.println("\n1.VIEW ALL AVAILABLE PRODUCTS"
				+ "\n2.ADD A NEW PRODUCT"
				+ "\n3.VIEW A PARTICULAR PRODUCT"
				+ "\n4.EDIT AN EXISTING PRODUCT"
				+ "\n5.REMOVE AN EXISTING PRODUCT"
				+ "\n6.GO BACK TO MAIN SCREEN"
				+ "\n7.EXIT"
				+ "\n WHAT WOULD YOU LIKE TO DO? \n:"
				);
		userChoice = input.nextShort();
		
		switch(userChoice)
			{
			case 1:MP.displayAllProduct();break;
			case 2:MP.addProduct();break;
			case 3:MP.viewProduct();break;
			case 4:MP.editProduct();break;
			case 5:MP.removeProduct(); break;
			case 6:
				if(Client.LoginPass.equals("A"))
					OM.AdminMode();
				else
					OM.EmployeeMode();
				break;
			case 7:System.exit(0); break;
			default: System.out.println("Wrong Choice:");
			}
		input.close();
		
		}
/* Entry Function - End */	
	
	
	@SuppressWarnings("unchecked")
	protected void displayAllProduct(){

		ManageProduct MP = new ManageProduct();
		
		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction(); 
		
		List<Product> allProducts;
		
		Query query= ss.createQuery("FROM Product where delFlag = :del ");
		query.setParameter("del", "ND");
		allProducts  = query.list();
		
		
		System.out.println("\nPRODUCT ID"+'\t'+"PRODUCT NAME"+'\t'+"PRODUCT PRICE"+'\t'+"PRODUCT QUANTITY"+'\t'+"PRODUCT DESCRIPTION");
		System.out.println("\n----------"+'\t'+"------------"+'\t'+"-------------"+'\t'+"----------------"+'\t'+"-------------------");
		for(Iterator<Product> i = allProducts.iterator(); i.hasNext();){
			Product P = (Product)i.next();
				
		System.out.println(P.getProdID()+"\t\t"+P.getProdName()+"\t\t"+P.getProdPrice()+"\t\t"+P.getProdQuan()+"\t\t"+P.getProdDesc());
		}
		
		tx.commit();	
		ss.close();
		
		MP.productHome();
	}
		
	
	protected void addProduct(){
				
		String prodName;
		Short prodPrice;
		Short prodQuan;
		String prodDesc;
		String delFlag="ND";
		Scanner input = new Scanner(System.in);
		ManageProduct MP = new ManageProduct();
		
		System.out.println("\nENTER THE DETAILS OF THE NEW PRODUCT\n");
		System.out.println("\n => PRODUCT NAME"+'\t'+":");
		prodName=input.nextLine();
		System.out.println("\n => PRODUCT PRICE(€)"+'\t'+":");
		prodPrice=input.nextShort();
		System.out.println("\n => PRODUCT QUANTITY"+'\t'+":");
		prodQuan=input.nextShort();
		System.out.println("\n => PRODUCT DESCRIPTION"+'\t'+":");
		prodDesc=input.next();
		
		Product P = new Product();
		P.setProdName(prodName);
		P.setProdPrice(prodPrice);
		P.setProdQuan(prodQuan);
		P.setProdDesc(prodDesc);
		P.setDelFlag(delFlag);

		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction();
		
		ss.save(P);
		
		System.out.println("\nTHE NEW PRODUCT "+P.getProdName()+" HAS BEEN CREATED SUCCESSFULLY");

		tx.commit();	
		ss.close();
		
		MP.productHome();
		input.close();		
	}
	
	protected void viewProduct(){

		Integer prodID;
		Short userChoice;
		Scanner input = new Scanner(System.in);
		ManageProduct MP = new ManageProduct();
		
		System.out.println("\n ENTER THE PRODUCT ID"+'\t'+":");
		prodID=input.nextInt();
		
		Product P = new Product();
		
		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction();
		
		try{
				P = (Product)ss.get(Product.class, prodID);
				
				if(!P.getDelFlag().equals("ND")){
						System.out.println("The Product for the ID might have been Deleted or Incorrect ID ");
					}
			
				else{
						System.out.println("\nPRODUCT ID"+'\t'+"PRODUCT NAME"+'\t'+"PRODUCT PRICE"+'\t'+"PRODUCT QUANTITY"+'\t'+"PRODUCT DESCRIPTION");
						System.out.println("\n----------"+'\t'+"------------"+'\t'+"-------------"+'\t'+"----------------"+'\t'+"-------------------");
						System.out.println(P.getProdID()+"\t\t"+P.getProdName()+"\t\t"+P.getProdPrice()+"\t\t"+P.getProdQuan()+"\t\t"+P.getProdDesc());
							
						tx.commit();	
						ss.close();
						
						System.out.println("\nDO YOU WANT TO 1.EDIT (or) 2.DELETE THIS PRODUCT? (or) JUST 3.GO BACK\n:");
						userChoice=input.nextShort();
						
						switch(userChoice)
						{
							case 1: MP.editProduct();break;
							case 2: MP.removeProduct();break;
							case 3: MP.productHome();break;
							default: System.out.println("PLEASE CHOOSE WISELY");
						}
					}
				}
		 catch(HibernateException e){
			 System.out.println("INVALID PRODUCT ID ENTERED" + e );
		 	}
		
		MP.productHome();
		
		input.close();				
	}
	
	
	protected void editProduct(){

		String prodName;
		Short prodPrice;
		Short prodQuan;
		String prodDesc;
		Integer prodID;
		
		Scanner input = new Scanner(System.in);
		ManageProduct MP = new ManageProduct();
		
		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction();
		
		System.out.println("\nENTER THE PRODUCT ID TO EDIT\n");
		System.out.println("\n => PRODUCT ID"+'\t'+":");
		prodID = input.nextInt();
		
		
		Product P = (Product)ss.get(Product.class, prodID);
		
		if(!P.getDelFlag().equals("ND")){
				System.out.println("The Product for the ID might have been Deleted or Incorrect ID ");
			}
		
		else
		{
			System.out.println("\nENTER THE NEW DETAILS OF THE PRODUCT");
			System.out.println("\n------------------------------------\n");
			System.out.println("\n => PRODUCT NAME"+'\t'+":");
			prodName=input.next();
			System.out.println("\n => PRODUCT PRICE(€)"+'\t'+":");
			prodPrice=input.nextShort();
			System.out.println("\n => PRODUCT QUANTITY"+'\t'+":");
			prodQuan=input.nextShort();
			System.out.println("\n => PRODUCT DESCRIPTION"+'\t'+":");
			prodDesc=input.next();
		
				
			P.setProdName(prodName);
			P.setProdPrice(prodPrice);
			P.setProdDesc(prodDesc);
			P.setProdQuan(prodQuan);
			
			ss.update(P); 
			
			System.out.println("\nTHE NEW PRODUCT "+P.getProdName()+" HAS BEEN EDITED SUCCESSFULLY");
	
			tx.commit();	
			ss.close();
		
		}
		
		MP.productHome();
		input.close();
	}
	
	
protected void removeProduct(){

		String delFlag="D";
		Integer prodID;
		
		Scanner input = new Scanner(System.in);
		ManageProduct MP = new ManageProduct();
		
		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction();
		
		System.out.println("\nENTER THE PRODUCT ID TO REMOVE\n");
		System.out.println("\n => PRODUCT ID"+'\t'+":");
		prodID = input.nextInt();
					
		Product P = (Product)ss.get(Product.class, prodID);
		P.setDelFlag(delFlag);
		ss.update(P); 
		
		System.out.println("\nTHE NEW PRODUCT "+P.getProdName()+" HAS BEEN REMOVED SUCCESSFULLY");
	
		tx.commit();	
		ss.close();
		
		MP.productHome();
		input.close();
		
	}
}