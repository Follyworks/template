# Release checklist

CI covers build, format, unit tests, GameTests, the GitHub Release and the changelog. This is the
part it can't.

## Before the tag

- [ ] `./gradlew runClient` and actually play with it for a few minutes. GameTests don't catch
      "the texture is missing" or "the GUI renders behind the hotbar".
- [ ] Check the dependency version ranges in `neoforge.mods.toml` still make sense. A range that was
      right two NeoForge releases ago will happily let someone install it into a crash.
- [ ] `mod_description` in `gradle.properties` matches what the mod does now.
- [ ] `mod_version` bumped, and it's real semver (breaking change means major, no exceptions,
      downstream mods depend on this being honest).
- [ ] Changelog reads like a person wrote it. The generated notes are a starting point.

## Tag

```
git tag v1.2.0
git push --tags
```

## After CI finishes

- [ ] Download the jar off the draft release and load it into a clean instance. Not the dev
      environment, a real launcher profile with nothing else installed.
- [ ] Publish the draft release.
- [ ] Modrinth and CurseForge (still manual until STUDIO-13 lands). Same jar, same version string,
      correct Minecraft and loader tags, changelog pasted in.
- [ ] Announce it wherever people are.

## If it's broken

Pull the files from Modrinth and CurseForge first, then fix it. A bad jar sitting on a distribution
site keeps getting downloaded the entire time you're fixing it.
