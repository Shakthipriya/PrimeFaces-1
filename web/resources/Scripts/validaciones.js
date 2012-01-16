function soloNum(str) {

    patron = /[1234567890]/g;
    return patron.test(str);

}
function textSoloNum(obj) {
    var str = obj.value;
    var resp = soloNum(str);

    if (resp) {
        return true;
    } else {
        alert("Solo puede ingresar números");
        obj.value = str.slice(0, str.length - 1);
        obj.focus();
    }

}
function blockRut(obj, e, allowDecimal, allowNegative) {
    var key;
    var isCtrl = false;
    var keychar;
    var reg;

    if (window.event) {
        key = e.keyCode;
        isCtrl = window.event.ctrlKey
    }
    else if (e.which) {
        key = e.which;
        isCtrl = e.ctrlKey;
    }

    if (isNaN(key)) return true;

    keychar = String.fromCharCode(key);
    if (String(keychar).toUpperCase() == "K") {
        return true;
    }

    // check for backspace or delete, or if Ctrl was pressed
    if (key == 8 || isCtrl) {
        return true;
    }

    reg = /\d/;
    var isFirstN = allowNegative ? keychar == '-' && obj.value.indexOf('-') == -1 : false;
    var isFirstD = allowDecimal ? keychar == '.' && obj.value.indexOf('.') == -1 : false;

    return isFirstN || isFirstD || reg.test(keychar);
}
// version: beta
// created: 2005-08-30
// updated: 2005-08-31
// mredkj.com
function extractNumber(obj, decimalPlaces, allowNegative) {
    var temp = obj.value;

    // avoid changing things if already formatted correctly
    var reg0Str = '[0-9]*';
    if (decimalPlaces > 0) {
        reg0Str += '\\.?[0-9]{0,' + decimalPlaces + '}';
    } else if (decimalPlaces < 0) {
        reg0Str += '\\.?[0-9]*';
    }
    reg0Str = allowNegative ? '^-?' + reg0Str : '^' + reg0Str;
    reg0Str = reg0Str + '$';
    var reg0 = new RegExp(reg0Str);
    if (reg0.test(temp)) return true;

    // first replace all non numbers
    var reg1Str = '[^0-9' + (decimalPlaces != 0 ? '.' : '') + (allowNegative ? '-' : '') + ']';
    var reg1 = new RegExp(reg1Str, 'g');
    temp = temp.replace(reg1, '');

    if (allowNegative) {
        // replace extra negative
        var hasNegative = temp.length > 0 && temp.charAt(0) == '-';
        var reg2 = /-/g;
        temp = temp.replace(reg2, '');
        if (hasNegative) temp = '-' + temp;
    }

    if (decimalPlaces != 0) {
        var reg3 = /\./g;
        var reg3Array = reg3.exec(temp);
        if (reg3Array != null) {
            // keep only first occurrence of .
            //  and the number of places specified by decimalPlaces or the entire string if decimalPlaces < 0
            var reg3Right = temp.substring(reg3Array.index + reg3Array[0].length);
            reg3Right = reg3Right.replace(reg3, '');
            reg3Right = decimalPlaces > 0 ? reg3Right.substring(0, decimalPlaces) : reg3Right;
            temp = temp.substring(0, reg3Array.index) + '.' + reg3Right;
        }
    }

    obj.value = temp;
}
function blockNonNumbers(obj, e, allowDecimal, allowNegative) {
    var key;
    var isCtrl = false;
    var keychar;
    var reg;

    if (window.event) {
        key = e.keyCode;
        isCtrl = window.event.ctrlKey
    }
    else if (e.which) {
        key = e.which;
        isCtrl = e.ctrlKey;
    }

    if (isNaN(key)) return true;

    keychar = String.fromCharCode(key);

    // check for backspace or delete, or if Ctrl was pressed
    if (key == 8 || isCtrl) {
        return true;
    }

    reg = /\d/;
    var isFirstN = allowNegative ? keychar == '-' && obj.value.indexOf('-') == -1 : false;
    var isFirstD = allowDecimal ? keychar == '.' && obj.value.indexOf('.') == -1 : false;

    return isFirstN || isFirstD || reg.test(keychar);
}
function numerosConcecutivos(str) {

    var largo = String(str).length;
    var num;
    var respuesta = true;
    if (largo > 0) {
        for (i = 0; i < largo - 1; i++) {
            num = str.charAt(i) * 1;

            if (num + 1 != str.charAt(i + 1) * 1) {

                respuesta = false;
            }

        }
    } else {
        respuesta = false;
    }

    return respuesta;

}
function digitosRut(str, Rut) {

    var Digitos;

    if (inStr(Rut, "K") > 0 || inStr(Rut, "k") > 0) {
        Digitos = Left(Right(Rut, 5), 4);

    } else {

        Digitos = Right(Rut, 4);

    }

    if (Digitos == str) {
        alert("La clave no debe contener los últimos 4 digitos del Rut")
        return true;

    }

    Digitos = Left(Rut, 4);
    if (Digitos == str) {
        alert("La clave no debe contener los primeros 4 digitos del Rut")
        return true;

    }

    return false;

}

