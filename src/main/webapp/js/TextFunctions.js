//Created By Arjun Patil on 7May2011

function trimLeadingSpaces(obj){

	if(obj != null && obj.value.length > 0){
		var objVal = obj.value;
		var blankCount = 0;
		var objValLength = objVal.length;
		for(var i=0;i<objValLength;i++){
			if(objVal.substring(i,i+1) == " "){
				blankCount++;
			}else{
				break;
			}
		}
		if(blankCount > 0){
			obj.value = objVal.substring(blankCount);
		}
	}

}

function trimLaggingSpaces(obj){

	if(obj != null && obj.value.length > 0){
		var objVal = obj.value;
		var blankCount = 0;
		var objValLength = objVal.length;
		for(var i=objValLength;i>0;i--){
			if(objVal.substring(i-1,i) == " "){
				blankCount++;
			}else{
				break;
			}
		}
		if(blankCount > 0){
			obj.value = objVal.substring(0,objValLength-blankCount);
		}
	}
}

function trimBlankSpaces(obj){
	trimLeadingSpaces(obj);
	trimLaggingSpaces(obj);
}

function validateBlankText(obj){
	var ifBlankText = true;
	alert(obj);
	if(obj != null && obj.value.length > 0){
		var objVal = obj.value;
		for(var i=0;i<objVal.length;i++){
			if(objVal.substring(i,i+1) != " "){
				ifBlankText = false;
			}
		}
		if(ifBlankText){
			obj.value="";
			obj.focus();
			return false;
		}
	}
	return true;
}



function setObjFocus(obj) {
	try {
     	 obj.focus();
     }
     catch(Exception) {
     }
}


/*
 * This function for validation codes in all masters
 */
function validateCode(obj) 
{
	var msg = obj.alt; 
	// Call for is required 
    // Call for char valdation.
    if(!checkInvalidChars(obj)) 
	    return false;
    // Call For Max Len.
    if(obj.value.length > 25) 
    {
	    alert("Maximum Length of "+msg+" should be less than or equal 25");
	    setObjFocus(obj);
	    return false;
    }   
    
    // Change To Upper field values
    var val = obj.value;
    val = val.substring(0,val.length).toUpperCase()
    obj.value = MyTrim(val);
    
    return true;
}


/*
 * This function for validation codes in all masters
 */
function validateName(obj) 
{
	
	var msg = obj.alt; 
	// Call for is required 
	
    // Call for char valdation.
    if(!checkInvalidCharsSpace(obj)){
    	return false;
    }
	
	if(!validateLengthForName(obj)){
		return false;
	}
    	
    return true;
}

function checkInvalidChars(obj)
{
    var msg = obj.alt;

    if(!checkIsNull(obj, msg))
        return false;

    var str = new String(obj.value)
    var chk = false;
        if(obj.value.length!=0)
        {
            for (i=0; i<str.length; i++)
            {
                for(j=0; j<48; j++)
                {
                    //if(j != 45 && j!= 47)
                    //{
                        if(!findInvalidChars(j, str.charAt(i)))
                        {
                            alert("Please Enter Alpha-Numeric Value For "+msg);
                            //obj.value="";
                            obj.select();
                            setObjFocus(obj);
                            return false;
                        }
                    //}
                }
                for(kk=58; kk<65; kk++)
                {
                    if(!findInvalidChars(kk, str.charAt(i)))
                    {
                        alert("Please Enter Proper Value For "+msg);
                     	obj.select();
                        setObjFocus(obj);                
                        return false;
                    }
                }
                for(k=91; k<97; k++)
                {
                    if(!findInvalidChars(k, str.charAt(i)))
                    {
                        alert("Please Enter Proper Value For "+msg);
						obj.select();
                        setObjFocus(obj);
                        return false;
                    }
                }
                for(l=123; l<256; l++)
                {
                    if(!findInvalidChars(l, str.charAt(i)))
                    {
                        alert("Please Enter Proper Value For "+msg);
                        obj.select();
                        setObjFocus(obj);
                        return false;
                    }
                }
            }
                
        }
        return true;
}

