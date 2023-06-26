# Reward Points Application
A Spring Boot Web Restful Service for a reward point application

A Reward Point Service made with a Spring boot application
1. Create two services to show the customer’s reward point and last three-month reward point report.
2. Technologies used: Spring boot, JDK 11, Spring Data JPA, Junit 5
3. Create two tables: customer(id, name), 	transaction_record (id, amount, purchase_date,  customer_id)
4. To start, run mvn spring-boot:run
5. Verify the server log to confirm with the following message:
   2023-06-25 14:21:22.270  INFO 25000 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8090 (http) with context path ''
   2023-06-25 14:21:22.284  INFO 25000 --- [           main] r.o.r.RewardsprogramApplication          : Started RewardsprogramApplication in 9.255 seconds (JVM running for 10.173)
   2023-06-25 14:22:58.849  INFO 25000 --- [nio-8090-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
   2023-06-25 14:22:58.849  INFO 25000 --- [nio-8090-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
   2023-06-25 14:22:58.849  INFO 25000 --- [nio-8090-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
6. 6.Application test
a.	Open a browser, enter: http://localhost:8080/api/v1/rewards/, then you should get the customer three month reward reports for two customers, each customer has it’s reward point calculated by month. 
b.	Open a browser, enter: http://localhost:8080/api/v1/rewards/customer/1, then you should get the customer  1’s reward point and group by the month. Here is an example data:
   
{
   "customer": {
   		"id": 1,
   		"name": "Praveen"
   },
   "monthlyTrans": {
		"MAY": [{
			"amount": 30.00,
   			"id": 5,
   			"purchaseDate": "2023-05-22T20:12:24.916198",
   			"rewardPoint": 0
		},{
			"amount": 300.00,
   			"id": 6,
   			"purchaseDate": "2023-05-19T20:12:24.918866",
   			"rewardPoint": 450.00
		}],
   		"JUNE": [{
   			"amount": 50.00,
   			"id": 3,
   			"purchaseDate": "2023-06-20T20:12:24.90622",
   			"rewardPoint": 0
   		},{
   			"amount": 10.00,
   			"id": 4,
   			"purchaseDate": "2023-06-22T20:12:24.914236",
   			"rewardPoint": 0
   		}],
   		"APRIL": [{
   			"amount": 40.00,
   			"id": 7,
   			"purchaseDate": "2023-04-24T20:12:24.920441",
   			"rewardPoint": 0
   		},{
   			"amount": 100.00,
   			"id": 8,
   			"purchaseDate": "2023-04-20T20:12:24.922433",
   			"rewardPoint": 50.00
   		},{
   			"amount": 1000.00,
   			"id": 9,
   			"purchaseDate": "2023-04-20T20:12:24.924429",
   			"rewardPoint": 1850.00
   		}]},
   "monthlyTotalRewardPoint": {
   		"MAY": 450.00,
   		"JUNE": 0,
   		"APRIL": 1900.00
   }
}