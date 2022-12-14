docker build -t dearme_server .

DOCKER_APP_NAME=dearme_server

EXIST_BLUE=$(docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml ps | grep Up)

if [ -z "$EXIST_BLUE" ]; then
	echo "BLUE UP"
	docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml up -d
	sleep 20
	START_PORT=9090
	TERMINATE_PORT=9091
	docker exec webserver sed -i "s/${TERMINATE_PORT}/${START_PORT}/" /etc/nginx/conf.d/default.conf
	echo "nginx reload..."
  docker exec webserver service nginx reload
	sleep 5
	docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.green.yml down
else
	echo "GREEN UP"
	docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.green.yml up -d
	sleep 20
	START_PORT=9091
	TERMINATE_PORT=9090
	docker exec webserver sed -i "s/${TERMINATE_PORT}/${START_PORT}/" /etc/nginx/conf.d/default.conf
	echo "nginx reload..."
	docker exec webserver service nginx reload
	sleep 5
	docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml down
fi