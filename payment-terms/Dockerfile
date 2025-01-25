FROM openjdk:11.0

WORKDIR /app/payment-terms

VOLUME /tmp/payment-terms

COPY target/payment-terms.jar /app/payment-terms/payment-terms.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/payment-terms/payment-terms.jar"]