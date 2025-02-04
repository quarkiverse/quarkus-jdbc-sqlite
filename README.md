# Quarkus SQLite4j extension

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-1-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->
[![Build](https://github.com/quarkiverse/quarkus-sqlite4j/workflows/Build/badge.svg)](https://github.com/quarkiverse/quarkus-sqlite4j/actions?query=workflow%3ABuild)
[![Maven Central](https://img.shields.io/maven-central/v/io.quarkiverse.jdbc/quarkus-sqlite4j.svg?label=Maven%20Central&style=flat-square)](https://search.maven.org/artifact/io.quarkiverse.jdbc/quarkus-sqlite4j)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)

Quarkus SQLite4j is a Quarkus extension for the SQLite Embedded database.

This project has been forked from the original [quarkus-jdbc-sqlite](https://github.com/quarkiverse/quarkus-jdbc-sqlite).
The key difference is in how SQLite is bundled/executed:

- `quarkus-jdbc-sqlite` builds on top of the stable [xerial/sqlite-jdbc](https://github.com/xerial/sqlite-jdbc/) driver that bundle several builds of SQLite for a lot of different architectures and uses JNI to access the functionality
- `quarkus-sqlite4j` builds on top of the fork [roastedroot/sqlite4j](https://github.com/roastedroot/sqlite4j) which instead compiles SQLite to pure Java bytecode thanks to [Chicory](https://github.com/dylibso/chicory) and directly interacts with it

## User Documentation

https://docs.quarkiverse.io/quarkus-sqlite4j/dev/index.html
