FROM openjdk:17

COPY target/CinemaHillel-1.0.1.jar app/CinemaHillel-1.0.1.jar

CMD ["java", "-jar", "app/CinemaHillel-1.0.1.jar"]
