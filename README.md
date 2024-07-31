# Geospatial Search: Find Nearby Restaurants and Hotels by Zip Code on Google Maps 

<br>

## Overview

Users can easily locate nearby <strong>restaurants</strong> and <strong>hotels</strong> based on their <strong>zip code.</strong> 
Leveraging the capabilities of Google Maps, the application provides <mark> a seamless and interactive experience for finding places of interest in your vicinity.</mark> 
The backend of this project is built using <strong>Spring WebFlux for handling asynchronous and non-blocking operations</strong>, ensuring high performance and scalability.
Additionally, <strong>Redis is utilized for efficient data storage and retrieval</strong>, with <mark>Redisson providing reactive support to enhance the overall responsiveness and reliability of the application.</mark>
 
 
## Usages
- Spring WebFlux
- Redisson "Redis"
- Lombok
    


## Architecture of the Project

 ### 1-src folder
   - Configration
   - Controller
   - Model
   - Service
   - Util
     
 ### 2-resources folder
   - hotels.json
   - restaurants.json
   #### 2.1 static
   - locations-map.html
   
### 2-Maven pom.xml
<br> 
    
```
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>
		<dependency>
			<groupId>org.redisson</groupId>
			<artifactId>redisson-spring-boot-starter</artifactId>
			<version>3.16.6</version>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
 ```

<br>

###### Output :star_struck:
##### :pencil2: `Search for resturents` 

<img width="848" alt="resturents" src="https://github.com/user-attachments/assets/350603f4-17ad-4e57-8663-9775652112ef">

##### :pencil2: `Search for hotels` 

<img width="874" alt="hotels" src="https://github.com/user-attachments/assets/89b55829-de83-4b7f-84dc-c14451330eb7">


---


### Good Luck <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="30px"> 




