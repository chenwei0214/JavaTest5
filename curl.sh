#!/bin/bash
#user add
curl -X PUT \
  http://localhost:8080/user/add \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
"firstName":"zhangsan",
"lastName":"lisi",
"email":"2839298@qq.com",
"address":"47 MySakila Drive"
}'

#user update
curl -X POST \
  http://localhost:8080/user/update \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
"id":1,
"firstName":"zhangsan",
"lastName":"hhhhhhh",
"email":"2839298@qq.com",
"address":"47 MySakila Drive"
}'


#user del
curl -X DELETE \
  http://localhost:8080/user/delete \
  -H 'Cache-Control: no-cache' \
  -H 'Cookie: id=1'

# user login
curl -X POST \
  http://localhost:8080/user/login \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -H 'Postman-Token: cce2c584-b5a7-4d0b-9196-135a4ba02ca7' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F name=MARY \
  -F password=SMITH





#film page
curl -X GET \
  'http://localhost:8080?pageSize=10&page=1' \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: 77ad5835-89e3-41df-ba68-36df38b3942e'


#film add
curl -X PUT \
  http://localhost:8080/add \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"title":"test title",
	"description":"test description"
}'
