#!/bin/bash
nohup java -classpath "..:../lib/*" m2app > stdout.log &
echo $! > ./iap.pid