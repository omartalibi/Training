#!/bin/bash

TRASH_FILE=.trash
CURRENT_FOLDER=.
USAGE="[Usage] : $0 arg1 arg2 ..."
if [ $# -gt 0 ]; then
	list="ls -al"
	exists=$($list $CURRENT_FOLDER | grep ^[d] | grep $TRASH_FILE)
	if [ -z "$exists" ]; then
		echo "$TRASH_FILE directory dos not exist"
		mkdir $TRASH_FILE
	else
		echo "$TRASH_FILE directory exists"
	fi
	
	i=$#
	while [ $i -gt 0 ];
	do
		file2delete=$i
		echo $file2delete
		i=$(($i-1))
	done
else
	echo $USAGE 
fi
