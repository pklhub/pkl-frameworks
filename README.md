# Pkl Frameworks

Pkl packages generated from Spring Boot, gRPC, and Sentry configuration metadata.

## Available packages

| Framework | Package |
| --- | --- |
| Spring Boot 4.2.0, 3.3.0, 2.7.0 | `spring-4.2.0`, `spring-3.3.0`, `spring-2.7.0` |
| Spring Boot 4.2.0 gRPC with Spring gRPC 1.1.2 | `spring-grpc-client-4.2.0`, `spring-grpc-server-4.2.0` |
| grpc-ecosystem 3.1.0 and 2.13.1 | `spring-grpc-client-<version>`, `spring-grpc-server-<version>`, `spring-grpc-client-server-<version>` |
| Sentry 8.66.0 for Spring Boot 4 and Sentry 6.28.0 | `sentry-8.66.0`, `sentry-6.28.0` |

## Use a package

Choose a tag from [GitHub Releases](https://github.com/pklhub/pkl-frameworks/releases). The framework version is part of the package name. The version after `@` is the Pkl Frameworks release version and matches the release tag without its leading `v`.

For example, for a release tagged `v0.3.0`, add these dependencies to `PklProject` and run `pkl project resolve`.

```pkl
amends "pkl:Project"

dependencies {
  ["spring"] {
    uri = "package://github.com/pklhub/pkl-frameworks/releases/download/v0.3.0/spring-4.2.0@0.3.0"
  }
  ["grpcClient"] {
    uri = "package://github.com/pklhub/pkl-frameworks/releases/download/v0.3.0/spring-grpc-client-4.2.0@0.3.0"
  }
  ["grpcServer"] {
    uri = "package://github.com/pklhub/pkl-frameworks/releases/download/v0.3.0/spring-grpc-server-4.2.0@0.3.0"
  }
  ["sentry"] {
    uri = "package://github.com/pklhub/pkl-frameworks/releases/download/v0.3.0/sentry-8.66.0@0.3.0"
  }
}
```

Import modules using the dependency aliases, for example `import "@spring/Server.pkl"`.

The Spring Boot generators include `Flyway.pkl` in new builds. Import it with `import "@spring/Flyway.pkl"` from a release that includes it.

For IntelliJ IDEA and VS Code, open the consumer workspace containing `PklProject` and the importing module. Run `pkl project resolve` from the directory containing `PklProject`, then run **Sync Projects** in IntelliJ IDEA or **Pkl: Sync projects** in VS Code. The importing file must be under the `PklProject` that declares the alias.

## Build and release

The generator resolves the renderer from the [pkl-k8s-app v0.25.0 GitHub release](https://github.com/pklhub/pkl-k8s-app/releases/tag/v0.25.0). That package declares the upstream `pkl-k8s` dependency.

Run `./gradlew build generatePkl` with Java 17 to generate packages locally. Push a version tag such as `v0.3.0` to publish the package metadata, ZIP archives, and checksums directly to the matching GitHub release.

Licensed under [Apache 2.0](LICENSE).
