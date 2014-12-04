MiddlewareJEE
==========
Project Omazon: An online shopping store with MS SQL Server as backend and JSP/JSF as front end. All database communication are through the ORM Mapper, Hibernate. The featues are: "Business Logic and User Interface for  Customer and Product Data Management" and "Order Processing with Shipment Status Update".

Project OmazonClient: Native Client version of the Omazon project

Project DelTest and MBDTest: Shipment tracking via JMS messages that includes automated shipment status updating and Shipment position updates. Also, Notification on exceptional events on shipment status page and via email to the customer

DelTest reads XML File formats and parses it and adds messages to Queues / Topics.
MBDTest consumes the messages through message driven bean (EJB) and takes the necessary actions
