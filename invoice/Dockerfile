FROM openjdk:11.0

WORKDIR /app/invoice

VOLUME /tmp/invoice

COPY target/invoice.jar /app/invoice/invoice.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/invoice/invoice.jar"]