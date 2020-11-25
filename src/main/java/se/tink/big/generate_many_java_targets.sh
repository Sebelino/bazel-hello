#!/usr/bin/env bash

set -euo pipefail

for i in {2..1000}; do
    rm -rf "pkg$i"
    cp -r pkg1 "pkg$i"
    sed -i "s/pkg1/pkg$i/" "pkg$i/HelloWorld.java"
    sed -i "s/pkg1/pkg$i/" "pkg$i/BUILD"
done
