window.addEventListener("load", inici, false);

function inici() {


    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            lecturaXML(this);
        }
    };
    xhttp.open("GET", "./xml/excursions.xml", true);
    xhttp.send();
}



function lecturaXML(xml) {

    var xmlDoc = xml.responseXML;

    var seccio = document.getElementsByTagName("section")[0];

    for (var i = 0; i < xmlDoc.getElementsByTagName("excursio").length; i++) {

        nom = xmlDoc.getElementsByTagName("nom")[i].childNodes[0].nodeValue;

        ciutat = xmlDoc.getElementsByTagName("ciutat")[i].childNodes[0].nodeValue;

        preu = xmlDoc.getElementsByTagName("preu")[i].childNodes[0].nodeValue;

        imatge = xmlDoc.getElementsByTagName("imatge")[i].childNodes[0].nodeValue;






        seccio.innerHTML += "<div class='maleta'>" +
            "<img src= './img/" + imatge + "'alt='imatge'/>" +
            "<div class='dades'>" +
            "<h2>" + nom + "</h2>" +
            "<h3>" + ciutat + "</h3>" +
            "<p>" + preu + "</p>" +
            "</div>" +
            "<a href = '#' class='compra'>Reservar</a>" +
            "</div>";

    }

}
