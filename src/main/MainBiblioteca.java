package SIstemaDeBiblioteca.Main;

import SIstemaDeBiblioteca.Class.Menu;

import java.io.IOException;

public class MainBiblioteca {
    public static void main(String[] args) throws InterruptedException, IOException {
        Menu menu = new Menu();
        menu.menuBiblioteca();
    }
}