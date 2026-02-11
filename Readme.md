# Vital Signals

[ English | [简体中文](./Readme-zh.md) ]

A library that provides detailed player status information and an event system for Minecraft mods. This library offers a Mod-friendly API, enabling other mods to receive and process events regarding important player status changes such as health, hunger, oxygen levels, and more.

## Introduction

**Vital Signals** is an event library designed specifically for Minecraft mod developers. It leverages the Fabric API to provide low-level event hooks and network synchronization, allowing mods to precisely track various player attribute changes.

- 🎯 **Detailed Data Capture**: Captures every stage of the damage calculation process.
- 🔧 **Mod-friendly API**: Simple and easy-to-use event registration system.
- 📡 **Automatic Network Synchronization**: Server automatically syncs data to clients.
- 🛡️ **Complete Damage Reduction Information**: Records all sources of damage reduction (armor, shield, magic, etc.).

## Features

### Completed Features

#### Damage Event ✅

A comprehensive damage calculation tracking system that records all detailed information when a player takes damage.

### Planned Features

- 🔜 **Death Event** [v0.2.0]: Complete information upon player death.
- 🔜 **Hunger Event** [v0.3.0]: Changes in hunger and saturation levels.
- 🔜 **Oxygen Event** [v0.4.0]: Changes in underwater oxygen levels.

## Quick Start

### Adding Dependency

Add this library to your `build.gradle`:

```gradle
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    modImplementation 'com.github.Rainy-day-y:Vital-Signals:v0.1.2'
}
```

### Damage Event Data Structure (DamageData)

Data structure sent over the network for damage events, using NBT format:

| Field | Type | Description |
|------|------|------|
| `gameVersion` | `String` | Minecraft game version |
| `version` | `Int` | Data format version number |
| `isDirect` | `Boolean` | Whether it is direct damage |
| `typeId` | `Int` | Damage type ID |
| `phase` | `String` | Current damage calculation phase |
| `isCancelled` | `Boolean` | Whether the damage is cancelled |
| `damageAmount` | `Float` | Final damage value (actual impact on health) |
| `rawDamageAmount` | `Float` | Raw damage value |
| `difficultyReduced` | `Float` | Difficulty reduction amount |
| `shieldBlocked` | `Float` | Shield block amount |
| `iceReduced` | `Float` | Frost Walker boot reduction |
| `helmetReduced` | `Float` | Turtle Shell / Snow Boots reduction |
| `armorReduced` | `Float` | Armor reduction amount |
| `effectAndEnchantmentReduced` | `Float` | Magic effects and enchantment reduction |
| `absorbed` | `Float` | Damage absorption amount |
| `otherReduced` | `Float` | Other reductions (calculated difference) |

### Data Packet Example

```nbt
{
  gameVersion: "1.21.1",
  version: 1,
  isDirect: true,
  typeId: 0,
  phase: "FINAL",
  isCancelled: false,
  damageAmount: 5.0,
  rawDamageAmount: 10.0,
  difficultyReduced: 0.0,
  shieldBlocked: 0.0,
  iceReduced: 0.0,
  helmetReduced: 0.0,
  armorReduced: 2.0,
  effectAndEnchantmentReduced: 0.5,
  absorbed: 2.5,
  otherReduced: 0.0
}
```

## Roadmap

### v0.1.2 (Current Version) - Damage Event
- [x] Damage event infrastructure
- [x] Complete damage reduction information capture
- [x] Network synchronization to client
- [x] Mod-friendly API

### v0.2.0 (Planned) - Death Event
- [ ] Player death event trigger
- [ ] Detailed death cause information
- [ ] Pre-item drop hooks
- [ ] Experience point drop information

### v0.3.0 (Planned) - Hunger Event
- [ ] Hunger level change event
- [ ] Saturation level change event
- [ ] Hunger status change

### v0.4.0 (Planned) - Oxygen Event
- [ ] Oxygen level change event
- [ ] Drowning status tracking
- [ ] Water breathing effect detection

### v1.0.0 (Planned) - Full Release
- [ ] All core events refined
- [ ] API stability guarantee
- [ ] Complete documentation and examples
- [ ] Performance optimization

## License

This project is licensed under the [MIT License](LICENSE).

## Contributing

Issues and Pull Requests are welcome! For suggestions or questions, please contact us via GitHub Issues.

## Related Links

- [Fabric API Documentation](https://fabricmc.net)
- [Minecraft Wiki](https://minecraft.wiki)