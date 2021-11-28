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
async function requestFromAPI(url){
    const result = await fetch(url);
    let data = await result.json();
    if(data){
        return data;
    }
}

// Requesting data for reports
const reportAPI = "http://localhost:8080/api/reports";
var reportsList = requestFromAPI(reportAPI);
console.log(reportsList);

// Get lat long from when user clicks on map
var popup = L.popup();
var latLong = "";

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("Do you want to place a report here?" + '<br><hr><button type="button" class="btn btn-primary btn-sm">Choose this location</button>')           // Create a button in the popup
        .openOn(map);

    // Remove unnecessary values from .toString
    var latLongTemp = e.latlng.toString().replace(/^\D+/g, '');         // Only get digits
    latLong = latLongTemp.replace(/([()])/g, '');           // Remove parentheses
    var latLngSplit = latLong.split(", ");
    var lat = latLngSplit[0];
    var long = latLngSplit[1];
    console.log(lat.concat(", "+long));       // Console log the latLong (testing)
}

map.on('click', onMapClick);