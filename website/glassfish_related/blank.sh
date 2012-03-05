#!/bin/bash
THRESHOLD=$1 ; shift

for (( ; ; )) ; do
    rm index.jsp
    wget http://www.iweishi.net/website/index.jsp
    SIZE=`ls -l index.jsp | awk -F " "  '{print $5}'`
    if [ $SIZE -lt $THRESHOLD ]; then
        exit 9
    fi
done
