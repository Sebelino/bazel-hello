FROM debian:stretch

RUN apt-get update -y &&\
    apt-get install -y \
        curl \
        python \
        git \
        openjdk-8-jre \
        make \
        zlib1g-dev \
        g++

RUN set -ex; \
    curl --fail --silent --show-error --location --output bazel "https://github.com/bazelbuild/bazel/releases/download/4.0.0/bazel-4.0.0-linux-x86_64" && \
    chmod u+x bazel && \
    mv bazel /bin/bazel

COPY . /app
