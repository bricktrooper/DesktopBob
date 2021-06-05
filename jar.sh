#! /bin/bash

if [[ $# -ne 1 ]]
then
	echo "Incorrect arguments"
	exit 1
fi

ART=${1}

if ! test -d ${ART}
then
	echo "'${ART}' does not exist"
	exit 1
fi

cp -R costumes ${ART}
cd ${ART}
jar -cfe DesktopBob.jar DesktopBob *