function numerosIguales(str) {

    var largo = String(str).length;
    var num;
    var respuesta = true;
    if (largo > 0) {
        for (i = 0; i < largo - 1; i++) {
            num = str.charAt(i);

            if (num != str.charAt(i + 1)) {
                respuesta = false;
            }

        }
    } else {
        respuesta = false;
    }
    return respuesta;

}
function Valida_Rut(Objeto) {
    var tmpstr = "";

    var intlargo = String(Objeto);




    if (intlargo.length > 0) {
        crut = Objeto
        largo = crut.length;

        for (i = 0; i < crut.length; i++)
            if (crut.charAt(i) != ' ' && crut.charAt(i) != '.' && crut.charAt(i) != '-') {
                tmpstr = tmpstr + crut.charAt(i);
            }
        rut = tmpstr;
        crut = tmpstr;
        largo = crut.length;

        if (largo > 2)
            rut = crut.substring(0, largo - 1);
        else
            rut = crut.charAt(0);

        dv = crut.charAt(largo - 1);

        if (rut == null || dv == null)
            return 0;

        var dvr = '0';
        suma = 0;
        mul = 2;

        for (i = rut.length - 1; i >= 0; i--) {
            suma = suma + rut.charAt(i) * mul;
            if (mul == 7)
                mul = 2;
            else
                mul++;
        }

        res = suma % 11;
        if (res == 1)
            dvr = 'k';
        else if (res == 0)
            dvr = '0';
        else {
            dvi = 11 - res;
            dvr = dvi + "";
        }

        if (dvr != dv.toLowerCase()) {


            return false;
        }


        return true;
    }
}
function echeck(str) {

    var at = "@"
    var dot = "."
    var lat = str.indexOf(at)
    var lstr = str.length
    var ldot = str.indexOf(dot)
    if (str.indexOf(at) == -1) {

        return false
    }

    if (str.indexOf(at) == -1 || str.indexOf(at) == 0 || str.indexOf(at) == lstr) {

        return false
    }

    if (str.indexOf(dot) == -1 || str.indexOf(dot) == 0 || str.indexOf(dot) == lstr) {

        return false
    }

    if (str.indexOf(at, (lat + 1)) != -1) {

        return false
    }

    if (str.substring(lat - 1, lat) == dot || str.substring(lat + 1, lat + 2) == dot) {

        return false
    }

    if (str.indexOf(dot, (lat + 2)) == -1) {

        return false
    }

    if (str.indexOf(" ") != -1) {

        return false
    }

    return true
}

function valRut(idObj) {
    var rut = jQuery('#' + idObj).val();
    if (!Valida_Rut(rut)) {

        jQuery('#divErrores').show();
        jQuery('#errRut').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;
    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errRut').hide();
        return true;
    }

}

