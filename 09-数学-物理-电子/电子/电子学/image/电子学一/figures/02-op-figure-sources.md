# 第二章运放电路图（LaTeX / CircuiTikZ）

Agent 供图与版图规则见仓库 `.cursor/rules/electronics-op-amp-figures.mdc`（含用户 prompt 模板与验收清单）。

全部电路原理图由 **CircuiTikZ** 统一生成，共享样式见：

`image/电子学一/source/02-op-circuit-style.tex`

- `american` 符号、`noinv input up`（+ 在上、− 在下）
- 统一线宽、`bipoles/length=0.95cm`、`\small` 标注
- 统一几何：输入/输出端子、$R_1$ 垂直接地、$R_2$ 水平反馈

重建命令（在 `电子学/scripts` 下）：

```powershell
$figs = @(
  "02-op-ideal-open-loop-model-diagram-01",
  "02-op-voltage-follower-diagram-01",
  "02-op-voltage-follower-port-equivalent-diagram-01",
  "02-op-non-inverting-amplifier-diagram-01",
  "02-op-adder-diagram-01",
  "02-op-inverting-amplifier-diagram-01",
  "02-op-integrator-diagram-01",
  "02-op-integrator-rf-diagram-01",
  "02-op-integrator-step-saturation-waveforms-01",
  "02-op-integrator-offset-drift-waveforms-01",
  "02-op-integrator-bode-plot-01",
  "02-op-integrator-rf-bode-plot-01",
  "02-op-differentiator-diagram-01",
  "02-op-differentiator-bode-plot-01",
  "02-op-differentiator-rs-diagram-01",
  "02-op-differentiator-rs-bode-plot-01",
  "02-op-inverter-example-diagram-01",
  "02-op-instrumentation-amplifier-diagram-01",
  "02-op-closed-loop-transfer-saturation-plot-01",
  "02-op-ekg-right-leg-drive-block-diagram-01"
)
foreach ($f in $figs) {
  .\build-tex-figure.ps1 -TexFile "..\image\电子学一\source\$f.tex"
}
```

**位图（参考扫描，非构建链）**

| 文件 | 说明 |
|------|------|
| `02-op-ekg-right-leg-drive-diagram-01.png` | EKG 完整原理图（AD620/AD705）；笔记中与 `02-op-ekg-right-leg-drive-block-diagram-01.svg` 对照 |
| `02-op-analog-computer-mass-spring-damper-01.png` | §2.4.6 质量–弹簧–阻尼模拟计算机板书（参考 [I4CY](https://www.i4cy.com/analog_computing/)） |

波形图（转移特性、正弦→方波）仍为独立 TikZ 源文件，不在此列。
