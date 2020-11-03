# ELU2.1-Objectorientatie met Java - 1
###### Made by _Youness Arsalane_

## Klasse eigenschappen
- Dit is de Vorm Analyse Tool (VAT) - een handige tool voor het berekenen van de inhoud van bepaalde vormen.
- Je kunt vormen berekenen zoals
    - Blokken
    - Cylinders
    - Bollen
    - Kegels
    - Pyramides
- Ook kun je van alle vormen de totale inhoud berekenen.
- De tool is flexibel ingericht waardoor je makkelijk van dataset kan wisselen. Op dit moment is alleen MySQL beschikbaar.

## Waarom wij?
Vorm Analyse Tool is uitgegroeid van een klein bedijfje die zich bezig hield met de inhoud van vormen, tot aan één van de best geleverde GRATIS software op de markt omtrent vormen berekeningen. Er worden maandelijks nieuwe features gereleased (en uiteraard uitbundig getest), om u de beste ervaring te kunnen geven.

## Installatie
1. Open je console in de gewenste map waar je het project wilt installeren.
2. Type vervolgens dit:
    - `git clone https://github.com/dominiquetoonen/AVANS-ELU-2.1-VORMANALYSETOOL.git`
3. Deze applicatie maakt gebruik van een MySQL database dus zorg dat je die beschikbaar hebt. Gebruik hier bijvoorbeeld [XAMPP](https://www.apachefriends.org/download.html) voor.
4. Als je deze connectie hebt omgezet, is het belangrijk dat je de benodigde database structuur implementeerd in je MySQL. Deze kun je vinden in de source van `java/docs/db/vat_calculator.sql`.
5. Hierna moet je je database gegevens invullen in de `MySQLMapper` klasse - deze kun je vinden in de source van `java/mappers`.
5. Tadaaa! Start de applicatie en bereken de vormen die je wilt!   
   