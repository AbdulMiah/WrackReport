// Create map and set the view with Lat and Long of Wales, 7 is zoom of map and user cannot zoom further than that
var map = L.map('map', {
    minZoom: 8
});

// Add the tile/style of the map from mapbox.com
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiYWJkdWxtaWFoIiwiYSI6ImNrbXdpN2hwZDBmM3cydXJubXM2eHoyaGQifQ.RI7Qv5cRdy1h-BRgK1NKpA'
}).addTo(map);

// Set view map view to center of Wales
map.setView([52.4307, -3.7837], 7);

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

////// Change this to get the specific report selected by admin //////
const reportIdField = document.getElementById("reportIdField").value;
console.log(reportIdField);
const reportAPI = "http://localhost:8080/api/report/"+reportIdField;
requestFromAPI(reportAPI).then((result) => {
    console.log(result)
    var marker = L.marker(result["latLong"].split(", ")).addTo(map);
    marker.bindPopup("Local Authority: "+result["localAuthority"]+"<br>Date and time reported: "+result["datetime"]+"<br>Depth of Flood (meters): "+result["depthMeters"]);
    map.flyTo(result["latLong"].split(", "), 16, {
        animate: true,
        duration: 1.5,
    });
});