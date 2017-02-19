#!/usr/bin/env bash

./gradlew application:clean application:assemble && java -jar application/build/libs/application-1.0-SNAPSHOT.jar