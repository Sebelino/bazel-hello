load("@io_bazel_rules_docker//container:container.bzl", "container_image")
load("@io_bazel_rules_docker//java:image.bzl", "java_image")
load("@rules_pkg//:pkg.bzl", "pkg_tar")

java_binary(
    name = "hello",
    srcs = glob(["*.java"]),
    main_class = "se.tink.hello.HelloWorld",
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "@maven//:com_amazonaws_aws_java_sdk_sqs",
    ],
)

pkg_tar(
    name = "hello_tar",
    srcs = [":hello_deploy.jar"],
    mode = "0444",
)

container_image(
    name = "docker",
    base = "@java_base//image",
    cmd = [
        "hello_deploy.jar",
    ],
    tars = [
        ":hello_tar",
    ],
)
