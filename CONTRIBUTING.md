# Contributing

Short version: `./gradlew build` has to be green, JSON comes out of `runData`, and the formatter
wins every argument.

## Setup

JDK 21 (Temurin is what CI uses), clone, `./gradlew build`. First run downloads NeoForge and
decompiles Minecraft, budget 5 to 10 minutes and a couple of GB. After that it's fast.

`./gradlew runClient` gives you a dev client with the mod loaded. `-PquickPlayWorld="New World"`
skips the menus.

## Formatting

Spotless runs palantir-java-format at 120 columns. `./gradlew spotlessApply` before you commit,
`build` fails if you don't. There is no style discussion to have, the tool has already had it.

Every Java file starts with `/* SPDX-License-Identifier: MIT */`. Spotless adds it if you forget.

## JSON

Nothing under `src/main/resources/data/` or `src/main/resources/assets/` is written by hand
(textures excepted). Recipes, models, tags, lang: add them to the provider in
`datagen/`, run `./gradlew runData`, commit what lands in `src/generated/resources`. If you
find yourself editing a `.json` directly, stop, that file will be overwritten on the next
`runData` and your change will vanish.

## Tests

`./gradlew runGameTestServer` runs the GameTests in a headless server. CI runs it on every PR.
A change that touches registration, world interaction or anything that can crash on load should
come with a GameTest. Pure logic can use JUnit under `src/test/java`.

## Commits

Subject line: sentence case, starts with a verb, names the specific thing, no prefix, no
trailing period.

```
Add the Folly mod template
Fix creative tab icon after item rename
Drop the unused ExampleItem texture
```

Not `feat: ...`, not `fix(datagen): ...`. The body is optional, use it when the why isn't
obvious from the diff, and put numbers in it if you have them.

One change per commit where it's practical. A PR with six commits titled "wip" gets squashed.

## Pull requests

Fill in the template. The checklist is short on purpose, every box on it is something CI
can't check for you (did you actually load it in a client, did any of the JSON come from your
editor instead of `runData`).

Open a discussion first for anything bigger than a bug fix. Not because permission is needed,
because it saves you building something that doesn't fit.

## Licence

MIT. Anything you contribute is MIT too, and by opening a PR you're agreeing to that.
