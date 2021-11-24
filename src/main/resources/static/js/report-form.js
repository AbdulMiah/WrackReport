const description = document.getElementById('description');
const remainingCharsText = document.getElementById('remaining-chars');
const seeManualDepthEntry = document.getElementById('seeManualDepthEntry');
const manualDepthEntryDiv = document.getElementById('manualDepthEntry');
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
   var value = seeManualDepthEntry.options[seeManualDepthEntry.selectedIndex].text;
   if (value == "Other" && manualDepthEntryDiv.style.display==="none") {
      manualDepthEntryDiv.style.display = "block";
   } else {
      manualDepthEntryDiv.style.display = "none";
   }
}
