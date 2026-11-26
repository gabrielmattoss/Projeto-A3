@echo off
cd /d "%~dp0"

javac --release 8 -Xlint:-options -d bin Chamado.java Main.java

if errorlevel 1 (
    echo Erro ao compilar. Verifique se o JDK esta instalado e no PATH.
    pause
    exit /b
)

java -cp bin Main
pause
