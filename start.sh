#!/bin/bash

if [  "$1" == "devel"  ]; then
	echo "[info] Starting server in development mode"
	JAVA_OPTS="-Dhttps.port=9443
	           -Dhttp.port=9000
				  -Dlogger.file=conf/dev-logger.xml"  activator -jvm-debug 9999 run
else
	echo "[info] Starting server in production mode"
	JAVA_OPTS="-Dhttps.port=443
		        -Dhttp.port=80
				  -Dlogger.file=conf/prod-logger.xml" activator start
fi
