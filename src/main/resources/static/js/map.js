// Create map and set the view with Lat and Long of Wales, 7 is zoom of map and user cannot zoom further than that
var map = L.map('map', {
    minZoom: 8
});

// Add the tile/style of the map from mapbox.com
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiYWJkdWxtaWFoIiwiYSI6ImNrbXdpN2hwZDBmM3cydXJubXM2eHoyaGQifQ.RI7Qv5cRdy1h-BRgK1NKpA'
}).addTo(map);

// Set view map view to center of Wales
map.setView([52.4307, -3.7837], 7);


// Add markers to the map from reports from reports form

// Creating a function that will request data from API and store as JSON
// Adapted From https://www.geeksforgeeks.org/how-to-use-the-javascript-fetch-api-to-get-data/
function requestFromAPI(url){
    return new Promise(async (resolve, reject) => {
        try{
            const result = await fetch(url)
            resolve(result.json())
        }catch (e){
            reject(e)
        }
    })
}

// Requesting data for reports
const reportAPI = "http://localhost:8080/api/reports";
requestFromAPI(reportAPI).then((result) => {
    console.log(result)

    result.forEach((report) => {
        var marker = L.marker(report["latLong"].split(", ")).addTo(map);
        marker.bindPopup("Description: "+report["description"]+"<br>Date and time reported: "+report["datetime"]+"<br>Depth of Flood (meters): "+report["depthMeters"]);
    })
});

// Get lat long from when user clicks on map
function setLatLongInField(latLong) {
    var field = document.getElementById("latLongField");
    var postcodeField = document.getElementById("postcodeField");
    field.setAttribute("value", latLong);
    postcodeField.setAttribute("placeholder", "Co-ordinates: "+latLong);
}

var popup = L.popup();

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("Setting your report location here")           // Create a button in the popup
        .openOn(map);

    // Remove unnecessary values from .toString
    var latLongTemp = e.latlng.toString().replace(/^\D+/g, '');         // Only get digits
    var latLong = latLongTemp.replace(/([()])/g, '');           // Remove parentheses
    setLatLongInField(latLong);
    console.log(latLong)        // Console log the latLong (testing)
}
map.on('click', onMapClick);