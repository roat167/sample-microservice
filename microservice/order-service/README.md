# Order service

## Technologies
- MySQL 5.6+
- Spring Boot, Spring Data
- JUnit, Mockito
- Maven

## Dependency

- This project include catalog-service. If you haven't run mvn clean install from parent directory, you need to build catalog-service manually.

## Build
- Make sure MySQL server started
- From the root of project directory (you will find pom.xml file there) run the following command
	
		mvn clean install

		java -jar target/order-service-0.0.1-SNAPSHOT.jar
	
- You also use the following command		

		mvn spring-boot:run

