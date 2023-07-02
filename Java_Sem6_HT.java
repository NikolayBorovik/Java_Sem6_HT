package Java_Seminar6.Java_Sem6_HT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Java_Sem6_HT {
    public static void main(String[] args) {
        // Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
        // методы. Реализовать в java.
        // Создать множество ноутбуков.
        // Написать метод, который будет запрашивать у пользователя критерий фильтрации
        // и выведет ноутбуки, отвечающие фильтру.
        // NoteBook notebook1 = new NoteBook
        // NoteBook notebook2 = new NoteBook
        // NoteBook notebook3 = new NoteBook
        // NoteBook notebook4 = new NoteBook
        // NoteBook notebook5 = new NoteBook

        // Например: “Введите цифру, соответствующую необходимому критерию:
        // 1 - ОЗУ
        // 2 - Объем ЖД
        // 3 - Операционная система
        // 4 - Цвет

        // Далее нужно запросить минимальные значения для указанных критериев -
        // сохранить параметры фильтрации можно также в Map.

        // Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
        // условиям.

        // Класс сделать в отдельном файле

        // приветствие
        // Выбор параметра
        // выбор конкретнее
        // вывод подходящих
        Scanner sc = new Scanner(System.in);

        Laptop laptop1 = new Laptop("HP Probook", 12345);
        laptop1.SetParameters(15, 4, 500, "Windows 11", "black");
        Laptop laptop2 = new Laptop("Macbook Pro", 3452);
        laptop2.SetParameters(16, 8, 500, "MacOS", "grey");
        Laptop laptop3 = new Laptop("Huawei wei wei", 21356351);
        laptop3.SetParameters(17, 4, 1000, "Windows 11", "black");
        Laptop laptop4 = new Laptop("Sony Top", 9851452);
        laptop4.SetParameters(16, 8, 1000, "Windows 13", "red");
        // System.out.println(laptop1);
        Set<Laptop> laptopset = new HashSet<>();
        laptopset.add(laptop1);
        laptopset.add(laptop2);
        laptopset.add(laptop3);
        laptopset.add(laptop4);
        // System.out.println(laptops);
        System.out.println("Hello!");
        System.out.println("Laptops fitting selected filters: " + Filter(laptopset));
        ;

        sc.close();
    }

    public static String GetStr(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print(str);
        String result = sc.nextLine();
        return result;
    }

    public static Set<Laptop> Filter(Set<Laptop> laptopset) {
        String welcomePrompt = "Please, enter a parameter to filter: /n 1 - RAM /n 2 - ROM /n 3 - OS /n 4 - color /n 5 - get a filtered list /n exit - exit the program: ";
        String promptRAM = "Please, specify the min limit for RAM to filter: ";
        String promptROM = "Please, specify the min limit for ROM to filter: ";
        String promptOS = "Please, specify a OS to filter: ";
        String promptColor = "Please, specify a color of the laptop to filter: ";
        String bye = "Good Bye!";
        Map<String, String> Filters = new HashMap<>();
        String str = GetStr(welcomePrompt);
        while (!str.equals("5")) {
            if (str.equals("1")) {
                String RAMfilter = GetStr(promptRAM);
                Filters.put("RAM", RAMfilter);
                str = GetStr(welcomePrompt);
                continue;
            }
            if (str.equals("2")) {
                String ROMfilter = GetStr(promptROM);
                Filters.put("ROM", ROMfilter);
                str = GetStr(welcomePrompt);
                continue;
            }
            if (str.equals("3")) {
                String OSfilter = GetStr(promptOS);
                Filters.put("OS", OSfilter);
                str = GetStr(welcomePrompt);
                continue;
            }
            if (str.equals("4")) {
                String colorfilter = GetStr(promptColor);
                Filters.put("color", colorfilter);
                str = GetStr(welcomePrompt);
                continue;
            }
            // if (str.equals("5"))
            //     break;
            if (str.equals("exit")) {
                System.out.println(bye);
                System.exit(1);
            } else {
                System.out.println("Wrong entry. Try again!");
                str = GetStr(welcomePrompt);
            }
        }

        Set<Laptop> laptoptemp = new HashSet<>();
        for (Laptop laptop : laptopset) {
            laptoptemp.add(laptop);
        }
       
        if (Filters.containsKey("RAM")) {
            for (Laptop item : laptopset) {
                if (Integer.parseInt(Filters.get("RAM")) > item.getRAM()) {
                    System.out.println("RAM");
                    System.out.println(item);
                    laptoptemp.remove(item);
                }
            }
        }

        if (Filters.containsKey("ROM")) {
            for (Laptop item : laptopset) {
                if (Integer.parseInt(Filters.get("ROM")) > item.getROM()) {
                    System.out.println("ROM");
                    System.out.println(item);
                    laptoptemp.remove(item);
                    
                }
            }
        }

        if (Filters.containsKey("OS")) {
            for (Laptop item : laptopset) {
                if (!Filters.get("OS").equals(item.getOS())) {
                    laptoptemp.remove(item);
                    System.out.println("OS");
                    System.out.println(laptoptemp);
                }
            }
        }

        if (Filters.containsKey("color")) {
            for (Laptop item : laptopset) {
                if (!Filters.get("color").equals(item.getColor())) {
                    laptoptemp.remove(item);
                    System.out.println("color");
                    System.out.println(laptoptemp);
                }
            }
        }
        return laptoptemp;

    }
}
