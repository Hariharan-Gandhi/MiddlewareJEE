/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/*							 Order Processing							       	*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.UI;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.omazon.Hiber.GetSessionFactory;
import com.omazon.Hiber.OrderHeader;
import com.omazon.Hiber.Shipment;
import com.omazon.Hiber.Truck;

public class ManageOrders {
	public void orderHome(){

		Short userChoice;
		Scanner input = new Scanner(System.in);
		ManageOrders MO = new ManageOrders();
		Client OM = new Client();
		
		System.out.println("\n1.VIEW SHIPMENTS"
				+ "\n2.UPDATE SHIPMENT STATUS"
				+ "\n3.GO BACK TO MAIN SCREEN"
				+ "\n4.EXIT"
				+ "\n WHAT WOULD YOU LIKE TO DO? \n:"
				);
		userChoice = input.nextShort();
		
		switch(userChoice)
		{
		case 1:MO.displayShipments();break;
		case 2:MO.updateShipmentStatus();break;
		case 3:
			if(Client.LoginPass.equals("A"))
				OM.AdminMode();
			else
				OM.EmployeeMode();
			break;
		case 4:System.exit(0); break;
		default: System.out.println("Wrong Choice:");
		}
		input.close();
	}
	
	@SuppressWarnings("unchecked")
	protected void displayShipments(){
				
		ManageOrders MO = new ManageOrders();
		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction(); 
		
		List<Shipment> allShipments;
		
		Query query= ss.createQuery("FROM Shipment");
		allShipments = query.list();
		OrderHeader temp1 = new OrderHeader();
		Truck temp2 = new Truck();
		System.out.println("\nSHIPMENT ID"+'\t'+"DELIVERY DATE"+'\t'+'\t'+"ORDER ID"+'\t'+"TRUCK ID"+'\t'+"SHIPMENT STATUS");
		System.out.println("\n----------"+'\t'+"------------"+'\t'+'\t'+"-------------"+'\t'+"----------------"+'\t'+"-------------------");
		for(Iterator<Shipment> i = allShipments.iterator(); i.hasNext();)
		{
			Shipment S = (Shipment)i.next();
			temp1 = S.getOrderheader();
			temp2 = S.getTruck();
				
		System.out.println(S.getShipmentID()+"\t\t"+S.getDelDate()+"\t\t"+temp1.getOrderID()+"\t\t"+temp2.getTruckID()+"\t\t"+S.getShipStatus());
		}
		
		MO.orderHome();
	}
	protected void updateShipmentStatus(){
		
		ManageOrders MO = new ManageOrders();
		Integer orderID;
		Scanner input = new Scanner(System.in);
		
		
		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction();
		
		System.out.println("\nENTER THE ORDER ID TO UPDATE\n");
		System.out.println("\n => ORDER ID"+'\t'+":");
		orderID = input.nextInt();
		
		Date delDate = new Date();
		
		Query query = ss.createQuery("FROM OrderHeader where OrderID = :OrderID ");							
		query.setParameter("OrderID", orderID);				
		OrderHeader oh = (OrderHeader)query.uniqueResult();						
		//OrderHeader oh = new OrderHeader();
		// oh.setOrderID(intorder);
		Query query1 = ss.createQuery("FROM Shipment where orderheader = :order ");
		query1.setParameter("order", oh);		
		Shipment shipment = (Shipment)query1.uniqueResult();
		
		shipment.setDelDate(delDate);
		shipment.setShipStatus("Delivered");
		
		ss.update(shipment);
		
		tx.commit();
		ss.close();	
		
		System.out.println("Shipment Status has been updated successfully!");
		
		MO.orderHome();
	}
	
}
