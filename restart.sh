#!/usr/bin/env bash

export LC_ALL=en_US.UTF-8

DIR=`dirname "$0"`
echo "shutdown..."
${DIR}/shutdown.sh
echo "startup..."
${DIR}/startup.sh

