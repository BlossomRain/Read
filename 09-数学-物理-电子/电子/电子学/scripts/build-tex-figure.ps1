param(
    [Parameter(Mandatory = $true)]
    [string]$TexFile
)

$ErrorActionPreference = "Stop"

$texPath = (Resolve-Path -LiteralPath $TexFile).Path
$sourceDir = Split-Path -Parent $texPath
$baseName = [System.IO.Path]::GetFileNameWithoutExtension($texPath)
$themeDir = Split-Path -Parent $sourceDir
$figuresDir = Join-Path $themeDir "figures"

if (-not (Test-Path -LiteralPath $figuresDir)) {
    New-Item -ItemType Directory -Path $figuresDir | Out-Null
}

& pdflatex -interaction=nonstopmode -halt-on-error -output-directory $sourceDir $texPath
if ($LASTEXITCODE -ne 0) {
    throw "pdflatex failed for $texPath"
}

$pdfPath = Join-Path $sourceDir ($baseName + ".pdf")
$svgPath = Join-Path $figuresDir ($baseName + ".svg")

& dvisvgm --pdf --bbox=min --exact -o $svgPath $pdfPath
if ($LASTEXITCODE -ne 0) {
    throw "dvisvgm failed for $pdfPath"
}

$cleanupExts = @(".aux", ".log", ".pdf")
foreach ($ext in $cleanupExts) {
    $artifactPath = Join-Path $sourceDir ($baseName + $ext)
    if (Test-Path -LiteralPath $artifactPath) {
        Remove-Item -LiteralPath $artifactPath -Force
    }
}

Write-Output "Generated: $svgPath"
