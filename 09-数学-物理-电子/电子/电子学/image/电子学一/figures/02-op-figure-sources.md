# 第二章运放电路图（LaTeX / CircuiTikZ）

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
  "02-op-inverter-example-diagram-01"
)
foreach ($f in $figs) {
  .\build-tex-figure.ps1 -TexFile "..\image\电子学一\source\$f.tex"
}
```

波形图（转移特性、正弦→方波）仍为独立 TikZ 源文件，不在此列。
