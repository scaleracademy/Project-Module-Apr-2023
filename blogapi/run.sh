#!/usr/bin/env sh

# Build the project

./gradlew bootJar

# Run via docker compose

docker-compose up --build --force-recreate -d
