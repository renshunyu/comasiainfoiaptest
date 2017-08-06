#!/bin/bash
PID=$(cat ./iap.pid)
echo $PID
kill -9 $PID