# CircuiTikZ Designer 代表图绘制说明

你在 [CircuiTikZ Designer](https://circuit2tikz.tf.fau.de/designer/) 中**只画少量代表图**，用来固定电路版式规范；Agent 据此**重写**仓库里全部 `.tex` 并编译 SVG。

**你不需要**重画笔记中的每一张图。

---

## 工作流程

1. 按本文「代表图清单」在 Designer 中手画拓扑（不必抠像素级对齐）。
2. 每张图：**Save JSON** + **Export CircuiTikZ code**（`Ctrl+S` / `Ctrl+E`）。
3. 将导出文件放入 `image/电子学一/source/designer-samples/`（目录可新建），命名见下表。  
   **当前交稿（2026-06）：** `电子学/handmade/`（含 `*.tikz`、`01`–`05` 预览与 [`版式规范摘要.md`](../../../handmade/版式规范摘要.md)）。
4. 交稿时在对话中 @ 该目录，或说明「代表图已放入 designer-samples」。
5. Agent 先整理《版式规范摘要》供你确认，再批量重绘正式图源。

### 交稿命名

| 代表图 ID | 建议 JSON 文件名 | 建议说明文件（可选） |
|-----------|------------------|----------------------|
| `sample-ch2-01-follower` | 同名 `.json` | 同名 `.md` 一两句备注 |
| … | … | … |

Export 的 `.tex` 片段可贴在同名 `.tex` 或 `.md` 中。

### 每张代表图务必体现

- [ ] 元件符号朝向（运放 +/−、电源、地）
- [ ] 导线只走水平/竖直（无斜穿）
- [ ] 端子：开路圆点 + 标签（$v_i$、$v_o$、$i_i$、$i_o$）
- [ ] 电阻/电容标签相对元件的位置（上/下/左/右）
- [ ] 地线：符号位置、是否与电阻横连
- [ ] 若有双面板：标题、`||` 分隔、**哪些顶线故意断开**

---

## 第二章：代表图清单（推荐 6 张）

| 优先级 | ID | 画什么 | 固定哪些规范 | Agent 据此重绘（不必你再画） |
|--------|-----|--------|--------------|------------------------------|
| **必做** | `sample-ch2-01-follower` | **电压跟随器** | 运放 `+` 在上；$v_i\to(+)$；反馈走三角**下方**；$v_o$ 端子 | `02-op-voltage-follower-diagram-01` |
| **必做** | `sample-ch2-02-inverting` | **反相放大器** | $(+)$ **仅接地**；$v_i\to R_1\to v_-$；$R_2$ 走**底母线**回输出 | `02-op-inverting-amplifier-diagram-01`、`02-op-inverter-example-diagram-01`（四电阻/差动） |
| **必做** | `sample-ch2-03-non-inverting` | **同相放大器** | $(+)$ 接 $v_i$；$(-)$ 上 $R_1$ 地、$R_2$ 到 $v_o$ | `02-op-non-inverting-amplifier-diagram-01`、`02-op-adder-diagram-01` |
| **必做** | `sample-ch2-04-iv-model` | **I–V 转换器 + model**（左电路 \| 右模型） | 双面板：`i-v converter` / `model` / `||`；**$R_i$ 顶与 $A i_i$ 顶断开**；$R_o$、$R_L$、公共地 | `02-op-iv-converter-model-diagram-01`、`02-op-photodetector-iv-converter-diagram-01`（PD 部分可沿用既有拓扑） |
| **必做** | `sample-ch2-05-integrator` | **积分器** | 反相结构；输入 $R$；反馈 **$C$**（替代 $R_2$） | `02-op-integrator-diagram-01` → 推 `02-op-integrator-rf-diagram-01`（加 $R_f$） |
| **强烈建议** | `sample-ch2-06-vi-left` | **V–I 转换器左半电路**（可不画右侧 model） | $(-)$ 上顶母线：$R$ 水平接 $v_o$；$(+)$ 下：$v_i$ 折线；输出 $i_o$ | `02-op-vi-converter-model-diagram-01` 左侧；右侧 model 版式对齐 `sample-ch2-04` |
| **强烈建议** | `sample-ch2-07-ii-left` | **I–I 放大器左半电路**（可不画右侧 model） | 同 V–I/I–V 顶母线版式；$i_i\to R_2\to v_-$；**反馈线** $v_o\to v_-$（**不画** $R_1$）；$i_o$ 端子 | `02-op-ii-converter-model-diagram-01` 左侧；右侧 model 对齐 §2.8.3 |

### 第二章：有代表图即可 extrapolate、不必再画

| 类别 | 正式文件名示例 | 依据 |
|------|----------------|------|
| 跟随器端口等效 | `02-op-voltage-follower-port-equivalent-diagram-01` | `sample-ch2-04` 的 model 侧 + 02-op 规范 |
| 微分器 | `02-op-differentiator-diagram-01`、`02-op-differentiator-rs-diagram-01` | `sample-ch2-02` + ⑤ 换元件（输入 $C$、反馈 $R$） |
| 积分 + $R_f$ | `02-op-integrator-rf-diagram-01` | ⑤ + 并联 $R_f$ |
| h 参数双端口 | `02-op-two-port-h-parameters-diagram-01` | 双面板规则 + 笔记方程 |
| 仪表放大器 | `02-op-instrumentation-amplifier-diagram-01` | ①③ 重复运放规则 |
| 光侦测 + 跟随 | `02-op-photodetector-voltage-follower-diagram-01` | ① + PD 等效源 |
| 街灯系统 | `02-street-light-control-circuit-diagram-01` | ②④ 块级延伸；若不满意可后补 `sample-ch2-07-system` |
| EKG 框图 | `02-op-ekg-right-leg-drive-block-diagram-01` | 块图，非精细 CircuiTikZ |
| 理想开环 | `02-op-ideal-open-loop-model-diagram-01` | ① 去掉反馈 / 加开环标注 |
| **曲线图** | `*-bode-plot-01`、`*-waveforms-01`、`*-transfer-*` | **不需 Designer**；pgfplots 维护 |

参考目录：`source/02-op-*.tex`；重建列表见 `02-op-figure-sources.md`。

---

## 第一章：代表图分析

第一章图源**风格比第二章更杂**，分四类。你只需为**原理图类**画代表；类比示意、曲线图由 Agent 用 TikZ/pgfplots 直接重绘。

### 第一章图源分类

| 类型 | 说明 | 示例 | 是否需要 Designer 代表 |
|------|------|------|------------------------|
| **A. 串联 DC 回路** | 左地或单点地，$V\to R\to C\to\cdots$ 串链；结点 `*` | Thevenin 例题、RC 充电、RC 耦合、语音低通 | **需要 1 张代表** |
| **B. 上下轨并联** | 顶线 $V_{DD}$/电源、底线地；多支路垂直并联 | 激光笔 bypass（$I_s$、$R_L$、$C$） | **需要 1 张代表** |
| **C. 多面板等效** | 原网络 $\Rightarrow$ Thevenin $\Rightarrow$ Norton | `01-basic-equivalent-circuit-overview-diagram-01` | **需要 1 张代表**（可与 Ch2 双面板规则统一） |
| **D. 小信号受控源模型** | $g_m v_i$ 源、$R_L$、端子、公共地 | MOS 小信号模型 | **需要 1 张代表** |
| **E. 类比 + 电路对照** | 水桶/平行板 + $\Longrightarrow$ + RC 回路 | 电容模型、DC 充电类比 | **建议 1 张**（若要统一「类比→电路」横向版式） |
| **F. 机电混合** | 麦克风极板 + $C$ 符号 | 电容麦克风 | 可选；可从 E 类推 |
| **G. MOS 完整偏置** | 晶体管 + 分压 + 耦合电容 | `01-basic-mos-amplifier-bias-coupling`（现仅 SVG） | 可选；复杂，可后补 |
| **H. 曲线 / 相量图** | Bode、波形、最大功率曲线、相量 intro | `*-plot-01`、`*-waveforms-01` | **不需要** |

### 第一章：代表图清单（推荐 4 张，+1 可选）

| 优先级 | ID | 画什么 | 固定哪些规范 | Agent 据此重绘 |
|--------|-----|--------|--------------|----------------|
| **必做** | `sample-ch1-01-series-dc` | **Thevenin 例题**或 **RC 串联合成**（$V$–$R$–$C$–$R$–地） | 地线位置；串链走线；结点；$v_{out}$ / $v_x$ 引出方式；`american` 符号 | `01-basic-thevenin-example-diagram-01`、`01-basic-rc-series-coupling-example-diagram-01`、`01-basic-ac-capacitor-charging-diagram-01`、`01-basic-rc-discharge-diagram-01`、`01-basic-maximum-output-power-diagram-01`；笔记中尚无 `.tex` 的 `01-basic-voice-low-pass-*`、`01-basic-capacitor-coupling-high-pass-*` |
| **必做** | `sample-ch1-02-rail-parallel` | **激光笔 bypass**（顶轨电源、底轨地；$I_s$、$R_L$、$C$ 并联） | 双轨布局；并联支路间距；分支文字标注位置 | `01-basic-laser-pointer-noise-bypass-diagram-01` |
| **必做** | `sample-ch1-03-thevenin-norton` | **等效变换三板**（原网络 → Thevenin → Norton） | 面板标题；$\Longrightarrow$；端口 a/b；$R_{th}$、$V_{th}$、$I_N$ 排布 | `01-basic-equivalent-circuit-overview-diagram-01` |
| **必做** | `sample-ch1-04-mos-small-signal` | **MOS 小信号模型**（$v_i'$ 端子、$g_m v_i'$、$R_L$、$v_o'$） | 受控源方向；AC gnd / $V_{DD}$；公式放图下还是图内 | `01-basic-mos-small-signal-model-diagram-01` → 推 `01-basic-mos-amplifier-model-diagram-01`、补 `01-basic-mos-amplifier-bias-coupling-diagram-01.tex` |
| **建议** | `sample-ch1-05-analogy-circuit` | **DC 充电：水桶类比 $\Longrightarrow$ RC 电路**（半幅类比 + 半幅电路即可） | 类比图与电路的分隔；箭头；同一 $V$/$R$/$C$ 标签习惯 | `01-basic-dc-capacitor-charging-analogy-diagram-01`、`01-basic-capacitor-model-diagram-01`（桶 + 平行板 + 集总 $C$） |
| 可选 | `sample-ch1-06-microphone` | 电容麦克风（极板 + $C$） | 机械结构与电路符号并存 | `01-basic-capacitive-microphone-diagram-01` |

### 第一章：不必画代表图

| 文件 | 原因 |
|------|------|
| `01-basic-dc-capacitor-charging-waveforms-01` | 时间波形，pgfplots |
| `01-basic-capacitor-equivalent-resistance-plot-01` | $|Z_C|$ vs $f$ 曲线 |
| `01-basic-ac-capacitor-bode-plot-01`、phase bode | 波特图 |
| `01-basic-maximum-output-power-plot-01` | 归一化功率曲线 |
| `01-basic-phasor-analysis-intro-diagram-01` | 相量/复平面（现仅 SVG，用 TikZ 重画） |
| `01-basic-water-voltage-analogy-figure-01` | 水流类比（位图/SVG，可按 §1.1 文字重做） |

---

## 汇总：最少交稿数量

| 章节 | 最少 | 推荐 |
|------|------|------|
| **第二章** | 5 张（缺 `sample-ch2-06-vi-left` 时 V–I 左图由文字推） | **6 张**（含 V–I 左半） |
| **第一章** | 4 张（串联 / 双轨 / 等效三板 / MOS 小信号） | **5 张**（加类比→电路） |
| **合计** | 9 张 | **11 张** |

先交 **第二章 6 张**即可启动运放图批量重绘；第一章可在运放规范确认后再交 4–5 张。

---

## 代表图拓扑速查（绘制时对照）

### Ch2 `sample-ch2-04-iv-model` 右模型（必_disconnect）

```text
输入回路：i_i ── Ri ── 地        （Ri 顶部不向右连）
输出回路：A i_i ── Ro ── vo ── RL ── 地   （与 Ri 顶线断开）
中间：||
```

### Ch2 转换器左栏（§2.7.2 / §2.8.3 / §2.8.4 共用）

Designer 默认 op amp：**− 在上、+ 在下**；反馈走 **顶母线** `\RfY`（与反相放大底母线不同）。

```text
顶母线 y=RfY：v_- 结点 VM ── 水平 ── FBR ── 竖落 ── out
I–V：i_i → VM；母线上 R（VM→FBR）；+ 接地；vo 端子
V–I：母线上 R（VM→FBR）；+ 下折 vi；io 端子
I–I：i_i → R2 → VM；母线仅反馈线（无 R1）VM→FBR；+ 接地；io 端子
```

### Ch2 `sample-ch2-06-vi-left`

```text
(-) 顶母线 ── R ── out
(+) ── 折线 ── vi 端子
out ── io 端子
```

### Ch2 `sample-ch2-07-ii-left`

```text
i_i ── R2 ── v_-（顶母线结点）
顶母线反馈线 v_o → v_-（不画 R1）
+ 接地；out ── i_o 端子
```

### Ch1 `sample-ch1-01-series-dc`

```text
地 ── V ── R ── … ── 负载/结点 ── … ── 地
（一条主回路，直角走线）
```

---

## 相关文件

- 运放共享样式：`source/02-op-circuit-style.tex`
- 运放图源索引：`figures/02-op-figure-sources.md`
- 版图验收规则：`.cursor/rules/electronics-op-amp-figures.mdc`
- 笔记引用：`` `电子学一.md` ``（第一章）、`` `电子学一第二章.md` ``（第二章）

---

*创建目的：用户手画代表图 → Agent 统一重绘正式 CircuiTikZ 源文件。*
