FROM openjdk
COPY . var/www/java
WORKDIR var/www/java
RUN javac ExamenFinalApp.java
CMD ["java", "ExamenFinalApp"]