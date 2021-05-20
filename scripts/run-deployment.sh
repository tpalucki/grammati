#!/bin/bash

export DEPLOYMENT_DIR=deployment/
export APP_VERSION=0.0.3

cd ${DEPLOYMENT_DIR}

docker load --input io.github.tpalucki_gramilka-backend_${APP_VERSION}.tar
docker load --input io.github.tpalucki_gramilka-frontend_${APP_VERSION}.tar
