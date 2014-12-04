/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* Local Client Main Program 					        						*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.UI;

import java.util.Scanner;

public class Client {

	public static String userName;
	public static String LoginPass;
	static Scanner input = new Scanner(System.in);
	
    ManageProduct MP = new ManageProduct();				//	Object to the Product Management Operations 
	ManageEmployee ME = new ManageEmployee();			//	Object to the Employee Management Operations
	ManageOrders MO = new ManageOrders();
	
	public static void main(String[] args) {

		Client OM = new Client();							//	Object to the Home Class
        LoginValidation VL = new LoginValidation();			// 	Object to the Login Validation Operation
	
/*	Login Section - Getting User Input and Validating Login*/
		
		String password;
				
		// Using Scanner Class to read User Input
		
		System.out.println("Welcome to Omazon. Login as Admin/Employee");
		
		System.out.println("UserName:");
			userName = input.next();
		System.out.println("Password:");
			password = input.next();
		
		LoginPass = VL.validateLogin(userName,password); 
			switch(LoginPass)
			{
			case "A":
				OM.AdminMode();
				break;
			case "E":
				OM.EmployeeMode();
				break;
			case "C":
				System.out.println("CUSTOMER LOGIN CANNOT BE USED FOR ADMINISTRATION PURPOSES");
				break;
					
			default: System.out.println("Invalid Password");
			}
			
			input.close(); 		
	}
/* End of Main Method */	
	
/*	Admin Mode */
			
		public void AdminMode(){
			
			Short adminChoice;
											
			System.out.println("Welcome " + userName);
			
			System.out.println("\n1.MANAGE PRODUCTS \n2.MANAGE EMPLOYEE \n WHAT WOULD YOU LIKE TO DO?\n:");
			adminChoice = input.nextShort();
			
			switch(adminChoice)
			{
			case 1:
				MP.productHome();
				break;
					
			case 2:
				ME.employeeHome();
				break;
			default: System.out.println("Wrong Choice:");
			}
			
				
			
		}
				
/*	Employee Mode */		

		public void EmployeeMode(){
			
			Short empChoice;
			
			System.out.println("Welcome " + userName);
			
			System.out.println("\n1.MANAGE PRODUCTS \n2.UPDATE PERSONAL INFO \n3.MANAGE SHIPMENTS \n WHAT WOULD YOU LIKE TO DO?\n:");
			empChoice = input.nextShort();
			
			switch(empChoice)
			{
			case 1:
				MP.productHome();
				break;
					
			case 2:
				ME.employeeHome();
				break;
			case 3:
				MO.orderHome();
				break;
			default: System.out.println("Wrong Choice:");
			}
			
		}
	}