:: Prevent commands from being displayed while running the script
@echo off
cls

:: There should be no space before and after the `=` sign in batch file variable declaration.

:: Set location of Main.java entry file (Absolute or relative)
set entryFile=".\src\com\spincity\roulette\client\Main.java"

:: Set javac classpath: the directory where javac will look for any import paths like com.project.MyClass
set classpathDir=".\src"

:: Set the name of the compiled Main.class (without the .class)
set compiledEntryFile="com.spincity.roulette.client.Main"

:: Set location of any library Jars
set libraries=".\lib\*"

:: Set output directory for compiled files.
set outDir="\out\production\JavaProject_Team3"

:: Create the out folder, if it does not exist including any parent folders.
if not exist %outDir% mkdir %outDir%

:: Compile the .java file into .class bytecode files
:: -d is the directory where compiled files will be saved, if not specified, the .class file will be saved where .java files are.
:: -classpath is the directory where javac will look for any import path like "com.project.MyClass".
javac -d %outDir% -classpath %classpathDir%;%libraries% %entryFile%

:: %* pass all cli arguments to java command
:: -classpath is the directory where compiled files are (project root).
java -classpath %outDir%;%libraries% %compiledEntryFile% %*

:: Pause for use input before exiting: "Press any key to continue..."
pause