function checkValidationForPassword(obj, splitString)
{ 
    var msg = obj.alt;
	var str = new String(obj.value)
    var strPass = obj.value;
    var str1 = MyTrim(obj.value); 
    var str = new String(str1);
    var chars=0;
    var digits=0; 
	
	var minLength = splitString[0]; 
	if(minLength == "null" || minLength == "")
		minLength = 8;
		
    var maxLength = splitString[1];
    if(maxLength == "null" || maxLength == "")
    	maxLength = 25;

    var MinChars = splitString[2];
    if(MinChars == "null" || MinChars == "")
    	MinChars = 2;
    	
   var MaxChars = splitString[3];
	if(MaxChars == "null" || MaxChars == "")
	 	MaxChars = 20;
	
	 var MinDigits = splitString[4];
    if(MinDigits == "null" || MinDigits == "")
		MinDigits= 2;
		
		 	
    var MaxDigits = splitString[5];
	if(MaxDigits == "null" || MaxDigits == "")
		MaxDigits = 20;
			
	var minAllowedsspcChars = splitString[6];
	if(minAllowedsspcChars == "null" || minAllowedsspcChars == "")
		minAllowedsspcChars = 3;
		
    var maxAllowedsspcChars = splitString[7];
   	if(maxAllowedsspcChars == "null" || maxAllowedsspcChars == "")
   		maxAllowedsspcChars = 10;
   		
	var spcCount=0;

	if(!checkIsNull(obj, msg))
 		return false;
        
    if(str.length < minLength) {
        alert("Please Enter Minimum Of "+minLength+" Characters For "+msg);
        obj.value = "";
        setObjFocus(obj);
        return false
    }   
    else if(str.length > maxLength) {
        alert("Please Enter Maximum Of "+maxLength+" Characters For "+msg);
        obj.value = "";
        setObjFocus(obj);
        return false
    }
    if(obj.value.length!=0) {
	    for (i=0; i<str.length; i++) {
	         for(j=48; j<58; j++)
			 {
				if(!findInvalidChars(j, str.charAt(i))) {
				   digits=parseInt(digits)+1;     
				}                            
			 }
			for(kk=65; kk<91; kk++)
			{
				if(!findInvalidChars(kk, str.charAt(i)))
				{
					chars=parseInt(chars)+1;
				}
			}
			for(kd=97; kd<123; kd++)
			{
			  if(!findInvalidChars(kd, str.charAt(i)))
			  {
				chars=parseInt(chars)+1;
			  }
			 }
			for(j=0; j<48; j++)
	        {
				if(!findInvalidChars(j, str.charAt(i)))
				{
					spcCount=parseInt(spcCount)+1;
				}
	        }
	        for(kk=58; kk<65; kk++)
	        {
	            if(!findInvalidChars(kk, str.charAt(i)))
	            {
	               spcCount=parseInt(spcCount)+1;
	            }
	        }
	        for(k=91; k<97; k++)
	        {
	            if(!findInvalidChars(k, str.charAt(i)))
	            {
	                spcCount=parseInt(spcCount)+1;
	            }
	        }
	        for(l=123; l<256; l++)
	        {
	            if(!findInvalidChars(l, str.charAt(i)))
	            {
	                spcCount=parseInt(spcCount)+1;
	            }
	        }
	    }
	}
	
	if(parseInt(chars) < parseInt(MinChars) || parseInt(digits) < parseInt(MinDigits)) 
    {
        alert("Password Should Contain Minimum "+MinChars+" Characters And "+MinDigits+" Digits");
        obj.value="";
        setObjFocus(obj);
        return false; 
    }
    
	if(parseInt(chars) > parseInt(MaxChars) || parseInt(digits) > parseInt(MaxDigits)) 
    {
        alert("Password Should Contain Maximum "+MaxChars+" Characters And "+MaxDigits+" Digits");
        obj.value="";
        setObjFocus(obj);
        return false; 
    }
   
    if(parseInt(spcCount) < parseInt(minAllowedsspcChars) || parseInt(spcCount) > parseInt(maxAllowedsspcChars)) 

	    {
	        alert("Password Should Contain Minimum "+minAllowedsspcChars+" Special Characters And Maximum "+maxAllowedsspcChars+" Special Characters");
	        obj.value="";
	        setObjFocus(obj);
	        return false; 
	    }


    return true;
}


