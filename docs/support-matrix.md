# Support matrix

What gets a release, what gets a backport, what doesn't.

| Minecraft | NeoForge | Java | Status |
|---|---|---|---|
| 1.21.1 | 21.1.228 | 21 | Primary. All new work lands here. |
| anything older | | | Not supported. No backports. |

## Rules

- **One primary version at a time.** Every mod targets the same one, so a NeoForge bump is a single
  coordinated change across the studio and not a per-repo archaeology session.
- **`main` tracks the primary version.** When the studio moves to a new Minecraft version, the old
  one gets a `mc/1.21.1` branch and stops receiving anything but crash fixes.
- **Bug fixes go to the primary version only**, unless the bug eats save data, in which case the
  most recent frozen branch gets a patch release too.
- Version numbers live in `gradle.properties` (`minecraft_version`, `neo_version`). Nothing hardcodes
  them anywhere else.

## Moving to a new Minecraft version

1. Branch the current one as `mc/<version>` and push it.
2. On `main`, bump `minecraft_version`, `minecraft_version_range` and `neo_version`.
3. `./gradlew runData` and commit whatever moved. This is where most of the breakage shows up.
4. `./gradlew runGameTestServer`.
5. Update the table above.
