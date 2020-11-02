# Bazel project example

To look at the dependency graph (you need Graphviz installed):
```
$ bazel query --noimplicit_deps 'deps(//...)' --output graph > hello.dot && dot -Tpng hello.dot > hello.png
$
$ # Open it in your favorite image viewer:
$ feh hello.png
```
