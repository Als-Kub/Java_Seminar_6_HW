/*
Создать класс Ноутбук для магазина техники.
Добавить атрибуты класса с соответствующими типами.
Например,
- идентификатор
- производитель
- название модели
- RAM
- объем HD
- операционная система
- цена
- и т.д.
Добавить конструктор класса.
Добавить необходимые методы класса.

Создать множество ноутбуков (множество объектов класса ноутбук).
3-10 штук

Вывести в консоль меню пользователя:
Добро пожаловать в каталог ноутбуков! 
Выберите действие:
  1 - Печать всех товаров
  2 - Поиск по каталогу
  0 - Выход
Написать метод, который будет запрашивать у пользователя критерий фильтрации (один) и выведет ноутбуки, отвечающие критерию.
Например:

Введите цифру, соответствующую критерию поиска:
1 - RAM
2 - Объем HD
3 - Операционная система
4 - Цвет …

Пример вывода:

Ноутбуки с цвет Серебристый
1 Honor ...
2..
3...
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class notebook {
    int id;
    String manufacturer;
    String model;
    int RAM;
    int SSD;
    String operatingSystem;
    String videoCard;
    int price;

    public notebook(
            int id,
            String manufacturer,
            String model,
            int RAM,
            int SSD,
            String operatingSystem,
            String videoCard,
            int price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.RAM = RAM;
        this.SSD = SSD;
        this.operatingSystem = operatingSystem;
        this.videoCard = videoCard;
        this.price = price;
    }

    public String printNotebook() {
        return "Id: " + id + ", Manufacturer: " + manufacturer + ", Model: " + model + ", RAM: " + RAM + ", SSD: " + SSD
                + ", Video card: " + videoCard + ",  Operating System: " + operatingSystem
                + ", Price " + price;
    }

    public List<notebook> findNotebook(HashSet<notebook> hashNotebook, String operatingSystem) {
        List<notebook> notebookList = new ArrayList<notebook>();
        for (notebook notebook : hashNotebook) {
            if (notebook.operatingSystem.equals(operatingSystem)) {
                notebookList.add(notebook);
            }
        }
        return notebookList;
    }

    public static void main(String[] args) {
        boolean cont = true;
        while (cont) {
            // do {
            System.out.println("Welcome to Notebook shop! ");
            System.out.println("Select an action: \n 0 - Exit; \n 1 - Print all items; \n 2 - Search in catalogue;");

            Scanner iScanner = new Scanner(System.in);

            int userInput = iScanner.nextInt();
            if (userInput == 0) {
                cont = false;
            }
            HashSet<notebook> notebookSet = new HashSet<notebook>();

            notebook nb_1 = new notebook(11111, "Dell", "Dell Latitude Pd1", 36, 512, "Windows", "Intel UHD Graphics ",
                    83200);

            notebook nb_2 = new notebook(22222, "HP", "HP Pro 181", 16, 256, "Windows", "AMD Radeon", 64100);

            notebook nb_3 = new notebook(33333, "Apple", "MacBook Pro 181", 8, 56, "macOS", "Intel UHD Graphics",
                    92300);

            notebookSet.add(nb_1);

            notebookSet.add(nb_2);
            notebookSet.add(nb_3);

            switch (userInput) {
                case 1:
                    for (notebook i : notebookSet) {
                        System.out.println(i.printNotebook());
                    }
                    break;

                case 2:
                    System.out.println("Select operating system (Windows/macOS): ");
                    String operatingSystemInput = iScanner.next();
                    List<notebook> queryNotebook = nb_3.findNotebook(notebookSet, operatingSystemInput);
                    for (notebook i : queryNotebook) {
                        System.out.println(i.printNotebook());
                    }
                    break;

            }

        }
    }
}