function findInvalidChars(asciiCode, char)
{
	if(String.fromCharCode(asciiCode) == char)
	{
		return false
	}
	else
	{
		return true
	}
}
	
function checkInvalidCharsSpace(obj)
{
    var msg = obj.alt;    
    if(!checkIsNull(obj, msg))
        return false;

    var str = new String(obj.value)
    var chk = false;
            
        if(obj.value.length!=0)
        {
            for (i=0; i<str.length; i++)
            {
                for(j=0; j<48; j++)
                {
                    if(j != 32 && j != 46 && j!= 38) // check space
                    {
                            if(!findInvalidChars(j, str.charAt(i)))
                            {                
                                alert("Please Enter Alpha-Numeric Value For "+msg);
                                obj.select();
                                setObjFocus(obj);
                                return false;
                             
                        }
                    }
                }
				if(!findInValidKeys(obj, i, str))
					return false;
            }
                
        }
        return true;
}

function checkInvalidCharsSpaceAndAllowToSpecChars(obj)
{
    var msg = obj.alt;
    if(!checkIsNull(obj, msg))
        return false;

    var str = new String(obj.value)
    var chk = false;
            
        if(obj.value.length!=0)
        {
            for (i=0; i<str.length; i++)
            {
                for(j=0; j<48; j++)
                {
                    if(j != 32 && j != 46 && j != 38 && j != 45 && j != 39) // check space
                    {
                            if(!findInvalidChars(j, str.charAt(i)))
                            {                
                                alert("Please Enter Alpha-Numeric Value For "+msg);
                                obj.select();
                                setObjFocus(obj);
                                obj.value = "";
                                return false;
                             
                        }
                    }
                }
				if(!findInValidKeys(obj, i, str))
					return false;
            }
                
        }
        return true;
}

function MyTrim(pstr){
  var tstr = new String(pstr);
  tstr = tstr.replace(/^\s*/, "");
  tstr = tstr.replace(/\s*$/, "");
  return tstr.valueOf();
}



function validateLengthForName( obj, msg) {
    
    if(obj.value.length > 50)
    {
    	var ms = obj.alt;
    	if(ms == "")
    		ms = obj.title;
    		
	    alert("Maximum Length of "+obj.alt+" should be less than or equal 50");
	    setObjFocus(obj);
	    return false;
    }
    var result = "";
    var words = obj.value.split(" ");
    var count = words.length;
    
    for(var i=0;i<count;i++)
    {
       result += parse(words[i]) + " ";
    }
    result += parse(words[i]);
    obj.value = MyTrim(result);
    
    return true;
} 


function parse(s)
{
   if(void(0)==s||""==s) return "";
   if(isNaN(parseInt(s)))
   {
      return s.charAt(0)+ s.substr(1);
   }
   else
   {
      return s;
   }
}