function valEmail(idObj) {
    var mail = jQuery('#' + idObj).val();
    if (!echeck(mail)) {

        jQuery('#divErrores').show();
        jQuery('#pEmail').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#pEmail').hide();
        return true;
    }

}
function valPasswordLen(idP) {
    var pwrd = jQuery('#' + idP).val();
    if (String(pwrd).length < 6) {

        jQuery('#divErrores').show();
        jQuery('#pPasswordLength').show();
        jQuery('#' + idP).css('border-color', '#ff0000');
        return false;

    } else {
        jQuery('#' + idP).css('border-color', '#ffffff');
        jQuery('#pPasswordLength').hide();
        return true;
    }

}
function showErr() {
    $("#divErrores").dialog({
        width: 300,
        title: 'Errores'
    });
}
function valConfPass(idP, idC) {
    var pwrd = jQuery('#' + idP).val();
    var conf = jQuery('#' + idC).val();
    if (pwrd != conf) {
        jQuery('#divErrores').show();
        jQuery('#pPasswordConf').show();
        jQuery('#' + idP).css('border-color', '#ff0000');
        jQuery('#' + idC).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idP).css('border-color', '#ffffff');
        jQuery('#' + idC).css('border-color', '#ffffff');
        jQuery('#pPasswordConf').hide();
        return true;
    }

}
function valNombreUsuario(idObj) {
    var nombre = jQuery('#' + idObj).val();
    if (String(nombre).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#pUserName').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');

        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#pUserName').hide();
        return true;
    }

}
function valNombre(idObj) {
    var nombre = jQuery('#' + idObj).val();
    if (String(nombre).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#pName').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');

        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#pName').hide();
        return true;
    }

}
function valApellidoP(idObj) {
    var nombre = jQuery('#' + idObj).val();
    if (String(nombre).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#pLastName').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#pLastName').hide();
        return true;
    }

}
function valApellidoM(idObj) {
    var nombre = jQuery('#' + idObj).val();
    if (String(nombre).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#errApeM').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errApeM').hide();
        return true;
    }

}
function valTipo(idObj) {
    var tipo = jQuery('#' + idObj).val();
    if (String(tipo).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#errTipo').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errTipo').hide();
        return true;
    }

}
function valDireccion(idObj) {
    var Direccion = jQuery('#' + idObj).val();
    if (String(Direccion).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#errDireccion').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errDireccion').hide();
        return true;
    }

}
function valRegion(idObj) {
    var Region = jQuery('#' + idObj).val();
    if (Region * 1 == 0) {

        jQuery('#divErrores').show();
        jQuery('#errRegion').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errRegion').hide();
        return true;
    }

}
function valComuna(idObj) {
    var Comuna = jQuery('#' + idObj).val();
    if (Comuna * 1 == 0) {

        jQuery('#divErrores').show();
        jQuery('#errComuna').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errComuna').hide();
        return true;
    }

}
function valTelefono(idObj) {
    var Telefono = jQuery('#' + idObj).val();
    if (String(Telefono).length < 7) {

        jQuery('#divErrores').show();
        jQuery('#errTelefono').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errTelefono').hide();
        return true;
    }

}
function valContacto(idObj) {
    var Contacto = jQuery('#' + idObj).val();
    if (String(Contacto).length < 2) {

        jQuery('#divErrores').show();
        jQuery('#errContacto').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errContacto').hide();
        return true;
    }

}

function valFecha(idObj) {
    var fecha = jQuery('#' + idObj).val();
    if (!isDate(fecha)) {

        jQuery('#divErrores').show();
        jQuery('#errFecha').show();
        jQuery('#' + idObj).css('border-color', '#ff0000');
        return false;

    } else {

        jQuery('#' + idObj).css('border-color', '#ffffff');
        jQuery('#errFecha').hide();
        return true;
    }

}
var dtCh = "/";
var minYear = 1900;
var maxYear = 2100;

function isInteger(s) {
    var i;
    for (i = 0; i < s.length; i++) {
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag) {
    var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++) {
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary(year) {
    // February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ((!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28);
}
function DaysArray(n) {
    for (var i = 1; i <= n; i++) {
        this[i] = 31
        if (i == 4 || i == 6 || i == 9 || i == 11) { this[i] = 30 }
        if (i == 2) { this[i] = 29 }
    }
    return this
}

function isDate(dtStr) {
    var daysInMonth = DaysArray(12)
    var pos1 = dtStr.indexOf(dtCh)
    var pos2 = dtStr.indexOf(dtCh, pos1 + 1)
    var strDay = dtStr.substring(0, pos1)
    var strMonth = dtStr.substring(pos1 + 1, pos2)
    var strYear = dtStr.substring(pos2 + 1)
    strYr = strYear
    if (strDay.charAt(0) == "0" && strDay.length > 1) strDay = strDay.substring(1)
    if (strMonth.charAt(0) == "0" && strMonth.length > 1) strMonth = strMonth.substring(1)
    for (var i = 1; i <= 3; i++) {
        if (strYr.charAt(0) == "0" && strYr.length > 1) strYr = strYr.substring(1)
    }
    month = parseInt(strMonth)
    day = parseInt(strDay)
    year = parseInt(strYr)
    if (pos1 == -1 || pos2 == -1) {
        return false
    }
    if (strMonth.length < 1 || month < 1 || month > 12) {
        return false
    }
    if (strDay.length < 1 || day < 1 || day > 31 || (month == 2 && day > daysInFebruary(year)) || day > daysInMonth[month]) {
        return false
    }
    if (strYear.length != 4 || year == 0 || year < minYear || year > maxYear) {
        return false
    }
    if (dtStr.indexOf(dtCh, pos2 + 1) != -1 || isInteger(stripCharsInBag(dtStr, dtCh)) == false) {
        return false
    }
    return true
}