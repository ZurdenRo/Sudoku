FROM openjdk:14
RUN mkdir -p /home/app
COPY target/Sudoku-1.0-SNAPSHOT.jar /home/app
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "home/app/Sudoku-1.0-SNAPSHOT.jar"]
