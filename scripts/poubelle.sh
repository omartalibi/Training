#!/bin/bash

MAX_ATTEMPTS=5
TRASH_FILE=.trash
running=true
main(){
	while [[ running -eq true ]];
	do
       	 display_menu
	 user_choice=$(get_user_choice)
	 echo $user_choice
	 case $user_choice in
		1) display_trash;;
		2) restore_element;;
		3) delete_element;;
		4) empty_trash;;
		5) quit;;
	 esac
	done
	
}

display_trash(){
	ls -al $TRASH_FILE
}

restore_element(){
	local cannot="false"
	local replaced="false"
	read -p "filename (or full path) : " filename
	if [[ -f $TRASH_FILE"/"$filename ]];then
		if ! [[ -f $filename ]];then
			mv $TRASH_FILE"/"$filename .
			replaced="true"
		else
			cannot="true"
		fi
	fi

	if [[ -d $TRASH_FILE"/"$filename ]];then
		if ! [[ -d $filename ]];then
			mv $TRASH_FILE"/"$filename .
			replaced="true"
		else
			cannot="true"
		fi
	fi
	if [[ $cannot = "true" ]];then
		echo "cannot restore file $filename, already exist in the current directory"
	fi

	if [[ $replaced = "false" ]];then
		echo "file is not found in $TRASH_FILE"
	fi

}

delete_element(){
	read -p "filename (or full path) :" filename
	rm -rf filename
}

empty_trash(){
	rm -rf $TRASH_FILE/*
}

display_menu(){
	echo "========================"
	echo "1) Afficher la poubelle"
	echo "2) Restaurer un élément"
	echo "3) Supprimer un élément"
	echo "4) Vider la poubelle"
	echo "5) fin"
	echo "======================="
}

quit(){
	echo "exiting..."
	exit 0
}

force_quit(){
	running=false
	echo "You reached max tries with $MAX_ATTEMPTS wrong answers."
	echo "exiting..."
	exit 0
}		

get_user_choice(){
	local choice=0
	local attempts=1
	local regex='^[0-9]+$'
	while [[ $choice -gt 5 ]] || [[ $choice -lt 1 ]];do
		
		if [[ $attempts -gt $MAX_ATTEMPTS ]];then
			force_quit
		fi
		
		read -p "[attempt : $attempts] Votre choix : " choice
		
		if ! [[ $choice =~ $regex ]];then
			choice=9999
		fi
			
		attempts=$((attempts+1))
	done
	echo "$choice"
}



#Execution begins here!
main "$@"

