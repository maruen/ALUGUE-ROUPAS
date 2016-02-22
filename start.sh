#!/bin/bash

if [  "$1" == "devel"  ]; then
	echo "[info] Starting server in development mode"
	JAVA_OPTS="-Dhttps.port=9443
	           -Dhttp.port=9000"  activator -jvm-debug 9999 run
else
	echo "[info] Starting server in production mode"
	JAVA_OPTS="-Dhttps.port=443
		        -Dhttp.port=80" activator start
fi
