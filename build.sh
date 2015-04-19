set -ex 

java -jar ../static-app.jar --build
# rsync -avz html/ /var/www/blog/
