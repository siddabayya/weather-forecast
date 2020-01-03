# weather-forecast
Show weather dashboard

This document provides step by step explanations on Code and Execution process.

Technologies used
•	Java 8
•	Spring Boot
•	Spring Data
•	MongoDB
•	Dark Sky API
•	Maven
•	Chartist.js

Using IDE (Eclipse)

git clone https://github.com/spring-guides/gs-spring-boot.git

1.	Exctract and Import src as maven project in Eclipse IDE. 

2. Project Dependency

        <properties>
          <java.version>1.8</java.version>
        </properties>

        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
          </dependency>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
          </dependency>

        </dependencies>

3. MongoDB Configuration

      #src/java/resources/application.properties
      #mongodb
      spring.data.mongodb.uri=mongodb+srv://weather-forecast:7LEyCPUynow6iRPe@cluster0-wne1h.mongodb.net/smart-weather

4. DarkSky API Configuration

      ## Darksky Weather Forecast API ##

      darksky.api.url=https://api.darksky.net/
      darksky.api.key=0caa25783b06e8eff608cabc39ec5cbc

5. Run


      @SpringBootApplication
      @Import(ApplicationConfig.class)
      public class WeatherForecastApplication {

        public static void main(String[] args) {
          SpringApplication.run(WeatherForecastApplication.class, args);
        }

      }
5.1 If running behind firewall. Set proxy details

      Add this before you connect to a URL behind a proxy.

      System.getProperties().put("http.proxyHost", "someProxyURL");
      System.getProperties().put("http.proxyPort", "someProxyPort");
      System.getProperties().put("http.proxyUser", "someUserName");
      System.getProperties().put("http.proxyPassword", "somePassword");

5.2 Spring Boot application.


http://localhost:8080/weather/37.8267/-120.4233
