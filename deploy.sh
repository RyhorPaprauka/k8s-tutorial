docker build -t grinman/multi-visit:latest -t grinman/multi-visit:$SHA -f . .
echo  "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USER" --password-stdin
docker push grinman/multi-visit:latest
docker push grinman/multi-visit:$SHA

kubectl apply -f k8s
kubectl set image deployments/visit-deployment visit=grinman/multi-visit:$SHA