# DATS2300AlgortimerOgDatastrukturer-Kildekode
Alle kildekodene til video forelesningene som vi har gjennomgått i faget ligger i dette repo-et.

## Uke 36 - Søking og sortering

### Quicksort
Quicksort er en rekursiv sorteringsalgoritme hvor vi sorterer ett tall for hver iterasjon. Men til forskjell fra f.eks. selection sort (finn største tall og legg bakerst, finn nest største tall og legg nest bakerst, etc.) så sorterer vi ett tilfeldig tall. Hele hovedpoenget er at vi bruker det at dersom et tall er sortert, så er alle tall til høyre for tallet like stort eller større, og alle tall til venstre er mindre. Det finnes mange strategier for å finne beste pivot-verdi, men vi bruker siste i listen i denne videoen.

### Insertion sort
Insertion sort går ut på å sette inn et tall i en sortert liste.

### Merge sort
Flettesortering - eller merge sort - brukes for å rekursivt slå sammen to sorterte tabeller til en felles sortert tabell

### Bubble sort
Hele idéen bak boblesortering er å sortere ett tall om gangen - det største. Det gjør man ved å gå fra "bunnen" av listen til "toppen", og hele tiden ta med seg det største tallet oppover.


## Uke 37 - Generics og javateknisk

### Ternary if
Ternary if er en helt vanlig if-setning skrevet på en litt annen måte. Det er en kraftig teknikk, men kan også veldig lett missbrukes og dermed lage svært uleselig kildekode. Bruk varsomt.

### Generics

Generics er en måte for Java å kunne bruke samme kildekode for følgende metoder:

- int maks(Character[] values)
- int maks(Integer[] values)
- int maks(Person[] values)

Dette gjør at du slipper kopiere bugs og kildekode - skriv metoden kun én gang og bruk den for mange forskjellige datatyper. Vi går gjennom interfacet Comparable som lover at en klasse har compareTo-funksjonen, og hvordan dette da brukes til å lage en generisk maks-metode som fungerer for alle eksemplene over.


## Uke 38 - Rekursjon og flerdimensjonelle tabeller

### Rekursiv n! (n fakultet)

I en for-løkke kan vi enkelt regne det ut som følger:

```
int n_fakultet=1;
for (int i=2; i<n; ++i) {
n_fakultet = n_fakultet*n;
}
```

Dette gir da f.eks 5! = 1 * 2 * 3 * 4 * 5 = 120, og er utregnet på en tradisjonell iterativ måte.

### Rekursive permutasjoner

Hele essensen er at vi tar inn en tallrekke, f.eks 1, 2, 3. Så  ser vi på hvordan vi kan systematisk permutere denne tallrekkefølgen.


## Uke 39 - Lenkede lister

### Lenkede lister
Lenkede lister er på akkurat samme måte som arrays en måte å lagre data på. På samme måte som vi kan lage et array

```
int[] values = ...
```

kan vi også lage en lenket liste

```
LinkedList values = ...
```

og bruke dem på liknende måter. Fordelen med et array er at det er veldig raskt å indeksere (en addisjon og en multiplikasjon - se videoen om datamaskinarkitektur hvor jeg går gjennom hvordan arrays fungerer). Ulempen er at vi på forhånd må vite nøyaktig hvor stort arrayet skal være. Vi kan ikke endre størrelse uten å kopiere hele arrayet. Det er nettopp dette en lenket liste fikser: vi kan med en lenket liste starte med 0 elementer, og så utvide med nøyaktig så mange elementer vi ønsker, helt til datamaskinen er tom for minne.

### Dobbelt lenket liste
Fordelen med en dobbelt lenket liste er at det er lett å legge til og fjerne noder både foran og bak, men en ulempe er at den krever en god del mer kildekode og en god del mer lagringsplass (trenger både next og previous peker for å lagre én verdi, value).


## Uke 41 - Stack, kø, deque, prioritetskø

### Forskjellige typer køer
FIFO, LIFO, og deque. En FIFO-kø står for first in first out (vanlig kø), LIFO står for last in first out (stack, eller stabbel med tallerkner), og en deque (uttales deck) står for double ended queue.


## Uke 42 - Binære trær

### Egenskaper ved binære trær
Et fullt tre har hver node null eller to barn, mens et komplett tre har alle nivåer fylt opp bortsett fra siste (som er fylt inn fra venstre).


## Uke 43 - Binære søketrær

### Binære søketrær
Hvordan vi lager binære søketrær basert på de forskjellige ordningene av de samme tallene gir veldig forskjellige sæketrær, og det har mye å si for effektiviteten. De mest effektive trærne har få nivåer, og de mest ineffektive har veldig mange nivåer i forhold til antall noder.

### Fjerning av node fra binært søketre
Måten å fjerne en node fra et binært søketre er avhengig av om noden vi skal fjerne har null, ett eller to barn. Null og ett barn kan løses veldig likt som man gjør i en dobbelt lenket liste, mens to barn krever mer tankearbeide.


## Uke 44 - Heaper og Huffmantrær

### Heap datatstruktur
Et minimumstre har alle foreldrenoder mindre eller lik verdi som sine barnenoder. En minimumsheap er i tillegg ett komplett tre. Dette gjør at vi enkelt kan lagre det som et array ved å bruke node-id som index i arrayet. 
