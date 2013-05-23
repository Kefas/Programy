#!/bin/bash

tyldy=$(find . -name "*~")
cpp=$(find . -name "*cpp")
h=$(find . -name "*h")

if [ -n "$tyldy" ]
then
rm *~
fi

if [ -n "$cpp" -o -n "$h" ] 
then
git add *cpp *h
git commit -m ${1}
git push origin ${2}
fi 



