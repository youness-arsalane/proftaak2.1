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

## Algemene installatie
1. Open je console in de gewenste map waar je het project wilt installeren.
2. Typ vervolgens dit:
    - `git clone https://github.com/youness-arsalane/proftaak2.1.git`
3. Voor deze applicatie kun je gebruik maken van verschillende datasets:
    - MySQL `mappers/MySQLMapper`
    - CSV `mappers/CSVMapper`
    - Serializable Object `mappers/OBJMapper`
4. Om gebruik te maken van deze datasets, is het noodzakelijk dat je de klasse `mappers/Shapes` extend van de mapper van de dataset die je wilt gebruiken (standaard staat ingesteld op `MySQLMapper`).
    - Als je CSV of Serializable Object als dataset wilt gebruiken, ben je klaar voor gebruik!
    - Voor het instellen van een MySQL database moet je de onderstaande stappen volgen.

## MySQL installatie
1. Deze applicatie maakt gebruik van een MySQL database dus zorg dat je die beschikbaar hebt. Gebruik hier bijvoorbeeld [XAMPP](https://www.apachefriends.org/download.html) voor.
2. Als je deze connectie hebt omgezet, is het belangrijk dat je de benodigde database structuur implementeerd in je MySQL. Deze kun je vinden in de source van `java/docs/db/vat_calculator.sql`.
3. Hierna moet je je database gegevens invullen in de `MySQLMapper` klasse - deze kun je vinden in de source van `java/mappers`.
4. Tadaaa! Start de applicatie en bereken de vormen die je wilt!   
   