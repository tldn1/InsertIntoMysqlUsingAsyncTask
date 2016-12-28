<?php
	error_reporting(0);
	require "init.php";
	 
	$name = $_POST["name"];
	$number= $_POST["number"];
	

	$sql = "INSERT INTO contact_information (name,number)VALUES('".$name."',".$number.")";
	if(!mysqli_query($con, $sql)){
		echo '{"message":"Unable to save the data to the database."}';
	}
 
?>