function checkSingleEmailValidation(emailStr){
	if (emailStr.length == 0) {
        return true;
    }
	//Addde By Mahesh To Skip the Special Charater Like % on 16 Aug 2011 
    if (emailStr.match("%")) {
    	alert("Please Enter a Valid Email Address ");
        return false;
    }
    var emailPat=/^(.+)@(.+)$/;
    var specialChars="\\(\\)@,\\\\\\\"\\.\\[\\]";
    var validChars="\[^\\s" + specialChars + "\]";
    var quotedUser="(\"[^\"]*\")";
    var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
    var atom=validChars + '+';
    var word="(" + atom + "|" + quotedUser + ")";
    var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
    var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
    var matchArray=emailStr.match(emailPat);
    if (matchArray == null) {
    		alert("Please Enter a Valid Email Address ");
        	return false;
    }
    var user=matchArray[1];
    var domain=matchArray[2];
    if (user.match(userPat) == null) {
		alert("Please Enter a Valid Email Address ");
        return false;
   }
   var IPArray = domain.match(ipDomainPat);
   if (IPArray != null) {
       for (var i = 1; i <= 4; i++) {
          if (IPArray[i] > 255) {
          		 alert("Please Enter a Valid Email Address ");
            	 return false;
          }
       }
       return true;
   }
   var domainArray=domain.match(domainPat);
   if (domainArray == null) {
		alert("Please Enter a Valid Email Address ");
        return false;
   }
   var atomPat=new RegExp(atom,"g");
   var domArr=domain.match(atomPat);
   var len=domArr.length;
   if ((domArr[domArr.length-1].length < 2) ||
       (domArr[domArr.length-1].length > 3)) {
    	 alert("Please Enter a Valid Email Address ");
         return false;
   }
   if (len < 2) {
  		alert("Please Enter a Valid Email Address ");
       	return false;
   }
   return true;
}


function amountValidation(obj, isAllowNull){
	
	if(isAllowNull == false){
		if(!checkIsNull(obj))
		  	 return false;
	}
	
	var fvalue = replaceChars(obj);
	obj.value = fvalue;
	
	if(!checkDeciNumber(obj))
			return false;

	//fvalue = setValueWithSeparator(obj);
	//obj.value = fvalue;
	//if(fvalue == "0.00")
	//	obj.value = "";
	return true;	
}


