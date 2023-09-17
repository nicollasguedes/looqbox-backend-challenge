FROM openjdk:11
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/looqbox-backend-challenge-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 5000:5000
CMD ["java","-jar","app.jar"]