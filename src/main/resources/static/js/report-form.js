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
      var fileName = f.name;
      var fileExt = fileName.split(".")
      const fileSection = document.getElementById("fileSection");
      var titleInput = document.createElement("INPUT")
      titleInput.setAttribute("type", "text");
      titleInput.setAttribute("value", f.name.substring(0, f.name.lastIndexOf('.')));
      fileSection.appendChild(titleInput);
      var submitFileNames = document.createElement('input');
      submitFileNames.setAttribute('type' , 'button');
      submitFileNames.setAttribute('value', 'Submit new names');
      fileSection.appendChild(submitFileNames);
      btn.addEventListener("click", "updateFiles");
   }
}

function updateFiles() {
   alert("updating files")
}
