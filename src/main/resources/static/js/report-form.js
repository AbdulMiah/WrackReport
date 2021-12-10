console.log("script loaded")
const description = document.getElementById('description');
const remainingCharsText = document.getElementById('remaining-chars');
const seeManualDepthEntry = document.getElementById('seeManualDepthEntry');
const manualDepthEntryDiv = document.getElementById('manualDepthEntry');
const measurementType = document.getElementById('measurementType');
var latLongField = document.getElementById("latLongField");
var postcodeField = document.getElementById("postcodeField");

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

// Adapted from https://www.w3schools.com/html/html5_geolocation.asp
function getGPSLocation() {
   if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(showPosition, showError);
   } else {
      console.log("Geolocation is not supported by this browser.");
   }
}

// Adds latLong retrieved from GPS into the latLong field in report form
function showPosition(position) {
   latLongGPS = position.coords.latitude + ", " + position.coords.longitude;
   latLongField.value = latLongGPS;
   // Change placeholder of postcode field to let user know coords retrieved from GPS
   postcodeField.setAttribute("placeholder", "Your current location: "+latLongGPS);

   // Zoom into current location on map
   map.flyTo([position.coords.latitude, position.coords.longitude], 16, {
      animate: true,
      duration: 1.5
   });

   // Let user know report location is being set here
   var popup = L.popup()
       .setLatLng([position.coords.latitude, position.coords.longitude])
       .setContent("Setting location of your report here")
       .openOn(map);

   // Get local authority from current location
   const opencageAPI = "https://api.opencagedata.com/geocode/v1/json?key=e0e009282aec4b119ca5cd7d25c7c20d&q="+position.coords.latitude+"%2C+"+position.coords.longitude+"&pretty=1&no_annotations=1";
   requestFromAPI(opencageAPI).then((apiData) => {
      console.log(apiData);
      var results = apiData["results"];
      var firstResult = results[0];
      var components = firstResult["components"]
      const localAuthField = document.getElementById("localAuthField");
      const localAuthority = components["county"];
      localAuthField.value = localAuthority;          // Set value of field to local authority from API
   });

}

// Error handling for geolocation
function showError(error) {
   var x = document.getElementById("gpsErrors");
   switch(error.code) {
      case error.PERMISSION_DENIED:
         x.innerHTML = "You denied the request for Geolocation. Go to permission settings and 'Allow' us to use your location."
         break;
      case error.POSITION_UNAVAILABLE:
         x.innerHTML = "Location information is unavailable."
         break;
      case error.TIMEOUT:
         x.innerHTML = "The request to get user location timed out."
         break;
      case error.UNKNOWN_ERROR:
         x.innerHTML = "An unknown error occurred."
         break;
   }
}

// Does conversion on submit
var finalSubmitButton = document.getElementById("finalSubmit")
finalSubmitButton.onclick = convertDepthMeters;

