# Use official Tomcat image
FROM tomcat:9.0-jdk17-temurin

# Remove the default Tomcat homepage
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR file into Tomcat’s webapps folder
COPY target/Doctor-Patient-Portal.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
