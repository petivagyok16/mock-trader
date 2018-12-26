FROM java:8
WORKDIR './app'
COPY ./target/mock-trader-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mock-trader-0.0.1-SNAPSHOT.jar"]