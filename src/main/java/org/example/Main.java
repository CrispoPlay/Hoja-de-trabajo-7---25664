package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Dictionary dict = new Dictionary();

        // Cargar diccionario
        dict.loadDictionary("diccionario.txt");

        System.out.println("Diccionario ordenado (In-order):");
        dict.printDictionary();

        System.out.println("\nTraducción:");
        dict.translateText("texto.txt");
    }
}
