#!/usr/bin/env bash

./gradlew clean assemble && java -javaagent:agent/build/libs/agent-1.0-SNAPSHOT.jar -jar application/build/libs/application-1.0-SNAPSHOT.jar