<?php

function timeConversion($s) {
    $secctions = explode(":", $s);
    $hour = $secctions[0];
    $ampm = substr($secctions[2], -2);

    if($hour == 12){
        $hour = "00";
    }
    //converts AM to 24h
    if ($ampm == "AM"){
        return $hour . substr($s, 2, 6);
        
    //converts PM to 24h    
    } else {
        $hour = intval($hour) + 12;
        return strval($hour) . ":" . $secctions[1] . ":" . substr($secctions[2], 0, 2);
    }

}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$__fp = fopen("php://stdin", "r");

fscanf($__fp, "%[^\n]", $s);

$result = timeConversion($s);

fwrite($fptr, $result . "\n");

fclose($__fp);
fclose($fptr);
