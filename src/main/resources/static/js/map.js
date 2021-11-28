// Create map and set the view with Lat and Long of Wales, 7 is zoom of map and user cannot zoom further than that
var map = L.map('map', {
    minZoom: 8
});

// Add the tile/style of the map from maptiler.com
L.tileLayer('https://api.maptiler.com/maps/topo/{z}/{x}/{y}.png?key=kf18TBKn7WwhY9jnWCm8', {
    attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',
}).addTo(map);

// Set view map view to center of Wales
map.setView([52.4307, -3.7837], 7);