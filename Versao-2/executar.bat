@echo off
chcp 65001 >nul
cd /d "%~dp0"
if not exist bin mkdir bin
javac --release 8 -Xlint:-options -encoding UTF-8 -d bin Chamado.java Main.java
if errorlevel 1 (
    echo Nao foi possivel compilar. Verifique se o JDK 8 ou superior esta instalado e configurado no PATH.
    pause
    exit /b 1
)
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 -cp bin Main
pause
