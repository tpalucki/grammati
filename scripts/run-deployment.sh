#!/bin/bash

export DEPLOYMENT_DIR=tmp/

cd ${DEPLOYMENT_DIR}

docker load --input io.github.tpalucki_gramilka-backend_0.0.3.tar
docker load --input io.github.tpalucki_gramilka-frontend_0.0.3.tar
