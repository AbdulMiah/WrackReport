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
const reportAPI = "http://localhost:8080/api/reports";
requestFromAPI(reportAPI).then((result) => {
    console.log(result)
    const report = result[0];
    var marker = L.marker(report["latLong"].split(", ")).addTo(map);
    marker.bindPopup("Description: "+report["description"]+"<br>Date and time reported: "+report["datetime"]+"<br>Depth of Flood (meters): "+report["depthMeters"]);
    map.flyTo(report["latLong"].split(", "), 16, {
        animate: true,
        duration: 1.5,
    });
});