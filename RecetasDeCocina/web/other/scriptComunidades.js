var postState = '';
var postCountry = '';

// State table
//
// To edit the list, just delete a line or add a line. Order is important.
// The order displayed here is the order it appears on the drop down.
//
var state = '\
AN:Almeria:Almeria|\
AN:Cadiz:Cadiz|\
AN:Cordoba:Cordoba|\
AN:Granada:Granada|\
AN:Huelva:Huelva|\
AN:Jaen:Jaen|\
AN:Malaga:Malaga|\
AN:Sevilla:Sevilla|\
AR:Huesca:Huesca|\
AR:Teruel:Teruel|\
AR:Zaragoza:Zaragoza|\
AS:Asturias:Asturias|\
BA:Baleares:Baleares|\
CA:Tenerife:Tenerife|\
CN:Cantabria:Cantabria|\
CM:Albacete:Albacete|\
CM:Ciudad Real:Ciudad Real|\
CM:Cuenca:Cuenca|\
CM:Guadalajara:Guadalajara|\
CM:Toledo:Toledo|\
CL:Avila:Avila|\
CL:Burgos:Burgos|\
CL:Leon:Leon|\
CL:Palencia:Palencia|\
CL:Salamanca:Salamanca|\
CL:Segovia:Segovia|\
CL:Soria:Soria|\
CL:Valladolid:Valladolid|\
CL:Zamora:Zamora|\
CA:Barcelona:Barcelona|\
CA:Tarragona:Tarragona|\
CA:Lleida:Lleida|\
CA:Girona:Girona|\
EX:Badajoz:Badajoz|\
EX:Caceres:Caceres|\
GA:Coruña:Coruña|\
GA:Lugo:Lugo|\
GA:Ourense:Ourense|\
GA:Pontevedra:Pontevedra|\
MA:Madrid:Madrid|\
MU:Murcia:Murcia|\
NA:Pamplona:Pamplona|\
VA:Alicante:Alicante|\
VA:Castellon:Castellon|\
VA:Valencia:Valencia|\
PV:La Rioja:La Rioja|\
PV:Guipuzcoa:Guipuzcoa|\
PV:Alava:Alava|\
PV:Vizcaya:Vizcaya|\
';

// Country data table
//
// To edit the list, just delete a line or add a line. Order is important.
// The order displayed here is the order it appears on the drop down.
//
var country = '\
AN:Andalucía|\
AR:Aragon|\
AS:Asturias|\
BA:Baleares|\
CA:Canarias|\
CN:Cantabria|\
CM:Castilla La Mancha|\
CL:Castilla y Leon|\
CA:Cataluña|\
EX:Extremadura|\
GA:Galicia|\
MA:Madrid|\
MU:Murcia|\
NA:Navarra|\
LR:La Rioja|\
VA:Comunidad Valenciana|\
PV:País Vasco|\
';

function TrimString(sInString) {
  if ( sInString ) {
    sInString = sInString.replace( /^\s+/g, "" );// strip leading
    return sInString.replace( /\s+$/g, "" );// strip trailing
  }
}

// Populates the country selected with the counties from the country list
function populateCountry(defaultCountry) {
  if ( postCountry != '' ) {
    defaultCountry = postCountry;
  }
  var countryLineArray = country.split('|');  // Split into lines
  var selObj = document.getElementById('countrySelect');
  selObj.options[0] = new Option('COMUNIDAD AUTONOMA','');
  selObj.selectedIndex = 0;
  for (var loop = 0; loop < countryLineArray.length; loop++) {
    lineArray = countryLineArray[loop].split(':');
    countryCode  = TrimString(lineArray[0]);
    countryName  = TrimString(lineArray[1]);
    if ( countryCode != '' ) {
      selObj.options[loop + 1] = new Option(countryName, countryCode);
    }
    if ( defaultCountry == countryCode ) {
      selObj.selectedIndex = loop + 1;
    }
  }
}

function populateState() {
  var selObj = document.getElementById('stateSelect');
  var foundState = false;
  // Empty options just in case new drop down is shorter
  if ( selObj.type == 'select-one' ) {
    for (var i = 0; i < selObj.options.length; i++) {
      selObj.options[i] = null;
    }
    selObj.options.length=null;
    selObj.options[0] = new Option('PROVINCIA','');
    selObj.selectedIndex = 0;
  }
  // Populate the drop down with states from the selected country
  var stateLineArray = state.split("|");  // Split into lines
  var optionCntr = 1;
  for (var loop = 0; loop < stateLineArray.length; loop++) {
    lineArray = stateLineArray[loop].split(":");
    countryCode  = TrimString(lineArray[0]);
    stateCode    = TrimString(lineArray[1]);
    stateName    = TrimString(lineArray[2]);
  if (document.getElementById('countrySelect').value == countryCode && countryCode != '' ) {
    // If it's a input element, change it to a select
      if ( selObj.type == 'text' ) {
        parentObj = document.getElementById('stateSelect').parentNode;
        parentObj.removeChild(selObj);
        var inputSel = document.createElement("SELECT");
        inputSel.setAttribute("name","state");
        inputSel.setAttribute("id","stateSelect");
        parentObj.appendChild(inputSel) ;
        selObj = document.getElementById('stateSelect');
        selObj.options[0] = new Option('PROVINCIA','');
        selObj.selectedIndex = 0;
      }
      if ( stateCode != '' ) {
        selObj.options[optionCntr] = new Option(stateName, stateCode);
      }
      // See if it's selected from a previous post
      if ( stateCode == postState && countryCode == postCountry ) {
        selObj.selectedIndex = optionCntr;
      }
      foundState = true;
      optionCntr++
    }
  }
  // If the country has no states, change the select to a text box
  if ( ! foundState ) {
    parentObj = document.getElementById('stateSelect').parentNode;
    parentObj.removeChild(selObj);
  // Create the Input Field
    var inputEl = document.createElement("INPUT");
    inputEl.setAttribute("id", "stateSelect");
    inputEl.setAttribute("type", "text");
    inputEl.setAttribute("name", "state");
    inputEl.setAttribute("size", 20);
    inputEl.setAttribute("value", postState);
    parentObj.appendChild(inputEl) ;
  }
}

function initCountry(country) {
  populateCountry(country);
  populateState();
}
