package Uke44_HeaperOgHuffmantrær;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // Definerer arrayet på samme måte som vi gjør på penn og papir
        // Fyller ut en tulle-verdi for null-plasseringen i arrayet.
        int values[] = {-99, 5, 9, 8, 3, 1};

        heapsort(values);

    }

    // Det er litt dårlig navn å kalle denne funksjonen for heapsort når hapify er en del av heapsort
    static void heapsort(int[] values) {
        // Vi ser hvordan arrayet ser ut før heapify
        System.out.println("Array før heapify: " + Arrays.toString(values));
        // Kjører heapify funksjonen
        heapify(values);
        // Vi ser hvordan arrayet ser ut etter heapify
        System.out.println("Array etter heapify: " + Arrays.toString(values));

        for (int i = 1; i < values.length; ++i) {
            int first = 1;
            int last = values.length - i;

            System.out.println("Bytter " + first + " med " + last);

            // Vi skal bytte mellom første og siste element
            int tmp = values[first];
            values[first] = values[last];
            values[last] = tmp;

            int current = first;
            int left_child = current*2;
            int right_child = current*2 + 1;

            // Flytte noden som er på første med den minste av sine 2 barn, så lenge noden er større.
            // Har true fordi vi skal loope helt til vi stopper
            while (true) {
                //Venstre barn er minst av barna, og mindre enn parent
                if (left_child < last
                        && values[left_child] < values[right_child]
                        && values[left_child] < values[current]) {
                    // Skriver ut det vi bytter med
                    System.out.println("Bytter " + current + " med " + left_child);
                    int tmp2 = values[left_child];
                    values[left_child] = values[current];
                    values[current] = tmp2;
                    // Flytter oss til venstre barnet
                    current = left_child;
                }
                //Høyre barn er minst av barna, og mindre enn parent
                else if (right_child < last
                        && values[right_child] < values[left_child]
                        && values[right_child] < values[current]) {
                    // Skriver ut det vi bytter med
                    System.out.println("Bytter " + current + " med " + right_child);
                    int tmp2 = values[right_child];
                    values[right_child] = values[current];
                    values[current] = tmp2;
                    // Flytter oss til høyre barnet
                    current = right_child;
                }
                //Vi har funnet riktig plass til elementet.
                else {
                    break;
                }
                left_child = current*2;
                right_child = current*2 + 1;
            }
        }

        System.out.println("Array etter uttak: " + Arrays.toString(values));

    }

    // Skal gjøre om det binære treet til et minimumstre
    static void heapify(int[] values) {
        // Sjekker
        for (int i = 1; i < values.length; ++i) {
            // Skal få tak i id-en til den noden som vi jobber med og foreldre-noden.
            int current = i;
            int parent = i / 2;

            // Bruker while-løkke for å loope igjennom og sjekker at vi flytter tallet helt på toppen.
            // Så lenge parent er større enn current så skal vi bytte om
            while (parent > 0 && values[parent] > values[current]) {
                // Skriver ut hva algoritmen gjør
                System.out.println("Bytter " + current + " med " + parent);
                // Vi bytter om verdiene
                int tmp = values[parent];
                values[parent] = values[current];
                values[current] = tmp;
                // Vi må oppdatere hva current og parent er
                current = parent;
                parent = current / 2;
            }
        }
    }
}