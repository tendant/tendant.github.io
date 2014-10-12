#!/bin/bash

set -e

git co master

git co static -- .
git co master -- .gitignore
git reset

./build.sh
cp -r html/* .

# rm CNAME
# rm config.clj
# rm build.sh
# rm deploy.sh
# rm -r resources
