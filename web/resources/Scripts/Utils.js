//Funciones para manejo de strings
//Andrés Santa María Norero
function formatNumber(num,prefix){
prefix = prefix || '';
num += '';
var splitStr = num.split('.');
var splitLeft = splitStr[0];
var splitRight = splitStr.length > 1 ? '.' + splitStr[1] :'';
var regx = /(\d+)(\d{3})/;
while (regx.test(splitLeft)) {
splitLeft = splitLeft.replace(regx, '$1' + '.' + '$2');
}
return prefix + splitLeft + splitRight;
}
function unformatNumber(num) {
return num.replace(/([^0-9\,\-])/g,'')*1;
}
function showHistorial(idUgc){
var obj = {
            IdUgc: idUgc
        };
        jQuery.ajax({
            type: "POST",
            url: dir + "/Common/getComments",
            contentType: "application/json; charset=utf-8",
            data: $.toJSON(obj),
            dataType: "json",
            success: function (msg) {

                


            }, error: AjaxFailed
        });
var $dialogHistorial = $("<div></div>")
                .dialog({
                    autoOpen: true,
                    width: 500,
                    height: 800
                });
}
function getJSONDate(str) {

        var menos = inStr(str,'-');
        
        var n = parseInt(str.replace(/[/\Date()]/gi, ''));
        if(menos>0){
            var d = new Date(-n);
        }else{
            var d = new Date(n);
        }
        var mes = d.getMonth()*1+1;
        var dia = d.getDay()*1;
        dia =right("00"+dia,2);
        mes= right("00"+mes,2);
        return  dia + "/" + mes + "/" + d.getFullYear();
    }

function left(str, n){
    if (n <= 0){
        return "";
    }else{
		if (n > String(str).length){
			return str;
		}else{
			return String(str).substring(0,n);
		}
	}
}	

function right(str, n){
    if (n <= 0){
       return "";
    }else{
		if (n > String(str).length){
		   return str;
		}else {
		   var iLen = String(str).length;
		   return String(str).substring(iLen, iLen - n);
		}
	}
}

function inStr(str, character){

return String(str).indexOf(character);

}

function mid(str, first, last){
	if (last > String(str).length){
		last = String(str).length;
	}
	if (first <= 0){
		   return "";
	}else{
		return String(str).substring(first*1,last*1);
		}
}
function difDates(date1,date2) {
    
 
    //assuming that the delimiter for dt time picker is a '/'.
    var x = String(date1);
    var y = String(date2);
    var arr1 = x.split('/');
    var arr2 = y.split('/');
 
    // If any problem with input exists, return with an error msg
    if(!arr1 || !arr2 || arr1.length != 3 || arr2.length != 3) {
            return;
    }
 
    var dt1 = new Date();
    var month1=0;
    var month2=0;
    if (arr1[1]>0){
        month1=arr1[1]-1;
    }
    if (arr2[1]>0){
        month2=arr2[1]-1;
    }

    dt1.setFullYear(arr1[2], month1, arr1[0]);
    var dt2 = new Date();
    dt2.setFullYear(arr2[2], month2, arr2[0]);
 
    return (dt2.getTime() - dt1.getTime()) / (60 * 60 * 24 * 1000);
  }
//Suma y resta de horas
 function padNmb(nStr, nLen) {
            var sRes = String(nStr);
            var sCeros = "0000000000";
            return sCeros.substr(0, nLen - sRes.length) + sRes;
        }

        function stringToSeconds(tiempo) {
            
            var sep1 = String(tiempo).indexOf(":");
            var sep2 = String(tiempo).lastIndexOf(":");
            var hor = String(tiempo).substr(0, sep1);
            var min = String(tiempo).substr(sep1 + 1, sep2 - sep1 - 1);
            var sec = String(tiempo).substr(sep2 + 1);
            return (Number(sec) + (Number(min) * 60) + (Number(hor) * 3600));
        }

        function secondsToTime(secs) {
            var hor = Math.floor(secs / 3600);
            var min = Math.floor((secs - (hor * 3600)) / 60);
            var sec = secs - (hor * 3600) - (min * 60);
            return padNmb(hor, 2) + ":" + padNmb(min, 2) + ":" + padNmb(sec, 2);
        }

        function substractTimes(t1, t2) {
            var secs1 = stringToSeconds(t1);
            var secs2 = stringToSeconds(t2);
            var secsDif = secs1 - secs2;
        
            return secondsToTime(secsDif);
        }
        function addTimes(t1, t2) {
            var secs1 = stringToSeconds(t1);
            var secs2 = stringToSeconds(t2);
            var secsDif = secs1 + secs2;
            return secondsToTime(secsDif);
        }

        function formatRut(str){
           var dig = right(str,1);
           var rut = left(str,String(str).length-1);
           if(rut!="" && dig !=""){
            return formatNumber(rut) + "-" + String(dig).toUpperCase();
           }else{
            return "";
           }

        }