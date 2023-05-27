# sử dụng image maven:3.6.3-jdk-11 để build ứng dụng spring boot và
# đặt tên stage đó là build
FROM maven:3.6.3-jdk-11 AS build
# copy tất cả các file trong ứng dụng spring boot vào trong thưc mục
# /app của container
COPY . /app
# Đặt thư mục là /app
WORKDIR /app
# build ứng dụng
RUN mvn clean package
# Sử dụng image openjdk:11-jdk-slim để chạy ứng dụng spring boot
FROM openjdk:11-jdk-slim
# Copy tệp JAR đã build đường dẫn mới
COPY --from=build /app/target/demo-api-0.0.1-SNAPSHOT.jar /demo-api.jar

EXPOSE 8080

WORKDIR /
# Chạy ứng dụng
CMD ["java", "-jar", "demo-api.jar"]
