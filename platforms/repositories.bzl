load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

def nix_repositories():
    http_archive(
        name = "bazel_skylib",
        sha256 = "97e70364e9249702246c0e9444bccdc4b847bed1eb03c5a3ece4f83dfe6abc44",
        urls = [
            "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.0.2/bazel-skylib-1.0.2.tar.gz",
            "https://github.com/bazelbuild/bazel-skylib/releases/download/1.0.2/bazel-skylib-1.0.2.tar.gz",
        ],
    )

    RULES_NIXPKGS_COMMIT = "6178f2aae7a90370f2132abafa977701afc6fb4e"

    http_archive(
        name = "io_tweag_rules_nixpkgs",
        sha256 = "e721c383b3d5ca51ad123001d3fb26602aa330ddd9cf2a55d25ddd956c98030a",
        strip_prefix = "rules_nixpkgs-{}".format(RULES_NIXPKGS_COMMIT),
        urls = ["https://github.com/tweag/rules_nixpkgs/archive/{}.tar.gz".format(RULES_NIXPKGS_COMMIT)],
    )
