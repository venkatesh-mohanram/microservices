#!/bin/bash
cd add-service
sudo docker build --tag=add-service .
cd ..
cd sub-service
sudo docker build --tag=sub-service .
cd ..
cd calculator-service
sudo docker build --tag=calculator-service .
cd ..
sudo docker-compose up calculatorservice
