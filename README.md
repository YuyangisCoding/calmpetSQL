# Database and Tomcat server (a spring-boot project for calmpet-final)
We are using AWS EC2 to host Tomcat server. This server is meant to support 
login and register functions. That means you can log in and register anywhere in the 
world for our calmpet flutter app. You can skip below and just use app without any hassles;)

If you want to, however, build this server yourself, you can do it quite easily.


0. assuming you have brew or apt-get package manager.
1. install mysql-server on machine that you want to use as a server.
Create a database called calmpet under root user with password 12345678. Then run calmpet.sql that we 
provide to you, which will build tables automatically. 
2. install maven
3. Before proceeding to the next step, we need to make sure ip addresses specified in the 
frontend flutter project **_match_** tomcat server ip. That is 127.0.0.1:8010 if you 
purely run in localhost. Localhost will work for simulator test, but not real iPhone devices.
To check ip addresses, go to login.dart(line 152) and register.dart(line 186), which are
located in flutter_project/lib/pages/user. Then go and check spring-boot project
calmpetSQL/src/main/resources/application.yml
4. in the springboot project directory,
run _mvn spring-boot:run_ 
5. Now you have server up and running! 
