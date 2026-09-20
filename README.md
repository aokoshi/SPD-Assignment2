# Logistics Application: Factory Method + Abstract Factory

Assignment 2, ShP-2216 Software Design Patterns, Astana IT University.
Author: Pashanov Yelnur, group SE-2523.

## Purpose
A console logistics application that combines two creational patterns in one program:
- **Factory Method** creates the transport (`Truck` for road, `Ship` for sea).
- **Abstract Factory** creates a matching UI pair (`Button` + `Checkbox`) for Windows or macOS.

The delivery mode and the UI platform are chosen independently at startup, so all four combinations work without editing code.

## Package structure
```
src/
  logistics/  Transport, Truck, Ship, Logistics, RoadLogistics, SeaLogistics   (Factory Method)
  gui/        Button, Checkbox, GUIFactory, WindowsFactory, MacOSFactory,
              WindowsButton, WindowsCheckbox, MacOSButton, MacOSCheckbox      (Abstract Factory)
  app/        DeliveryApplication (client), Main (startup and validation)
docs/
  uml/        factory-method and abstract-factory diagrams (.puml + .png)
  verification.txt   console transcript of all required checks
```

## Prerequisites
JDK 17 or newer (`javac -version`).

## Build
Run from the repository root.

Linux / macOS:
```
mkdir -p out
javac -d out $(find src -name "*.java")
```
Windows (PowerShell):
```
mkdir out -Force
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
```

## Run
```
java -cp out app.Main <ROAD|SEA> <WINDOWS|MACOS>
```
Supported values (case-insensitive):
- delivery mode: `ROAD`, `SEA`
- UI platform: `WINDOWS`, `MACOS`

## Validation behavior
Input is given as two command-line arguments. If the arguments are missing (fewer or more than two) or a value is not supported, the program prints an error and the usage line, then stops with exit code 1. No default is used, nothing is rendered and nothing is delivered.

## Sample run
```
$ java -cp out app.Main SEA MACOS
Delivery mode: SEA
UI platform: MACOS
Rendering macOS button
Rendering macOS checkbox
Ship delivers laboratory equipment to Aktau warehouse by sea
```
More runs, including error cases: `docs/verification.txt`.
