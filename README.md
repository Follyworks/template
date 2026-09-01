# Folly Template

The starting point for every mod under `io.github.dizzymii.folly`. NeoForge 1.21.1, Java 21, Gradle 8.14.

It exists so that starting a new mod is a rename and a push. The build file gets reassembled from
memory exactly once.

## Starting a new mod

Hit "Use this template" on GitHub, clone it, then:

1. `gradle.properties`, set `mod_id`, `mod_name`, `mod_description`, `mod_version`. Leave
   `mod_group_id` and `mod_license` alone.
2. Rename the package leaf `src/main/java/io/github/dizzymii/folly/template/` to your mod id, and
   `TemplateMod.java` along with it. `MODID` in that class MUST match `mod_id` in gradle.properties,
   the build fails at resource processing if it doesn't (which is the point).
3. Rename `src/main/resources/data/template/` to the same id.
4. `rootProject.name` in `settings.gradle`.
5. Delete `EXAMPLE_ITEM` once there's real content. `SmokeTest` references it, so point that at
   something real too.

Then `./gradlew build` and you should get a jar.

## Commands

| | |
|---|---|
| `./gradlew build` | compile, format check, unit tests, jar |
| `./gradlew runClient` | dev client (`-PquickPlayWorld="New World"` skips the menus) |
| `./gradlew runServer` | dev server |
| `./gradlew runData` | regenerate JSON into `src/generated/resources` |
| `./gradlew runGameTestServer` | GameTests, same as CI runs |
| `./gradlew spotlessApply` | fix formatting |

## No hand-written JSON

Recipes, models, tags and lang all come out of `runData`. `src/generated/resources` is a source root
and is committed, so diffs are reviewable, but nothing in there is edited by hand. A Minecraft
version that changes a JSON shape then shows up as a compile error in the provider instead of a
mystery at runtime six months later.

## Versions

`mod_version` is plain semver. `build.gradle` appends the Minecraft version as build metadata, so
`mod_version=1.2.0` on 1.21.1 ships as `1.2.0+1.21.1`. One line to bump.

Which Minecraft versions get releases is in [docs/support-matrix.md](docs/support-matrix.md).

## Releasing

Bump `mod_version`, commit, then:

```
git tag v1.2.0
git push --tags
```

CI builds it, drafts a GitHub Release with generated notes, and attaches the jar. The tag has to
match `mod_version` or the workflow fails on purpose. The manual half is
[docs/release-checklist.md](docs/release-checklist.md).

## Licence

MIT. See [LICENSE](LICENSE).
