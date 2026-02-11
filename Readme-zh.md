# Vital Signals

[ [English](./Readme.md) | 简体中文 ]

一个为 Minecraft 模组提供详尽的玩家状态信息和事件系统的库（Lib）。本库提供 Mod 友好的 API，使其他模组能够接收和处理玩家生命值、饱食度、氧气值等重要信息的变化事件。

## 简介

**Vital Signals** 是一个专为 Minecraft 模组开发者设计的事件库，它通过 Fabric API 提供低级别的事件钩子和网络同步，使模组能够精确追踪玩家的各项参数变化。

- 🎯 **详尽的数据捕捉**：捕捉伤害计算过程中的每一个环节
- 🔧 **Mod 友好的 API**：简单易用的事件注册系统
- 📡 **自动网络同步**：服务端自动将数据同步到客户端
- 🛡️ **完整的减伤信息**：记录所有减伤源（护甲、盾牌、魔法等）

## 项目特性

### 已完成功能

#### 伤害事件（Damage Event）✅

完整的伤害计算追踪系统，记录玩家受到伤害时的所有细节信息。

### 计划功能

- 🔜 **死亡事件（Death Event）** [v0.2.0]：玩家死亡时的完整信息
- 🔜 **饱食度事件（Hunger Event）** [v0.3.0]：饱食度与饱和度变化
- 🔜 **氧气值事件（Oxygen Event）** [v0.4.0]：水下氧气值变化

## 快速开始

### 添加依赖

在你的 `build.gradle` 中添加本库：

```gradle
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    modImplementation 'com.github.Rainy-day-y:Vital-Signals:v0.1.2'
}
```

### 伤害事件数据结构（DamageData）

伤害事件通过网络发送的数据结构，采用 NBT 格式：

| 字段 | 类型 | 说明 |
|------|------|------|
| `gameVersion` | `String` | Minecraft 游戏版本 |
| `version` | `Int` | 数据格式版本号 |
| `isDirect` | `Boolean` | 是否为直接伤害 |
| `typeId` | `Int` | 伤害类型 ID |
| `phase` | `String` | 当前伤害计算阶段 |
| `isCancelled` | `Boolean` | 伤害是否被取消 |
| `damageAmount` | `Float` | 最终伤害值（对生命值的实际影响） |
| `rawDamageAmount` | `Float` | 原始伤害值 |
| `difficultyReduced` | `Float` | 难度减免量 |
| `shieldBlocked` | `Float` | 盾牌格挡量 |
| `iceReduced` | `Float` | 冰冻步行靴减伤 |
| `helmetReduced` | `Float` | 龟纹镶板/雪地靴减伤 |
| `armorReduced` | `Float` | 护甲减伤量 |
| `effectAndEnchantmentReduced` | `Float` | 魔法效果与附魔减伤 |
| `absorbed` | `Float` | 伤害吸收量 |
| `otherReduced` | `Float` | 其他减伤（计算差值） |

### 数据包示例

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

### v0.1.2（当前版本）- 伤害事件
- [x] 伤害事件基础架构
- [x] 完整的减伤信息捕捉
- [x] 网络同步到客户端
- [x] Mod 友好的 API

### v0.2.0（计划中）- 死亡事件
- [ ] 玩家死亡事件触发
- [ ] 死亡原因详细信息
- [ ] 物品掉落前置钩子
- [ ] 经验值掉落信息

### v0.3.0（计划中）- 饱食度事件
- [ ] 饱食度变化事件
- [ ] 饱和度变化事件
- [ ] 饥饿状态变化

### v0.4.0（计划中）- 氧气值事件
- [ ] 氧气值变化事件
- [ ] 溺水状态追踪
- [ ] 水呼吸效果检测

### v1.0.0（计划中）- 完整版本发布
- [ ] 所有核心事件完善
- [ ] API 稳定性保证
- [ ] 完整文档和示例
- [ ] 性能优化

## 许可证

本项目采用 [MIT License](LICENSE) 许可证。

## 贡献

欢迎提交 Issue 和 Pull Request！如有建议或问题，请通过 GitHub Issue 联系我们。

## 相关链接

- [Fabric API 文档](https://fabricmc.net)
- [Minecraft Wiki](https://minecraft.wiki)
