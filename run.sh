#!/usr/bin/env bash

./gradlew clean build docker -x test

docker-compose stop
docker-compose rm -f

docker-compose up