#!/bin/bash

v_profile="producction"

#JAVA_HOME=/usr/java/jdk1.8.0_191-i586

v_service=/etc/init.d/mailingproduccion
v_path=$(pwd)
v_namejar=mailingceet-rest-1.0.jar
v_name_webfolder=mailingceet-rest
v_jar=$v_path"/"$v_name_webfolder"/"$v_namejar
v_jarTarget=$v_path"/"$v_name_webfolder"/target/"$v_namejar

git reset --hard master
git pull
mvn clean install
$v_service stop

echo "borrando "$v_jar
rm -rf $v_jar
echo "copiando "$v_jarTarget" a "$v_jar
cp -R $v_jarTarget  $v_jar
echo "borrando "$v_service
rm -rf $v_service
ln -s $v_jar $v_service
$v_service start  --spring.profiles.active=$v_profile
