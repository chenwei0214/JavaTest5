#!bin/bash
while ! nc -z ${MYSQL_IP} ${MYSQL_PORT}; do sleep 3; done
echo "========================"
echo "${MYSQL_IP}:${MYSQL_PORT}"
echo "========================"
java -jar ./Exam1.jar