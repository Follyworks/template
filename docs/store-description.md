# Store description template

One description, pasted into Modrinth and CurseForge. Markdown on both. Replace every
`[bracket]`, delete any section that doesn't apply, and read it out loud once before
publishing.

**Modrinth requires an AI-assistance disclosure** if any part of the description, code or
art had AI involved, and it bans AI-generated images for the icon, banner and gallery
outright. Tick the box, don't generate the art.

---

# [Mod name]

[One line, number first if there is one. "48 archetypes, ~1,200 buffs, no two alike."
"Adds 14 trees and the wood types to go with them." The thing it does, not the feeling
it gives you.]

[Two or three sentences on how it plays. Third person for the mod. What changes for the
player from the first ten minutes.]

## What's in it

**[Feature]**, [verdict first, then how it works, then a number. "Plant your shield as
standing cover, it blocks projectiles for 4 seconds and then breaks."]

**[Feature]**, [same shape.]

**[Feature]**, [same shape. Three to five of these. If there are more than five, the mod
needs a wiki, not a longer description.]

## Requires

- NeoForge [neo_version] or newer on Minecraft [minecraft_version]
- [Library mod, with a link] ([why, in a parenthetical: "for the animations, like
  everything else I make"])

[If it's client-only or server-only, say so here in one line. People install the wrong
side constantly.]

## Works with

[Optional. Compat mods, what the compat actually does. Skip the section entirely if there
isn't any, "should work with most things" is not information.]

## FAQ

**Q: Will you backport to [older version]?**
A: No. One version at a time, this is a hobby, a backport is weeks of work.
[Link to the support matrix on GitHub.]

**Q: Forge / Fabric?**
A: [Honest answer. "No, NeoForge only." or "Fabric maybe, Forge no." Don't say "planned"
unless there is a date.]

**Q: Can I use this in my modpack?**
A: Yes. MIT. A link back is nice, not required.

**Q: [The question you're going to get asked twenty times]**
A: [The answer, once, here.]

## Bugs and questions

Issues go on [GitHub link]. Use the template, it asks for the log for a reason. If you
have any questions, concerns or needs, the Discussions tab is where I'll actually see them.

__[One line for the thing you most want people to know. The hidden mechanic, the config
option that changes everything, the mod it was built to sit next to.]__

---

## After pasting

- [ ] Icon is 512x512, banner is 1280x720 minimum, neither is AI-generated
- [ ] Version string on the store matches `mod_version` in gradle.properties
- [ ] Loader is NeoForge, game version is exact, not a range you didn't test
- [ ] Source link points at the repo, issues link points at the issues tab
- [ ] Modrinth AI-assisted disclosure ticked
