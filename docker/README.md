```
docker build . -f docker/Dockerfile -t bazel-hello-example

docker-compose -f ./docker/docker-compose.yml run --rm app /bin/sh -c "$(cat ./docker/build-all.sh)"
```
