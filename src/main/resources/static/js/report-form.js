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
   var fileUpload1 = document.getElementById("fileUpload");

   //if no files have been added yet
   if (!document.getElementById("giveTitleElement")) {
      //Get uploaded files
      var files = fileUpload1.files;

      //validate file size and type
      var fileSizeValid = true;
      var fileTypeValid = true
      for (let i = 0; i < files.length; i++) {
         console.log("type: " + files[i].type)
         if (files[i].size / 1024 / 1024 > 150) {
            fileSizeValid = false;
         } else if (files[i].type != "image/png" && files[i].type && "image/jpeg" && "image/jpg") {
            fileTypeValid = false;
         }
      }
      if (fileSizeValid == false) {
         alert("Files must not be larger than 150mb")
         fileUpload1.setCustomValidity("Files must not be larger than 150mb");
         fileUpload1.value = null;         // Removes files
      }
      if (fileTypeValid == false) {
         alert("Files must be JPG or PNG")
         fileUpload1.setCustomValidity("Files must not be larger than 150mb");
         fileUpload1.value = null;         // Removes files
      }
      //give alert if more than 5 files uploaded
      if (files.length > 5) {
         // Alert user cannot upload more than 5 files
         alert("You can upload a maximum of 5 files");
         // Setting custom validator so user cannot submit with more than 5 files
         fileUpload1.setCustomValidity("You can upload a maximum of 5 files");
         fileUpload1.value = null;         // Removes files if more than 5 is uploaded
      } else if (fileTypeValid != false && fileSizeValid != false){
         // Reset custom validator
         fileUpload1.setCustomValidity("");
         //Create text to tell user to title files
         const fileSection = document.getElementById("fileSection");
         const giveTitle = document.createElement("p");
         giveTitle.setAttribute("id", "giveTitleElement");
         const node = document.createTextNode("Add descriptive titles to files below:");
         giveTitle.appendChild(node);
         fileSection.appendChild(giveTitle);

         //Add input boxes for each file
         for (var i = 0; i < files.length; i++) {
            var f = files[i];
            var titleInput = document.createElement("INPUT")
            titleInput.setAttribute("type", "text");
            titleInput.setAttribute("value", f.name.substring(0, f.name.lastIndexOf('.')));
            titleInput.setAttribute("id", i.toString() + "newFileNameOf");
            titleInput.setAttribute("maxlength", 30);
            titleInput.setAttribute("pattern", "^[0-9a-zA-Z_ ]+$");
            titleInput.setAttribute("title", "No special characters")
            fileSection.appendChild(titleInput);
         }

         //Create button to submit new file names
         var submitFileNames = document.createElement('input');
         submitFileNames.setAttribute('type', 'submit');
         submitFileNames.setAttribute('value', 'Submit titles');
         fileSection.appendChild(submitFileNames);

         //New file names will be added either when user clicks submit titles button or main submit button
         submitFileNames.onclick = updateFiles;
         var finalSubmit = document.getElementById("finalSubmit")
         finalSubmit.onclick = updateFiles;
      }
   //   If files have already been added remove all input boxes and call function again to get the new files
   } else {
      //remove all children from an element
      //taken from https://developer.mozilla.org/en-US/docs/Web/API/Node/removeChild
      let element = document.getElementById("fileSection");
      while (element.firstChild) {
         element.removeChild(element.firstChild);
      }
      //end of reference
      listFiles();
   }

}

function updateFiles() {
   //Add renamed files to hidden html element that will get submitted
   //adapted from https://stackoverflow.com/a/56447852/14457259
   //Create new list of files
   console.log("updating files")
   let newFiles = new DataTransfer();
   var files = fileUpload.files;
   var valid = true;

   //Don't go to next section if regexp doesn't match
   for (let i = 0; i < 5; i++) {
      if (document.getElementById(i + "newFileNameOf")) {
         var enteredFileName = document.getElementById(i + "newFileNameOf").value
         var re = new RegExp("^[0-9a-zA-Z_ ]+$");
         if (! re.test(enteredFileName)) {
            valid = false;
         }
      }
   }

   if (valid == true) {
      //Get new name of file and create copy with new name
      for (let i = 0; i < 5; i++) {
         if (document.getElementById(i + "newFileNameOf")) {
            var enteredFileName = document.getElementById(i + "newFileNameOf").value
            var currentFileName = files[i].name
            var fileExt = currentFileName.split('.').pop();
            const renamedFile = new File([files[i]], enteredFileName + "." + fileExt);
            newFiles.items.add(renamedFile);
         }
      }

      var submissionElement = document.getElementById("fileUploadToSubmit");
      let myFileList = newFiles.files;
      submissionElement.files = myFileList;
      // end of reference
      document.getElementById("namesUpdated").innerText = "Names Updated";
   }



}
