<?php
	$_DB['server'] = 'localhost'; 		// Servidor
	$_DB['user'] = 'root';       		// Usuário
	$_DB['password'] = '';     	// Senha
	$_DB['database'] = 'pettio';	    // Schema do BD

	$_DB['connection'] = mysqli_connect($_DB['server'],$_DB['user'], $_DB['password']) 
		or die("Code 500 Error");

	mysqli_set_charset($_DB['connection'],"utf8");	
		
	mysqli_select_db($_DB['connection'],$_DB['database']) 
		or die("Code 404 Error");		
?>
