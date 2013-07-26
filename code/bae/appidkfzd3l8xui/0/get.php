<?php
$name = $_GET['name'];
if (empty($name)) {
	echo "Args Error";
}else{
	echo "Hello ".$name;
}