MiddlewareJEE
==========
Project Omazon: An online shopping store with MS SQL Server as backend and JSP/JSF as front end. All database communication are through the ORM Mapper, Hibernate. The featues are as below:
Customer and Product Data Management
a) Business Logic 
b) User Interface 
Order Process Support
a) Order Process
b) Shipment Status Update 
c) User Interface

Project OmazonClient: Native Client version of the above project

Project DelTest and MBDTest: 
Shipment tracking via JMS messages
  a) Automated shipment status updates 
  b) Shipment position updates 
Notification on exceptional events
  a) On shipment status page 
  b) By email
DelTest reads XML File formats and parses it and adds messages to Queues / Topics
MBDTest consumes the messages through message driven bean (EJB) and takes the necessary actions
