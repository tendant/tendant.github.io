#!/bin/bash

set -ex

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

git add -A
git commit -m "deployed at `date`"

git co static
