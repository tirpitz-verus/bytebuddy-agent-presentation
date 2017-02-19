#!/usr/bin/env bash

./gradlew clean test assemble && java -javaagent:agent/build/libs/agent-1.0-SNAPSHOT.jar=debug -jar application/build/libs/application-1.0-SNAPSHOT.jar