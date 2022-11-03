package Uke41_StackKøDequePrioritetskø;

public class CircularBuffer {
    char[] buffer;
    int size;

    // Vi må ha en begin over end-peker. 20 elementer totalt i bufferet, vi trenger ikke å fylle opp alt.
    // Vi kan ha 0 elementer eller 2-3 elementer, men opp til 20 elementer.
    int head;   // Peker til starten av køen
    int tail;   // Peker til slutten av køen

    // Legger til en til variabel
    int count;  // Antall elementer som er i køen nå.

    // Lager en konstruktør
    // Det å lage dette arrayet er konstant tid.
    CircularBuffer(int size){
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    // Lager en void funksjon som skal pushe back...det er dette vi skriver i c++
    // Konstant tid
    void pushBack(char value){
        // Må ha kontroll på at vi ikke legger inn for mange elementer.
        if (count + 1 > size){
            // Bruker IndexOutOfBoundsException() for å ha kontroll over at vi ikke legger inn for mange elementer
            // Passer ikke å bruke IllegalArgumentException
            throw new IndexOutOfBoundsException();
        }
        // Halen er bakerst i køen. Vi legger til ett element sist i køen og øker hvor halen er.
        buffer[tail] = value;
        // Når vi kommer til 20 så er vi out of bounce
        tail = (tail + 1) % size;
        // Legger til / øker
        count = count + 1;

        // Dette er en måte å legge til i arrayet vårt i funksjonen, pushBack funksjon.
    }

    // Legger til funksjonen som tar ut først i køen.
    // Tar ikke inn noen parametere fordi den skal hente inne elementet som kommer inn først.
    // Konstant tid
    char popFront(){
        if (count <= 0){
            throw new IndexOutOfBoundsException();
        }
        // retval = return value
        // buffer[head] Den verdien som er i starten av køen som det skal opereres på.
        char retval = buffer[head];
        System.out.println(head);
        // Vi skal øke hode med 1
        head = (head + 1) % size;
        // Legger til / Øker og subtraherer
        count = count - 1;
        return retval;
    }

    int count(){
        return count;
    }

    public static void main(String[] args){
        // Lager bufferet hvor vi ønsker størrelsen på 6 elementer, da vet vi at vi kan ha 6 elementer i køen.
        CircularBuffer buffer = new CircularBuffer(7);
        // Legger inn verdier
        char[] values = "ABCDEFGHIJKLMNOPRST".toCharArray();

        // Legger inn tre bokstaver i bufferet og hente tre verdier.
        for (int i = 0; i < values.length; /* Gjør ikke noe til slutten her*/ ){
            for(int j = 0; j < 6; ++j){
                // Bare for å sjekke out of bounce
                if (values.length > i + j){
                    buffer.pushBack(values[i + j]);
                }
            }
            // Ta ut alt fra bufferet / Skrive ut alt fra bufferet
            while (buffer.count() > 0){
                System.out.print(buffer.popFront());
            }
            // Henter ut alle elementene fra bufferet.
            System.out.println();

            // Har ikke oppdatert i, så gjør det under i linjen
            // i = i + 3;

            // Legger ikke inn 3 elementer nå, men 7
            // i = i + 7;

            // Sjekker om vi får lagt inn 6 elementer
            i = i + 6;
        }
    }
}

// PushBack, popFront og initialisering har konstant tid, så de er veldig effetive.