#!/bin/bash

#Kompilowanie wielu plików cpp w g++

if [ -e *.cpp ]
then
g++ *.cpp -Wno-write-strings -o output
fi

