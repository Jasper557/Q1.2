package _11BinarySearchTree.Aufgabe._01PersonSuchen;

import resources.BinarySearchTree;
import resources.List;

import java.util.Scanner;

public class Main implements Vorlage {
    @Override
    public String personEingeben() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie den Namen der Person ein: ");

        String name = scanner.nextLine();

        //Nicht vergessen den Scanner zu schließen :)
        scanner.close();

        return name;
    }

    @Override
    public void suchePersonImBST(BinarySearchTree<Person> pBST, String pName) {
        //Abbruchbedingung
        if (!pBST.isEmpty()) {
            Person currentPerson = pBST.getContent();
            // Vergleich der Namen
            int comparison = currentPerson.getName().compareTo(pName);

            if (comparison == 0) {
                // Name wird ausgedruck, wenn der Name übereinstimmt
                System.out.println("Person gefunden: " + currentPerson.getName());
            } else if (comparison > 0) {
                // Wenn der Name des aktuellen Knotens größer ist, suche im linken Teilbaum weiter
                suchePersonImBST(pBST.getLeftTree(), pName);
            } else {
                // Wenn der Name des aktuellen Knotens kleiner ist, suche im rechten Teilbaum weiter
                suchePersonImBST(pBST.getRightTree(), pName);
            }
        } else {
            // Wenn der Binärbaum leer ist, wurde die Person nicht gefunden sheesh
            System.out.println("Person nicht gefunden.");
        }
    }

    @Override
    public void printBST_inorder(BinarySearchTree<Person> pBST) {
        //Abbruchbedingung
        if (!pBST.isEmpty()) {
            // Linken Teilbaum durchgehen
            printBST_inorder(pBST.getLeftTree());

            // Aktuelles Element ausdrucken
            System.out.println(pBST.getContent().getName());

            // Rechten Teilbaum durchgehen
            printBST_inorder(pBST.getRightTree());
        }
    }

    @Override
    public BinarySearchTree<Person> fillBSTWithNames() {
        BinarySearchTree<Person> bst = new BinarySearchTree<>();

        //Liste mit dem Namen
        List<String> namesList = new List<>();

        //Namen einfügen
        namesList.append("Detlev Kümmel");
        namesList.append("Sven Deutschmanek");
        namesList.append("Albert Maier");
        namesList.append("Dr. Heide Rezepa-Zabel");
        namesList.append("Horst Lichter");

        //Namen aus der Liste in den Baum schreiben
        namesList.toFirst();
        while (namesList.hasAccess()) {

            String name = namesList.getContent();
            Person person = new Person(name);

            bst.insert(person);

            namesList.next();
        }
        return bst;
    }

    public static void main(String[] args) {
        Main app = new Main();
        BinarySearchTree<Person> personenBST = app.fillBSTWithNames();
        String name = app.personEingeben();
        app.suchePersonImBST(personenBST, name);
        System.out.println("\n\n\u001B[34mDiese Namen sind im Suchbaum:\u001B[0m");

        System.out.println("\n\u001B[35mInorder:\u001B[0m");
        app.printBST_inorder(personenBST);
    }
}
