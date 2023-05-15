
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM  amazoncorretto:17.0.3-alpine
COPY  target/SpringBoot-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar","/app.jar"]

