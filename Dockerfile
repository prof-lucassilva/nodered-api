# Use uma imagem base do Maven com JDK 17
FROM maven:3.8.4-openjdk-17-slim AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o pom.xml primeiro para baixar dependências em cache
COPY pom.xml .

# Baixa as dependências
RUN mvn dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Imagem final com JDK slim
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]