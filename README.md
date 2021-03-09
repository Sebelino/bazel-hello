# Bazel project example

## Run the program
```
$ bazel run //src/main/java/com/sebelino/hello
```

## Test the program
```
$ bazel test //src/test/java/com/sebelino/hello
```

## Run the program in Docker
Upload the image to your local Docker registry:
```
$ bazel run //src/main/java/com/sebelino/hello:docker
$ docker run bazel/src/main/java/com/sebelino/hello:docker
```

## Profiling of build time
Using `analyze-profile`:

```
$ bazel build --profile=hello.json //src/main/java/com/sebelino/hello
$ bazel analyze-profile hello.json

=== PHASE SUMMARY INFORMATION ===

Total launch phase time         0.036 s    0.89%
Total init phase time           0.022 s    0.57%
Total loading phase time        0.270 s    6.68%
Total analysis phase time       0.594 s   14.68%
Total preparation phase time    0.001 s    0.04%
Total execution phase time      3.119 s   77.09%
Total finish phase time         0.002 s    0.06%
------------------------------------------------
Total run time                  4.047 s  100.00%
```

For more details, open up Chrome and put `chrome://tracing` in the address bar. Then load `hello.json`.

## Visualizing the dependency graph
You need Graphviz installed (for `dot`):

```
$ bazel query --noimplicit_deps 'deps(//...)' --output graph > hello.dot
$ dot -Tpng hello.dot > hello.png
$
$ # Open it in your favorite image viewer:
$ feh hello.png
```

You can also install Gephi and load `hello.dot` to look at the dependency graph.

## Building with Bazel inside a Docker container
```
$ docker build . -f docker/Dockerfile -t bazel-hello-example

$ docker-compose -f docker/docker-compose.yml run --rm app /bin/sh -c "$(cat ./docker/build-all.sh)"
```

## BuildBuddy

In the repository root directory, create a file `build-buddy.bazelrc` with the following content:
```
build --remote_header=x-buildbuddy-api-key=xxxxxxxxxxxxxxxxxxxx
```
where `xxxxxxxxxxxxxxxxxxxx` is your BuildBuddy API key.

Run with remote caching:
```
bazel build --config=rc //...
```

Run with remote caching + remote build execution:
```
bazel build --config=rcbe //...
```
