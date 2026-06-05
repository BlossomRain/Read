# handmade 手绘拓扑 → 规范预览图

## 文件说明

| 手绘草稿（Designer 导出） | 整理后的源文件 | 预览 SVG |
|---------------------------|----------------|----------|
| `follower.tikz` | `01-follower.tex` | `01-follower.svg` |
| `inverting_amp.tikz` | `02-inverting.tex` | `02-inverting.svg` |
| `noninverting_amp.tikz` | `03-non-inverting.tex` | `03-non-inverting.svg` |
| `integral.tikz` | `04-integrator.tex` | `04-integrator.svg` |
| `iv.tikz` | `05-iv-model.tex` | `05-iv-model.svg` |

`.tikz` 为 Designer 原始导出（上 − 下 +、顶线）；`01`–`05` 为 **镜像后** 的预览（**+ 在上**、底母线），与正式图源一致。

## 重新编译

```powershell
cd "09-数学-物理-电子/电子/电子学/handmade"
.\build-preview.ps1
```

需要本机已安装 `pdflatex` 与 `dvisvgm`。
