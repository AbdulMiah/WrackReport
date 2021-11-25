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
   var files = fileUpload.files;
   const giveTitle = document.createElement("p");
   const node = document.createTextNode("Add descriptive titles to files below");
   giveTitle.appendChild(node);
   fileSection.appendChild(giveTitle);
   for (var i=0; i < files.length; i++) {
      var f = files[i];
      console.log(f.name);
      const fileSection = document.getElementById("fileSection");
      var titleInput = document.createElement("INPUT")
      titleInput.setAttribute("type", "text");
      titleInput.setAttribute("value", f.name.substring(0, f.name.lastIndexOf('.')));
      titleInput.setAttribute("id", i.toString() +"newFileNameOf");
      fileSection.appendChild(titleInput);
   }
   var submitFileNames = document.createElement('input');
   submitFileNames.setAttribute('type' , 'button');
   submitFileNames.setAttribute('value', 'Submit new names');
   fileSection.appendChild(submitFileNames);
   submitFileNames.onclick = updateFiles;
}

function updateFiles() {
   let newFiles = new DataTransfer();
   var files = fileUpload.files;
   for (let i = 0; i < 10; i++) {
      if (document.getElementById(i + "newFileNameOf")) {
         var enteredFileName = document.getElementById(i + "newFileNameOf").value
         var currentFileName = files[i].name
         var fileExt = currentFileName.split('.').pop();
         console.log("entered file name " + enteredFileName)
         console.log("current file name " + currentFileName);
         const renamedFile = new File([files[i]], enteredFileName + "." + fileExt);
         newFiles.items.add(renamedFile);
      }
   }
   console.log(newFiles);
   var submissionElement = document.getElementById("fileUploadToSubmit");
   let myFileList = newFiles.files;
   submissionElement.files = myFileList;

   // var names = (document.querySelectorAll("[id*='newFileNameOf']"));
   // for (let i = 0; i < names.length; i++) {
   //    console.log(names[i]);
   //    console.log(names[i].getAttribute("value"));
   //    console.log("file name: " + files[i].name);
   // }
}
