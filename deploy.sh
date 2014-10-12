#!/bin/bash

set -e

git co master

git co static -- .
./build.sh
cp -r resources/html/* .

rm CNAME
rm config.clj
rm build.sh
rm -r resources
