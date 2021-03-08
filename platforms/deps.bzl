load("@io_tweag_rules_nixpkgs//nixpkgs:nixpkgs.bzl", "nixpkgs_git_repository", "nixpkgs_python_configure")

def nix_deps():
    nixpkgs_git_repository(
        name = "nixpkgs_repository",
        revision = "037936b7a307c7399cf0f3d9fabe37ea5b0b8534",
        sha256 = "a6178b795602924f94b081b459fcb868cebc7d3d7d0c6e90306aba850beec629",
    )

    nixpkgs_python_configure(
        repository = "@nixpkgs_repository",
    )
