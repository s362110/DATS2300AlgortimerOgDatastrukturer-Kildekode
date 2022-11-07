package Uke42_BinæreTrær;

import java.util.ArrayDeque;

// Bredde først-traversering
// Dybde først-traversering
public class BinaryTree {

    static class BinaryTreeNode {
        // For denne binærtre noden så har vi en verdi.
        char value;

        // I tillegg så har vi en peker til hver av våre barn. Det er de verdiene vi hadde.
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;

        // Lager en konstruktør
        BinaryTreeNode(char value) {
            this.value = value;
            // Vi trenger ikke å gjøre dette men da vet vi at vi har initialisert dette.
            // I C++ og andre språk så er denne delen veldig viktig å ha med, mens i Java så er ikke det så viktig.
            this.left_child = null;
            this.right_child = null;
        }

        // Legger inn en node
        BinaryTreeNode addLeftChild(char value) {
            // Legger til en liten hjelpefunksjon som legger til et venstre barn
            this.left_child = new BinaryTreeNode(value);
            // Returnerer rot-noden som vi lager under. Da får vi sørget for at vi får lagret den i main funksjonen litt lenger nede.
            return this.left_child;
        }

        // Gjør tilsvarenede for høyre barn
        BinaryTreeNode addRightChild(char value) {
            this.right_child = new BinaryTreeNode(value);
            return this.right_child;
        }

        // Nå har vi laget en binærtre klasse som er alt vi trenger for å representere treet.
    }

    // Istedet for å rote til main metoden så lager jeg en egen funksjon.
    // Tar inn BinaryTreeNode root
    static void printLevelOrder(BinaryTreeNode root){
        // Deque er en veldig grei måte å håndtere en stack eller kø på fordi den er veldig godt implementert, og er en veldig god datastruktur for den type data.
        // ArrayDeque har implementert alle disse funksjonene som er komplisert for oss å legge inn manuelt.
        ArrayDeque<BinaryTreeNode> queve = new ArrayDeque<BinaryTreeNode>();

        // Legger til det første elementet som er rot-noden
        // Vi kan ta addFirst eller addLast.
        queve.addLast(root);

        while (!queve.isEmpty()){
            // 1. Ta ut første fra køen
            BinaryTreeNode current = queve.removeFirst();

            // 2. Legg til current sine to barn til køen
            // Når vi kommer til bunnen av treet så er barna null
            if (current.left_child != null){
                queve.addLast(current.left_child);
            }

            if (current.right_child != null){
                queve.addLast(current.right_child);
            }

            // 3. Skriv ut
            System.out.println(current.value + " ");
        }
    }

    // Vi skal lage den rekursive måten å skrive ut dybde først.

    // Lager en som er preorden, inorden og en som er postorden
    static void printPreOrder(BinaryTreeNode node){
        // Legger til en sjekk dersom noden er null.
        if (node == null){
            // Da skal vi ikke gjøre noe men kun returnere.
            // Dette er det ene kriteriet som vi må ha med rekursive funksjoner.
            // Også må vi ha et annet kriteriet som er et basiskriteriet som stanser funksjonen.
            // I dette tilfellet så er dette her basiskriteriet ettersom vi stanser når noden er lik null.
            return;
        }

        // Skriver ut preorden
        System.out.print(node.value + " ");
        printPreOrder(node.left_child);
        printPreOrder(node.right_child);
    }

    static void printInOrder(BinaryTreeNode node){
        // Legger til en sjekk dersom noden er null.
        if (node == null){
            return;
        }

        // Skriver ut inorden
        printInOrder(node.left_child);
        System.out.print(node.value + " ");
        printInOrder(node.right_child);
    }

    static void printPostOrder(BinaryTreeNode node){
        // Legger til en sjekk dersom noden er null.
        if (node == null){
            return;
        }

        // Skriver ut postorden
        printPostOrder(node.left_child);
        printPostOrder(node.right_child);
        System.out.print(node.value + " ");
    }

    // static void printDepthFirstNonRecursive(BinaryTreeNode root){
    static void printPreOrderNonRecursive(BinaryTreeNode root){
        // Bruker en stack for emulere programstacken i Java.
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<BinaryTreeNode>();

        // Legger til roten til stacken
        // Legger til fra bak og tar ut fra bak
        stack.addLast(root);

        while(!stack.isEmpty()){
            // Tar ut fra stacken fra samme sted. Så jobber hele tiden fra hale-enden.
            BinaryTreeNode current = stack.removeLast();

            // Fikser nullsjekken
            if (current.right_child != null){
                // Legger til i stacken
                // Vi må legge til høyre barn først fordi vi jobber i hale-enden.
                stack.addLast(current.right_child);

            }

            if (current.left_child != null){
                stack.addLast(current.left_child);
            }

            System.out.print(current.value + " ");
        }
    }

    // Lager en main funksjon for å skrive ut
    public static void main(String[] args){
        // Lager rot-noden (nivå 0)
        BinaryTreeNode root = new BinaryTreeNode('A');

        // Man bør egentlig lage en mer systematisk kode, men akkurat nå så hardkoder jeg dette inn.
        // Legg inn resterende noder på nivå 1
        // Lagret noden etter å ha returnert over i funksjonen addLeftChild, og addRightChild.
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');

        // Legg inn alle noder på nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        // Kall funksjonen vår
        // printLevelOrder(root);

        // Skriver ut preorden
        System.out.println("Pre order: ");
        printPreOrder(root);
        System.out.println();

        // Skriver ut inorden
        System.out.println("In order: ");
        printInOrder(root);
        System.out.println();

        // Skriver ut postorden
        System.out.println("Post order: ");
        printPostOrder(root);
        System.out.println();

        // Skriver ut preorden ikke-rekursiv
        System.out.println("Pre order non-recursive: ");
        printPreOrderNonRecursive(root);
        System.out.println();
    }
}