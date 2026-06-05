# Compile handmade preview .tex -> .svg in this folder
$ErrorActionPreference = "Stop"
$dir = $PSScriptRoot

$names = @(
  "01-follower",
  "02-inverting",
  "03-non-inverting",
  "04-integrator",
  "05-iv-model"
)

foreach ($base in $names) {
  $tex = Join-Path $dir ($base + ".tex")
  if (-not (Test-Path -LiteralPath $tex)) {
    Write-Warning "Skip missing: $tex"
    continue
  }
  Write-Host "Building $base ..."
  & pdflatex -interaction=nonstopmode -halt-on-error -output-directory $dir $tex
  if ($LASTEXITCODE -ne 0) { throw "pdflatex failed: $tex" }

  $pdf = Join-Path $dir ($base + ".pdf")
  $svg = Join-Path $dir ($base + ".svg")
  # dvisvgm writes progress to stderr; avoid NativeCommandError on stderr-only output
  $dviOut = & cmd /c "dvisvgm --pdf --bbox=min --exact -o `"$svg`" `"$pdf`" 2>&1"
  if ($LASTEXITCODE -ne 0) {
    throw "dvisvgm failed: $pdf`n$dviOut"
  }

  foreach ($ext in @(".aux", ".log", ".pdf")) {
    $artifact = Join-Path $dir ($base + $ext)
    if (Test-Path -LiteralPath $artifact) {
      Remove-Item -LiteralPath $artifact -Force
    }
  }
  Write-Host "  -> $svg"
}

Write-Host "Done."
