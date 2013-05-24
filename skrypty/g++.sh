#!/bin/bash

#Kompilowanie wielu plików cpp w g++

pliki=$(find . -name "*cpp")

if [ -n "$pliki" ]
then
g++ *.cpp -Wno-write-strings -o output
fi

