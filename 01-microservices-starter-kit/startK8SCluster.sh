#!/bin/bash
kubectl apply -f add-service/k8s-deployment.yaml -f add-service/k8s-service.yaml -f sub-service/k8s-deployment.yaml -f sub-service/k8s-service.yaml -f calculator-service/k8s-deployment.yaml -f calculator-service/k8s-service.yaml