function checkDeciNumber(obj, field)
{
	field = obj.alt;
    if(((obj.value).indexOf(".") != -1)) 
    {
        var origvalue = (obj.value).substring(0,parseInt((obj.value).indexOf(".")));
        if(parseInt(origvalue) > 999999999999999)
        {
            alert("Maximum Fifteen Digits Are Allowed Before Decimal Point for "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }
        var decvalue = (obj.value).substring(parseInt((obj.value).indexOf("."))+1);
        if(parseInt(decvalue) > 99)
        {   
            alert("Maximum Two Digits Are Allowed After Decimal Point for "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }        
        if(parseFloat(obj.value) > 999999999999999.90)
        {  
            alert("Maximum 999999999999999.90 value is allowed for "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }
    }
    else
    {
        if(parseFloat(obj.value) > 999999999999999.90)
        {  
            alert("Maximum 999999999999999.90 value is allowed for "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }
    }
           
    if (isNaN(obj.value) || MyTrim(obj.value)=="")
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        obj.blur();
        setObjFocus(obj);
        return false;
    }
    if(((obj.value).indexOf("e") != -1) || ((obj.value).indexOf("E") != -1)) 
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        obj.blur();
        setObjFocus(obj);
        return false;
    }
    return true;
}

function checkPositiveDeciNumber(obj)
{
    var field = obj.alt;
    
    if (obj.value < 0)
    { 
        alert("Please Enter Positive Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }
    var str = obj.value;
    for(i=0;i<str.length;i++)
    {
        if(str.charAt(i)==' ' || str.charAt(i)== '-')
        {
            alert("Please Enter Proper Value For "+field);
            obj.value = "";
            setObjFocus(obj);
            return false;
        }
    }
    if(((obj.value).indexOf(".") != -1))   
    {
        var origvalue = (obj.value).substring(0,parseInt((obj.value).indexOf(".")));
        if(parseInt(origvalue) > 999999999999999)
        {
            alert("Maximum Fifteen Digits Are Allowed Before Decimal Point for "+field);
            obj.value = "";
            setObjFocus(obj);
            return false;
        }
        var decvalue = (obj.value).substring(parseInt((obj.value).indexOf("."))+1);
        if(parseInt(decvalue)> 99)
        {   
            alert("Maximum Two Digits Are Allowed After Decimal Point for "+field);
            obj.value = "";
            setObjFocus(obj);
            return false;
        }
        if(parseFloat(obj.value) > 999999999999999.90)
        {  
            alert("Maximum 999999999999999.90 value is allowed for "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }
    }
    else
    {
        if(parseFloat(obj.value) > 999999999999999.90)
        {  
            alert("Maximum 999999999999999.90 value is allowed for "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }
    }
           
    if (isNaN(obj.value) || MyTrim(obj.value)=="")
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }
    if(((obj.value).indexOf("e") != -1) || ((obj.value).indexOf("E") != -1)) 
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }   
    return true;
}

function checkIsNull (obj){
 
    var i;
    var whitespace = " \t\n\r";
    var msg = obj.alt;
    var str = obj.value;
      
    if ((str == null) ||(str=="") ||(str.length == 0))
    {
        alert("Please Enter "+msg);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }

    // Search through string's characters one by one
    // until we find a non-whitespace character.
    // When we do, return false; if we don't, return true.

    for (i = 0; i < str.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = str.charAt(i);

        if (whitespace.indexOf(c) == -1) 
        {
            return true;
        }
    }

    // All characters are whitespace.
    alert("Please enter "+msg);
    obj.value = "";
    setObjFocus(obj);
    return false;
}

function replaceChars(obj) {

	var entry = obj.value;
	out = ","; // replace this
	add = ""; // with this
	var temp = "" + entry; // temporary holder
	
	while (temp.indexOf(out)>-1) {
		pos= temp.indexOf(out);
		temp = "" + (temp.substring(0, pos) + add + 
		temp.substring((pos + out.length), temp.length));
	}
	
	return temp;
}

function setValueWithSeparator(obj){
	var value = obj.value;
   	var num = new NumberFormat();
   	num.setInputDecimal('.');
	num.setNumber(value); // obj.value is '1000'
	num.setPlaces('2');
	num.setCurrencyValue('$');
	num.setCurrency(false);
	num.setCurrencyPosition(num.LEFT_OUTSIDE);
	num.setNegativeFormat(num.LEFT_DASH);
	num.setNegativeRed(false);
	num.setSeparators(true, ',', ',');
	value = num.toFormatted();
	obj.value = value;
	return value;
}		


function amountValidationWithZero(obj, isAllowNull){
	
	
	if(isAllowNull == false){
		if(!checkIsNull(obj))
		  	 return false;
	}
	var fvalue = replaceChars(obj);
	obj.value = fvalue;
	
	if(!checkDeciNumber(obj))
			return false;
	
	fvalue = setValueWithSeparator(obj);
	obj.value = fvalue;
	//if(fvalue == "0.00")
		//obj.value = "";
	return true;	
}

function amountValidationWithZeroNegativeNotAllowed(obj, isAllowNull){
	
	if(isAllowNull == false){
		if(!checkIsNull(obj))
		  	 return false;
	}
	var fvalue = replaceChars(obj);
	obj.value = fvalue;
	if(!checkPositiveDeciNumber(obj))
			return false;
	
	//fvalue = setValueWithSeparator(obj);
	//obj.value = fvalue;
	//if(fvalue == "0.00")
		//obj.value = "";
	return true;	
}


function validateNameWithNumbers(obj)
{
 	var field = obj.alt;
   	if (!isNaN(obj.value) || MyTrim(obj.value)=="")
	{
        alert("Please Enter Alpha Numeric Value For "+field);
        obj.value = "";
	        obj.focus();
	        return false;
	}
    
 	if(!checkInvalidCharsSpaceAndAllowToSpecChars(obj))
		return false;
	
	return true;
    
}


function checkInvalidCharsSpaceAndAllowToSpecChars(obj)
{
    var msg = obj.alt;
    if(!checkIsNull(obj, msg))
        return false;

    var str = new String(obj.value);
    var chk = false;
            
    if(obj.value.length!=0)
    {
        for (i=0; i<str.length; i++)
        {
            for(j=0; j<48; j++)
            {
                if(j != 32 && j != 46 && j != 38 && j != 45 && j != 39) // check space
                {
                        if(!findInvalidChars(j, str.charAt(i)))
                        {                
                            alert("Please Enter Alpha-Numeric Value For "+msg);
                            obj.select();
                            setObjFocus(obj);
                            obj.value = "";
                            return false;
                         
                    }
                }
            }
			if(!findInValidKeys(obj, i, str))
				return false;
        }
            
    }
    return true;
}


function  findInValidKeys(obj, i, str) {
	
	var msg = obj.alt;
	for(kk=58; kk<65; kk++)
     {
         if(!findInvalidChars(kk, str.charAt(i)))
         {
             alert("Please Enter Proper Value For "+msg);
             obj.select();
             setObjFocus(obj);                
             return false;
         }
     }
     for(k=91; k<97; k++)
     {
         if(!findInvalidChars(k, str.charAt(i)))
         {
             alert("Please Enter Proper value for "+msg);
             obj.select();
             setObjFocus(obj);
             return false;
         }
     }
     for(l=123; l<256; l++)
     {
         if(!findInvalidChars(l, str.charAt(i)))
         {
             alert("Please Enter Proper Value For "+msg);
             obj.select();
             setObjFocus(obj);
             return false;
         }
     }
     return true;
                
}
function checkSpace(obj)
{
     var i;
     var msg = obj.alt;
     var str = MyTrim(obj.value);
     for (i = 0; i < str.length; i++)
    {   
        for(i=0;i<str.length;i++)
        {
            if(str.charAt(i)==' ')
            {
                alert("Please Enter " + msg + " Without Space");
                obj.value = "";
                setObjFocus(obj);
                return false;
            }
        }
    }
    return true;
}

function checkCombo(obj)
{   
    var msg = obj.title;
    if(msg == null || msg == "")
	   	var msg = obj.alt; 
   	 
    var str = obj.value;
    alert("str "+str);
    if(str == "" || str == "0")
    {
        setObjFocus(obj);
        alert("Please Select "+msg);
        return false;
    }
    return true;
}

function checkCheckBox(obj, msg)
{
    var count = 0;
    if (obj.length != null)
    {
        for(i=0; i<obj.length; i++)
        {
            if (obj[i].checked == true)
            {
                count++;
            }
        }
        if (count == 0)
        {
            alert("Please Select "+msg);
            return false;
        }
        return true;
    }
    else
    {
        if (!(obj.checked))
        {
            setObjFocus(obj);
            alert("Please Select "+msg);
            return false;
        }
    }
    return true;
}


function checkNum(obj, field)
{
    field = obj.alt;
    var str = obj.value;
    for(i=0;i<str.length;i++)
    {
        if(str.charAt(i)==' ')
        {
            alert("Please Enter Numeric Value For "+field);
            obj.value = "";
            obj.blur();
            setObjFocus(obj);
            return false;
        }
    }

    if (isNaN(obj.value))
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        obj.blur();
        setObjFocus(obj);
        return false;
    }

    if(((obj.value).indexOf("e") != -1) || ((obj.value).indexOf("E") != -1)) 
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        obj.blur();
        setObjFocus(obj);
        return false;
    }
    if (obj.value < 0)
    { 
        alert("Please Enter Positive Value For "+field);
        obj.value = "";
        obj.blur();
        setObjFocus(obj);
        return false;
    }
    return true;
}


function checkIntNumber(obj, field)
{
    field= obj.alt;
    if (isNaN(obj.value) || MyTrim(obj.value)=="")
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }
    if (obj.value.indexOf(".") != -1)
    { 
        alert("Please Enter whole Number for "+field);
        obj.value = "";
        setObjFocus(obj);
        return false; 
    }
    return true;
}

//To format the Integer to remove left padded zeros
function formatstring(obj) {
		 var str = obj.value;
		 var tempstr;
		 var format = "false"; 
		 if(str.length > 0) {
		 	for(var i=0;i < str.length; i++) {
		 		var indexval = str.charAt(i);
		 		if(parseInt(indexval) == 0 || indexval == " "){
		 			tempstr = str.substring(i+1,str.length);
		 			format = "true";
		 		} else {
		 			break;
		 		}
		 	}
		 }
		 
		 if(format == "true") {
		 	obj.value = tempstr;
		 }
}

function checkWholeNumber(obj)
{
    var field = obj.alt;
    
     //Added by Swapna Shetty, @date 01-Feb-2005 because isNaN() fails if space is entered before and after the number.
    var str = obj.value;
    for(i=0;i<str.length;i++)
    {
      if(str.charAt(i)==' ')
      {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
      }
    }
    if (isNaN(obj.value) || MyTrim(obj.value)=="")
    {
        alert("Please Enter Numeric Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }
    if (obj.value.indexOf(".") != -1)
    { 
        alert("Please Enter whole Number for "+field);
        obj.value = "";
        setObjFocus(obj);
        return false; 
    }
    if (obj.value <= 0)
    { 
        alert("Please Enter Positive Value For "+field);
        obj.value = "";
        setObjFocus(obj);
        return false;
    }
    return true;
}

function validateFromToDate(fromdate, tilldate, applDate)
{
	if(fromdate.disabled == false && fromdate.readOnly == false)
	{
		if(!checkDate(fromdate))
		    return false;
		var message = fromdate.alt+" Has To Be Greater Than or Equal To Application Date";
		if(!CompareDates(applDate, fromdate.value, message))
		{
			setObjFocus(fromdate);
			return false;
		}   
	}
	
	if(tilldate.value.length != 0)
    {
		if(!checkDate(tilldate))
		{
			setObjFocus(tilldate);
			return false;
		}

		var message = tilldate.alt+" Has To Be Greater Than or Equal To Effective From Date";
		if(!CompareDates(fromdate.value, tilldate.value, message))
		{
			setObjFocus(tilldate);
			return false;
		}

		message = tilldate.alt+" Has To Be Greater Than or Equal To Application Date";
		if(fromdate.disabled == true)
		{ 
			if(!CompareDates(applDate, tilldate.value, message))
			{
				setObjFocus(tilldate);
				return false;
			}			
		}
	}
	else
		tilldate.value="";
	
	if(fromdate.disabled == true)
	{
		fromdate.disabled = false;
		fromdate.readOnly = true;
	}
	
	return true;				
}	  


function validateFromToDateInReports(fromdate, todate, applDate)
	{
		if(!checkDate(fromdate)){
			setObjFocus(fromdate);
		    return false;
		}   
	
		if(!checkDate(todate))
		{
			setObjFocus(todate);
			return false;
		}

		var message = "ToDate Has To Be Greater Than From Date";
		if(!CompareDates(fromdate.value, todate.value, message))
		{
			setObjFocus(todate);
			return false;
		}

		return true;				
	}
	


function checkCombo(obj)
{   
   	var msg = obj.title; 
    var str = obj.value;
    if(str == "" || str == "0")
    {
        setObjFocus(obj);
        alert("Please Select "+msg);
        return false;
    }
    return true;
}

function checkCheckBox(obj, msg)
{
    var count = 0;
    if (obj.length != null)
    {
        for(i=0; i<obj.length; i++)
        {
            if (obj[i].checked == true)
            {
                count++;
            }
        }
        if (count == 0)
        {
            alert("Please Select "+msg);
            return false;
        }
        return true;
    }
    else
    {
        if (!(obj.checked))
        {
            setObjFocus(obj);
            alert("Please Select "+msg);
            return false;
        }
    }
    return true;
}
