console.log("script loaded")
const description = document.getElementById('description');
const remainingCharsText = document.getElementById('remaining-chars');
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

//File upload script
var fileUpload = document.getElementById("fileUpload");
function listFiles() {
   //Get uploaded files
   var files = fileUpload.files;
   //Create elements to title files
   const giveTitle = document.createElement("p");
   const node = document.createTextNode("Add descriptive titles to files below");
   giveTitle.appendChild(node);
   fileSection.appendChild(giveTitle);
   for (var i=0; i < files.length; i++) {
      var f = files[i];
      const fileSection = document.getElementById("fileSection");
      var titleInput = document.createElement("INPUT")
      titleInput.setAttribute("type", "text");
      titleInput.setAttribute("value", f.name.substring(0, f.name.lastIndexOf('.')));
      titleInput.setAttribute("id", i.toString() +"newFileNameOf");
      fileSection.appendChild(titleInput);
   }
   //Create button to submit new file names
   var submitFileNames = document.createElement('input');
   submitFileNames.setAttribute('type' , 'button');
   submitFileNames.setAttribute('value', 'Submit titles');
   fileSection.appendChild(submitFileNames);
   //New file names will be added either when user clicks submit titles button or main submit button
   submitFileNames.onclick = updateFiles;
   var finalSubmit = document.getElementById("finalSubmit")
   finalSubmit.onclick = updateFiles;
}

function updateFiles() {
   //Create new list of files
   let newFiles = new DataTransfer();
   var files = fileUpload.files;
   //Get new name of file and create copy with new name
   for (let i = 0; i < 10; i++) {
      if (document.getElementById(i + "newFileNameOf")) {
         var enteredFileName = document.getElementById(i + "newFileNameOf").value
         var currentFileName = files[i].name
         var fileExt = currentFileName.split('.').pop();
         const renamedFile = new File([files[i]], enteredFileName + "." + fileExt);
         newFiles.items.add(renamedFile);
      }
   }
   //Add renamed files to hidden html element that will get submitted
   var submissionElement = document.getElementById("fileUploadToSubmit");
   let myFileList = newFiles.files;
   submissionElement.files = myFileList;

}
