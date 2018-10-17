#!/bin/bash

TRASH_FILE=.trash
CURRENT_FOLDER=.
USAGE="[Usage] : $0 arg1 arg2 ..."

main(){
	if [[ $# -lt 1 ]]; then
		echo $USAGE
		exit 0	
	fi

	put_files_into_trash $# $@
}

put_files_into_trash(){
	local nbFiles=$(($1+1))
	while [[ $nbFiles -gt 1 ]];do
		file2delete=${!nbFiles}	
		if [[ -f $file2delete ]] || [[ -d $file2delete ]]; then
			if [[ -d $TRASH_FILE"/"$file2delete ]];then
				rm -rf $TRASH_FILE"/"$file2delete
			fi
			verify_create_trash $TRASH_FILE
			echo "deleting file $file2delete"
			mv $file2delete $TRASH_FILE
		else
			echo "$file2delete not found."
			echo "$TRASH_FILE is not created."
		fi
		
		nbFiles=$(($nbFiles-1))
	done
}

verify_create_trash(){
	local trashFile=$1
	if ! [[ -d "$trashFile" ]]; then
		echo "$trashFile directory not found => $trashFile is created."
		mkdir $trashFile
		return $?
	fi
}



#Execution begins here!
main $@


###deleted code###
#exists=$($LIST $CURRENT_FOLDER | grep ^[d] | grep $TRASH_FILE)
#LIST="ls -al"
