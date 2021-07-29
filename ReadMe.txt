https://www.tutorialspoint.com/spring_boot/spring_boot_zuul_proxy_server_and_routing.htm

@Value("${spring.application.name}") - to read property in code
mvn clean package - to generate jar file
java -jar target/spring-boot-tutorial-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
	to set active profile at run time

Logging
	logging.level.root = INFO - to set log level in properties file
	It use Apache Commons logging for internal logging
	supports  Common Logging, Util Logging, Log4J, and SLF4J.

Interceptors & filters:
	https://developpaper.com/analysis-of-spring-boot-interceptor-and-filter-instance/#:~:text=The%20main%20differences%20between%20the%20two%20are%20as,and%20can%20be%20used%20under%20any%20circumstances.%202.
	https://medium.com/techno101/introduction-to-servlet-filter-and-handler-interceptor-ba1167b1f52c
	https://medium.com/techno101/servlet-filter-and-handler-interceptor-spring-boot-implementation-b58d397d9dbd

server.port
	if set to 0, tomcat pick random port number

Rest Template 
	Used to create applications that consume RESTful Web Services. You can use the exchange() method to consume 
	the web services for all HTTP methods.

Internationalization: 
	Internationalization is a process that makes your application adaptable to different languages and regions without 
	engineering changes on the source code. In other words, Internationalization is a readiness of Localization.
	- add the LocaleResolver bean in our Spring Boot application
	- Define LocaleChangeInterceptor that is a used to change the new Locale based on the value of the language parameter added to a request.
	- register LocaleChangeInterceptor to application’s registry interceptor.
	
	- added spring-boot-starter-thymeleaf dependency to render html file
	- messages.properties and messages-fr.properties(french language), locale.html
	-change in ServiceInterceptorConfig and ViewControlle
	
Scheduling
	@EnableScheduling - enable the scheduler for your application - add at SPring Boot Application class
	@Scheduled annotation is used to trigger the scheduler for a specific time period
		@Scheduled(cron = "0 * 9 * * ?") - every minute starting at 9:00 AM and ending at 9:59 AM, 
		public void cronJobSch() throws Exception {
		}
	@Scheduled(fixedRate = 1000) - Fixed Rate scheduler is used to execute the tasks at the specific time. 
		It does not wait for the completion of previous task.
	@Scheduled(fixedDelay = 1000, initialDelay = 1000) - execute the tasks at a specific time. 
		It should wait for the previous task completion
		
HTTPS:
	Generate self signed certificate keystore.p12 using below command:
	keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
	
	Add server port(443) and keystore details in application.properties file

Zull Server- Proxy server onwards from tutorialpoints site
	Zuul Server is a gateway application that handles all the requests and does the dynamic routing of microservice applications	
Spring CLound Configuration Server 
	centralized application that manages all the application related configuration properties.
	Spring Cloud Configuration Server lets developers to load the new configuration properties 
	without restarting the application and without any downtime.
Spring CLound Configuration Client 

Spring Boot Actuator
	provides secured endpoints for monitoring and managing your Spring Boot application. By default, all actuator endpoints are secured.
	
Spring Boot Admin Server:
	Monitoring your application by using Spring Boot Actuator Endpoint is slightly difficult. Because, if you have ‘n’ number of applications, 
	every application has separate actuator endpoints, thus making monitoring difficult. Spring Boot Admin Server is an application used to 
	manage and monitor your Microservice application.

Spring Boot Admin Client