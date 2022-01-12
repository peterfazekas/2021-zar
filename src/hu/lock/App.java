package hu.lock;

import hu.lock.controller.KeyService;
import hu.lock.model.service.*;

import java.util.Scanner;

public class App {
    
    private final KeyService keyService;
    private final Console console;

    private App() {
        console = new Console(new Scanner(System.in));
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        keyService = new KeyService(dataApi.getData("ajto.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.print("2. feladat: Adja meg mi nyitja a zárat: ");
        String pattern = console.read();
    }

}
