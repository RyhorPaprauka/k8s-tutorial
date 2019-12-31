kubectl apply -f k8s
kubectl set image deployments/visit-deployment visit=grinman/multi-visit:$SHA