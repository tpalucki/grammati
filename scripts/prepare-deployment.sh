#!/bin/bash

pushd ./

export APP_VERSION=0.0.3

if [[ ! -d ./tmp ]]
then
	echo "./tmp not exists on your filesystem."
	mkdir ./tmp
	echo "Created ./tmp"
fi

cd ./tmp

echo "Saving io.github.tpalucki/gramilka-backend:${APP_VERSION}"
docker save --output io.github.tpalucki_gramilka-backend_${APP_VERSION}.tar io.github.tpalucki/gramilka-backend:${APP_VERSION}

echo "Saving io.github.tpalucki/gramilka-frontend:${APP_VERSION}"
docker save --output io.github.tpalucki_gramilka-frontend_${APP_VERSION}.tar io.github.tpalucki/gramilka-frontend:${APP_VERSION}

echo "Copying docker-compose.yml"
cp ../src/main/docker/docker-compose.yml .

echo "Copying run-deployment.sh"
cp ../scripts/run-deployment.sh .

sftp -P 8696 tom@gramilka.pl < ../scripts/deploy.sftp

popd
