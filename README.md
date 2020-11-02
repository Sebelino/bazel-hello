# Bazel project example

## Run the program
```
$ bazel run //src/main/java/se/tink/hello
```

## Test the program
```
$ bazel test //src/test/java/se/tink/hello
```

## Run the program in Docker
Upload the image to your local Docker registry:
```
$ bazel run //src/main/java/se/tink/hello:docker
$ docker run bazel/src/main/java/se/tink/hello:docker
```

## Profiling of build time
Using `analyze-profile`:

```
$ bazel build --profile=hello.json //src/main/java/se/tink/hello
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

