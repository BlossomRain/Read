# 第二章运放电路图（LaTeX / CircuiTikZ）

**手画代表图规范（Designer → Agent 批量重绘）：** [`designer-sample-brief.md`](designer-sample-brief.md)  
交稿目录：`source/designer-samples/`

Agent 供图与版图规则见仓库 `.cursor/rules/electronics-op-amp-figures.mdc`（含用户 prompt 模板与验收清单）。

全部电路原理图由 **CircuiTikZ** 统一生成，共享样式见：

`image/电子学一/source/02-op-circuit-style.tex`

- `american` 符号、`noinv input up`（+ 在上、− 在下）
- 统一线宽、`bipoles/length=0.95cm`、`\small` 标注
- 统一几何：输入/输出端子、$R_1$ 垂直接地、$R_2$ 水平反馈

**§2.5 PN 结（TikZ / pgfplots，非 CircuiTikZ）**

| SVG | 源文件 | 说明 |
|-----|--------|------|
| `02-pn-junction-equilibrium-diagram-01` | `source/02-pn-junction-equilibrium-diagram-01.tex` | 平衡：耗尽层、$N_A^-$ / $N_D^+$、$\vec{E}_{\mathrm{bi}}$ |
| `02-pn-junction-band-diagram-01` | `source/02-pn-junction-band-diagram-01.tex` | 能带：$E_g$、$qV_{\mathrm{bi}}$、$e^-$ 势垒 |
| `02-pn-junction-potential-barrier-01` | `source/02-pn-junction-potential-barrier-01.tex` | 上下分图：$\phi(x)$ 与 $E(x)$ |
| `02-pn-junction-forward-bias-01` | `source/02-pn-junction-forward-bias-01.tex` | 平衡 vs 正向偏压势垒 |
| `02-pn-diode-symbol-diagram-01` | `source/02-pn-diode-symbol-diagram-01.tex` | 二极体符号、p/n、$v$、$i$ |
| `02-pn-diode-iv-characteristic-01` | `source/02-pn-diode-iv-characteristic-01.tex` | Shockley $I$–$V$（$I_s=10^{-14}$ A） |
| `02-pn-photodetector-principle-diagram-01` | `source/02-pn-photodetector-principle-diagram-01.tex` | 光生 e-h、$\vec{E}_{\mathrm{bi}}$ 漂移、$I_{\mathrm{ph}}$ |
| `02-pn-photodetector-equivalent-model-01` | `source/02-pn-photodetector-equivalent-model-01.tex` | $I_{\mathrm{ph}}$ 源 $\parallel$ 二极体 $D$ |
| `02-op-photodetector-voltage-follower-diagram-01` | `source/02-op-photodetector-voltage-follower-diagram-01.tex` | 光侦测器等效模型 + 电压跟随器 |
| `02-op-photodetector-iv-converter-diagram-01` | `source/02-op-photodetector-iv-converter-diagram-01.tex` | 光侦测器等效模型 + 反相 I–V 转换（$R_f$） |
| `02-street-light-control-circuit-diagram-01` | `source/02-street-light-control-circuit-diagram-01.tex` | 街灯链：PD→I–V→比较→$Q$→$D_p$–$R$–$K_1$∥$D_f$→ST→灯 |
| `02-bjt-npn-terminal-model-diagram-01` | `source/02-bjt-npn-terminal-model-diagram-01.tex` | NPN BJT 三端 B/E/C 与 $I_B$、$I_C$、$I_E$ |
| `02-op-iv-converter-model-diagram-01` | `source/02-op-iv-converter-model-diagram-01.tex` | I–V 转换器（左）与 $R_i$、$A i_i$、$R_o$、$R_L$ 模型（右） |
| `02-op-two-port-h-parameters-diagram-01` | `source/02-op-two-port-h-parameters-diagram-01.tex` | 双端口网络与 h 参数方程组 |
| `02-op-vi-converter-model-diagram-01` | `source/02-op-vi-converter-model-diagram-01.tex` | V–I 转换器（左）与 $R_i$、$G v_i$、$R_o$、$R_L$ 模型（右） |
| `02-op-iv-converter-model-designer-01` | `source/02-op-iv-converter-model-designer-01.tex` | [CircuiTikZ Designer](https://circuit2tikz.tf.fau.de/designer/) 手绘导出草稿（I–V + 受控电压源模型，未整理） |

图内标注为英文（pdflatex 无 CJK）；笔记正文为中文。

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
  "02-op-ekg-right-leg-drive-block-diagram-01",
  "02-pn-junction-equilibrium-diagram-01",
  "02-pn-junction-band-diagram-01",
  "02-pn-junction-potential-barrier-01",
  "02-pn-junction-forward-bias-01",
  "02-pn-diode-symbol-diagram-01",
  "02-pn-diode-iv-characteristic-01",
  "02-pn-photodetector-principle-diagram-01",
  "02-pn-photodetector-equivalent-model-01",
  "02-op-photodetector-voltage-follower-diagram-01",
  "02-op-photodetector-iv-converter-diagram-01",
  "02-street-light-control-circuit-diagram-01",
  "02-bjt-npn-terminal-model-diagram-01",
  "02-op-iv-converter-model-diagram-01",
  "02-op-two-port-h-parameters-diagram-01",
  "02-op-vi-converter-model-diagram-01",
  "02-op-iv-converter-model-designer-01"
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
