$startDir = if ($MyInvocation.MyCommand.Path) { Split-Path $MyInvocation.MyCommand.Path -Parent } else { (Get-Location).Path }
$files = Get-ChildItem -Path $startDir -Recurse -Filter '*Test.java' -File

if (-not $files) {
    Write-Host "No *Test.java files found under $startDir"
    exit 1
}

Write-Host "Found $($files.Count) test file(s)."

foreach ($f in $files) {
    $hasMain = Select-String -Path $f.FullName -Pattern 'static\s+void\s+main' -Quiet
    if (-not $hasMain) {
        Write-Host "Skipping (no main): $($f.FullName)"
        continue
    }

    & java $f.FullName
}