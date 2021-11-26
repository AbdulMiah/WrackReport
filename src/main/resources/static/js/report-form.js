const description = document.getElementById('description');
const remainingCharsText = document.getElementById('remaining-chars');
const seeManualDepthEntry = document.getElementById('seeManualDepthEntry');
const manualDepthEntryDiv = document.getElementById('manualDepthEntry');
const measurementType = document.getElementById('measurementType');

const MAX_Chars = 2500;

if(description != null){

   description.addEventListener('input',() => {

      const remaining = MAX_Chars - description.value.length;
      remainingCharsText.textContent = `${remaining} Characters Remaining`
      if (remaining < 0){
         remainingCharsText.style.color = "red";
      };
      if (remaining >= 0){
         remainingCharsText.style.color = "white";
      };

   });

}
else{
   console.log("doesnt work")
}

function hideManualDepthEntry() {
   // Get the selected value from depth category
   const value = seeManualDepthEntry.options[seeManualDepthEntry.selectedIndex].text;

   // If the user chose 'Other' and the input field for manual entry is invisible
   if (value == "Other" && manualDepthEntryDiv.style.display==="none") {
      manualDepthEntryDiv.style.display = "block";          // Display this div block
      // Set the field to 'required'
      document.getElementById('depthMeterField').setAttribute("required", '');
   } else {
      manualDepthEntryDiv.style.display = "none";           // Otherwise, hide the input field
   }
}

function lengthConverter() {
   // Get the selected value from measurement type
   const measureType = measurementType.options[measurementType.selectedIndex].text;
   let depthMeterField = document.getElementById('depthMeterField').value;       // Get value from input field
   let convertedValue = document.getElementById('convertedVal');
   console.log(depthMeterField);
   console.log(measureType);

   // If user chose measurement type 'inches'
      if (measureType == "Inches") {
         const cm = depthMeterField / 0.39370;     // Do conversion from inches centimeters
         const inchesToMeters = cm / 100;          // Do conversion from centimeters to meters
         console.log("Inches to meters: "+inchesToMeters);

         if (inchesToMeters > 10) {
            document.getElementById('depthMeterField').setCustomValidity("Cannot enter more than 393.701 inches");
         } else if(inchesToMeters<=10) {
            document.getElementById('depthMeterField').setCustomValidity("");       // Reset custom validity
            convertedValue.value=inchesToMeters;      // Set the new input field value to converted value
         }
      } else {
         const cmToMeters = depthMeterField / 100  // Do conversion from centimeters to meters
         console.log("cm to meters: "+cmToMeters);

         if (cmToMeters > 10) {
            document.getElementById('depthMeterField').setCustomValidity("Cannot enter more than 1000 centimeters");
         } else if(cmToMeters<=10) {
            document.getElementById('depthMeterField').setCustomValidity("");       // Reset custom validity
            convertedValue.value=cmToMeters;          // Set the new input field value to converted value
         }
      }
}
