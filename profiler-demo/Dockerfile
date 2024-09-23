# Step 1: Use the provided base image
FROM artifactory.tfs.toyota.com/middleware-docker-prod-local/openjdk:21.0.4-alpine3.18


# Step 3: Set the working directory inside the container
WORKDIR /app

# Step 4: Switch to root user to install/upgrade dependencies
USER root

# Step 5: Upgrade system packages and install any necessary dependencies (example: bash)
RUN apk update && apk upgrade && apk add --no-cache bash

# Step 6: Copy the JAR file from the local repository (replace with actual path)
COPY target/profiler-demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Step 7: Create a non-root user and set appropriate permissions
RUN addgroup -S appgroup && adduser -S appuser -G appgroup \
    && chown -R appuser:appgroup /app

# Step 8: Switch to the non-root user
USER appuser

# Step 9: Expose the port that the application will run on
EXPOSE 9090

# Step 10: Define the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
