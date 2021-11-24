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
         remainingCharsText.style.color = "black";
      };

   });

}
else{
   console.log("doesnt work")
}

function hideManualDepthEntry() {
   const value = seeManualDepthEntry.options[seeManualDepthEntry.selectedIndex].text;
   if (value == "Other" && manualDepthEntryDiv.style.display==="none") {
      manualDepthEntryDiv.style.display = "block";
   } else {
      manualDepthEntryDiv.style.display = "none";
   }
}

function lengthConverter() {
   const measureType = measurementType.options[measurementType.selectedIndex].text;
   let depthMeterField = document.getElementById('depthMeterField').value;
   let convertedValue = document.getElementById('convertedVal');
   console.log(depthMeterField);
   console.log(measureType);

      if (measureType == "Inches") {
         const cm = depthMeterField / 0.39370;
         const inchesToMeters = cm / 100;
         console.log(inchesToMeters);
         convertedValue.value=inchesToMeters;
      } else {
         const cmToMeters = depthMeterField / 100
         console.log(cmToMeters);
         convertedValue.value=cmToMeters;
      }
}