// Create function for cm to meter conversion from dropdown menu
function convertDepthMeters() {
   const value = seeManualDepthEntry.options[seeManualDepthEntry.selectedIndex].text;
   let convertedValue = document.getElementById('convertedVal');

   if (value.includes("cm")) {
      var removedCm = value.replace("cm", "");
      const cmToMeters = removedCm / 100  // Do conversion from centimeters to meters
      convertedValue.value=cmToMeters;
   } else if(value.includes("m")) {
      var removedM = value.replace("m", "");
      convertedValue.value=removedM;
   } else {
      console.log("Error. Cannot convert depth category")
   }
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
      var fileTypeValid = true;
      var validImgTypes = ["image/png", "image/jpg", "image/jpeg"]
      var validVideoTypes = ["video/mp4", "video/quicktime", "video/x-matroska"];
      for (let i = 0; i < files.length; i++) {
         console.log("file: " + files[i])
         console.log("type: " + files[i].type)
         if (files[i].size / 1024 / 1024 > 150) {
            fileSizeValid = false;
         } else if (!validImgTypes.includes(files[i].type) && !validVideoTypes.includes(files[i].type)) {
            fileTypeValid = false;
         }
      }
      if (fileSizeValid == false) {
         alert("Files must not be larger than 150mb")
         fileUpload1.setCustomValidity("Files must not be larger than 150mb");
         fileUpload1.value = null;         // Removes files
      }
      if (fileTypeValid == false) {
         alert("Files must be JPG, PNG, MP4, MOV, or MKV")
         fileUpload1.setCustomValidity("Files must not be larger than 150MB");
         fileUpload1.value = null;         // Removes files
      }
      //give alert if more than 5 files uploaded
      if (files.length > 5) {
         // Alert user cannot upload more than 5 files
         alert("You can upload a maximum of 5 files");
         // Setting custom validator so user cannot submit with more than 5 files
         fileUpload1.setCustomValidity("You can upload a maximum of 5 files");
         fileUpload1.value = null;         // Removes files if more than 5 is uploaded
         //continue if all validations pass
      } else if (fileTypeValid != false && fileSizeValid != false){
         //==Oliver Hardman==
         //Get metadata from image to determine location
         ExifReader.load(document.getElementById("fileUpload").files[0]).then((tags) => {
            if(Object.keys(tags).includes("GPSLatitude")){
               console.log(JSON.stringify(tags))
               var latitude = tags['GPSLatitude'].description
               if(tags['GPSLatitudeRef'].description == "South latitude"){
                  latitude = latitude * -1
               }

               var longitude = tags['GPSLongitude'].description
               if(tags['GPSLongitudeRef'].description == "West longitude"){
                  longitude = longitude * -1
               }

               var latLongGPS = latitude + ", " + longitude
               console.log("QUAL: " + latLongGPS)
               latLongField.value = latLongGPS;
               // Change placeholder of postcode field to let user know coords retrieved from GPS
               postcodeField.setAttribute("placeholder", "Location from your photo: "+latLongGPS);

               // Zoom into current location on map
               map.flyTo([latitude, longitude], 16, {
                  animate: true,
                  duration: 1.5
               });

               // Let user know report location is being set here
               var popup = L.popup()
                   .setLatLng([latitude, longitude])
                   .setContent("Setting location of your report here")
                   .openOn(map);
            }
         }).catch((err) => {console.error(err)})

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
            var gridSection = document.getElementById("preview" + i.toString());

            if (validImgTypes.includes(f.type)) {
               //image preview
               //Reference create preview from image
               //Taken from https://stackoverflow.com/a/4459419/14457259
               var imgPreview =document.createElement("IMG");
               imgPreview.setAttribute("id", i.toString() + "imgPreview");
               imgPreview.setAttribute("src", URL.createObjectURL(f));
               imgPreview.setAttribute("class", "img-fluid mx-auto d-block center-block rounded")
               //End of reference
               //Add preview to bootstrap grid
               gridSection.appendChild(imgPreview);
            } else if (validVideoTypes.includes(f.type)) {
               //video preview
               var videoPreview = document.createElement("video");
               videoPreview.setAttribute("controls", "true");
               videoPreview.innerHTML = "Your browser does not support this video";
               videoPreview.setAttribute("src", URL.createObjectURL(f));
               videoPreview.setAttribute("class", "center-block embed-responsive")
               gridSection.appendChild(videoPreview);
            }


            var titleInput = document.createElement("INPUT")
            titleInput.setAttribute("type", "text");
            titleInput.setAttribute("class", "form-control mx-auto m-2");
            titleInput.setAttribute("value", f.name.substring(0, f.name.lastIndexOf('.')));
            titleInput.setAttribute("id", i.toString() + "newFileNameOf");
            titleInput.setAttribute("maxlength", 30);
            titleInput.setAttribute("pattern", "^[0-9a-zA-Z_ ]+$");
            titleInput.setAttribute("title", "No special characters")
            gridSection.appendChild(titleInput);
         }

         document.getElementById('finalSubmit').addEventListener('click', function(){
            convertDepthMeters();
            updateFiles();
         });
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

      //Remove content from bootstrap grid of previews
      for (let i = 0; i < 5; i++) {
         document.getElementById("preview"+i.toString()).innerHTML='';
      }
      listFiles();
   }

}

function updateFiles() {
   //Add renamed files to hidden html element that will get submitted
   //adapted from https://stackoverflow.com/a/56447852/14457259
   //Create new list of files
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
   }



}
