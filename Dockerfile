FROM bellsoft/liberica-runtime-container:jdk-17-slim-musl AS build

# Set the working directory in Docker
WORKDIR /app

# Copy all files into the container
COPY . .

# build jar files
RUN ./gradlew assemble --no-daemon


# Start a new stage to create the final image
FROM bellsoft/liberica-runtime-container:jre-17-musl

# Set the working directory in Docker for the new stage
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/build/libs/app.jar /app/app.jar

# Expose the required port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
