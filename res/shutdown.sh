#!/usr/bin/env bash

export LC_ALL=en_US.UTF-8

APP_HOME=$(cd "$(dirname "$0")/..";pwd)
RESULT=$(ps axw | grep "${APP_HOME}/" | grep java | grep -v grep | wc -l)
if [ ${RESULT} -ge 1 ];then
    echo -ne "${APP_HOME} will be killed\n"
    ps axw | grep "${APP_HOME}/" | grep java | grep -v grep | awk '{print("echo killing process:"$1"&kill "$1)}' | sh
else
    echo "${APP_HOME} not exists !!!"
fi
#睡3秒
sleep 3
RESULT=$(ps axw |grep "${APP_HOME}/" | grep java | grep -v grep | wc -l)
if [ ${RESULT} -ge 1 ];then
    echo -ne "${APP_HOME} process count:${RESULT}\n"
    echo -ne "${APP_HOME} will be killed force\n"
    ps axw | grep "${APP_HOME}/" | grep java | grep -v grep | awk '{print("echo killing process:"$1" force&kill -9 "$1)}' | sh
else
    echo "shutdownServer success"
fi
#检查PID
PID_FILE="${APP_HOME}/logs/application.pid"
if [ -f ${PID_FILE} ];then
    echo "remove ${PID_FILE}"
    rm -f ${PID_FILE}
fi
