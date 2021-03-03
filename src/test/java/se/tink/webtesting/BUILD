load("@io_bazel_rules_webtesting//web:java.bzl", "java_web_test_suite")

java_web_test_suite(
    name = "webtesting",
    srcs = glob(["*.java"]),
    browsers = [
        "@io_bazel_rules_webtesting//browsers:chromium-local",
    ],
    local = True,
    test_class = "se.tink.webtesting.BrowserTest",
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_seleniumhq_selenium_selenium_api",
        "@maven//:org_seleniumhq_selenium_selenium_remote_driver",
    ],
)
