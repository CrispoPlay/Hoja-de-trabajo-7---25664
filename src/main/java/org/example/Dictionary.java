package org.example;

import java.io.*;
import java.util.*;

public class Dictionary {
    private BinaryTree<String, String> tree = new BinaryTree<>();

    public void loadDictionary(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replace("(", "").replace(")", "");
                String[] parts = line.split(",");

                String english = parts[0].trim().toLowerCase();
                String spanish = parts[1].trim().toLowerCase();

                tree.insert(english, spanish);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printDictionary() {
        tree.inOrder();
    }

    public void translateText(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");

                for (String word : words) {
                    String clean = word.toLowerCase().replaceAll("[^a-z]", "");

                    String translation = tree.search(clean);

                    if (translation != null) {
                        System.out.print(translation + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}