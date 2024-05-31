package Lab1_PEVM;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class lab6 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<HealthWorker> Workers = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int ans, localans1, localans2, localans3, localans4, localans5;

        do {
            System.out.println("Меню: ");
            System.out.println("1. Добавление элемента в конец или в определенное место списка.");
            System.out.println("2. Удаление элемента в конце или в определенном месте списка.");
            System.out.println("3. Изменение определенного элемента списка.");
            System.out.println("4. Поиск и вывод номера и информации введенного элемента по разным полям.");
            System.out.println("5. Вывод на экран всех объектов списка или определенного элемента списка.");
            System.out.println("6. Вывод числа элементов в списке.");
            System.out.println("7. Заполнение списка объектами из выбранного текстового файла");
            System.out.println("8. Запись всех данных из списка в выбранный текстовый файл");
            System.out.println("9. Выход.");
            System.out.print("Выберите пункт меню: ");
            ans = in.nextInt();
            switch (ans) {
                case 1:
                    int n = 0;
                    boolean fl = false;
                    while (!fl) {
                        try {
                            System.out.print("Сколько элементов добавить: ");
                            n = in.nextInt();
                            fl = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка! Введите натуральное число.");
                            in.next();
                        }
                    }
                    System.out.println("Куда добавить?");
                    System.out.println("1. В конец");
                    System.out.println("2. По индексу");
                    System.out.print("Выберите пункт меню: ");
                    localans1 = in.nextInt();
                    switch (localans1) {
                        case 1:
                            int i = 1;
                            do {
                                System.out.println("Заполнение объекта " + i);
                                Workers.add(new HealthWorker());
                                n--;
                                i++;
                            } while (n > 0);
                            break;
                        case 2:
                            System.out.print("По какому индексу: ");
                            int index = in.nextInt();
                            if (index > Workers.size() - 1) {
                                System.out.println("Так как индекс больше размера списка, элемент будет добавлен в конец.");
                                int j = 1;
                                do {
                                    System.out.println("Заполнение объекта " + j);
                                    try {
                                        Workers.add(new HealthWorker());
                                    } catch (ArrayStoreException e) {
                                        System.out.println("Ошибка! Несовместимый тип");
                                    }
                                    n--;
                                    j++;
                                } while (n > 0);
                            } else if (index < Workers.size() - 1) {
                                int j = 1;
                                System.out.println("Заполнение объекта " + j);
                                Workers.add(new HealthWorker());
                            } else {
                                int j = 1;
                                while (n > 0) {
                                    System.out.println("Заполнение объекта " + j);
                                    Workers.add(index, new HealthWorker());
                                    n--;
                                    j++;
                                }
                            }
                            break;
                        default:
                            System.out.println("Ошибка ввода.");
                    }
                    break;
                case 2:
                    System.out.print("Сколько элементов удалить: ");
                    n = in.nextInt();
                    if (n > Workers.size()) {
                        Workers.removeAll(Workers);
                        System.out.println("Так как количество элементов для удаления было больше размера списка, то список был очищен полностью");
                        break;
                    }
                    System.out.println("Откуда удалить?");
                    System.out.println("1. С конец");
                    System.out.println("2. По индексу");
                    System.out.print("Выберите пункт меню: ");
                    localans2 = in.nextInt();
                    switch (localans2) {
                        case 1:
                            while (n > 0) {
                                try {
                                    Workers.remove(Workers.size() - 1);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Ошибка! Неправильный аргумент передаваемый методу");
                                }
                                n--;
                                HealthWorker.deletedCount();
                            }
                            break;
                        case 2:
                            System.out.print("По какому индексу: ");
                            int index = in.nextInt();
                            if (index > Workers.size()) {
                                while (n > 0) {
                                    Workers.remove(Workers.size() - 1);
                                    n--;
                                    HealthWorker.deletedCount();
                                }
                            } else {
                                while (n > 0) {
                                    Workers.remove(index);
                                    n--;
                                    HealthWorker.deletedCount();
                                }
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.printf("Какой элемент списка изменить (1-%d): ", Workers.size());
                    n = in.nextInt();
                    if (n > Workers.size()) {
                        System.out.printf("Введеное значение не верно, введите (1-%d)", Workers.size());
                        break;
                    }
                    System.out.println("1. Изменить весь объект");
                    System.out.println("2. Изменить поле объекта");
                    System.out.print("Выберите пункт меню: ");
                    localans3 = in.nextInt();
                    switch (localans3) {
                        case 1:
                            Workers.set(n - 1, new HealthWorker());
                            break;
                        case 2:
                            int case2ans;
                            Scanner on = new Scanner(System.in);

                            System.out.println("Какое поле изменить?");
                            System.out.println("1. Имя");
                            System.out.println("2. Фамилия");
                            System.out.println("3. Возраст");
                            System.out.println("4. Город клиники");
                            System.out.println("5. Номер клиники");
                            System.out.println("6. Является ли государственной");
                            System.out.print("Выберите пункт меню: ");
                            case2ans = in.nextInt();
                            switch (case2ans) {
                                case 1:
                                    System.out.print("Введите новое имя: ");
                                    String NewName = on.nextLine();
                                    Workers.get(n - 1).setName(NewName);
                                    break;
                                case 2:
                                    System.out.print("Введите новую фамилию: ");
                                    String NewSurname = on.nextLine();
                                    Workers.get(n - 1).setSurname(NewSurname);
                                    break;
                                case 3:
                                    System.out.print("Введите новый возраст: ");
                                    int NewAge = on.nextInt();
                                    Workers.get(n - 1).setAge(NewAge);
                                    break;
                                case 4:
                                    System.out.print("Введите новый город: ");
                                    String NewCity = on.nextLine();
                                    Workers.get(n - 1).setCity(NewCity);
                                    break;
                                case 5:
                                    System.out.print("Введите новый номер: ");
                                    int NewNumber = on.nextInt();
                                    Workers.get(n - 1).setNumber(NewNumber);
                                    break;
                                case 6:
                                    System.out.print("Введите новый статус(да/нет): ");
                                    String NewStatusGos = on.nextLine();
                                    Workers.get(n - 1).setStatus(NewStatusGos);
                                    break;
                            }
                            break;
                    }
                    break;
                case 4:
                    Scanner scan = new Scanner(System.in);
                    System.out.println("По какому полю нужен поиск?");
                    System.out.println("1. Имя");
                    System.out.println("2. Фамилия");
                    System.out.println("3. Возраст");
                    System.out.println("4. Город");
                    System.out.println("5. Номер клиники");
                    System.out.print("Выберите пункт меню: ");
                    localans4 = in.nextInt();
                    switch (localans4) {
                        case 1:
                            int a1 = 0;
                            System.out.print("Введите искомое имя: ");
                            String SearchName = scan.nextLine();
                            for (int i = 0; i < Workers.size(); i++) {
                                if (Workers.get(i).getName().equals(SearchName)) {
                                    System.out.println("Объект номер " + (i + 1));
                                    Workers.get(i).getValue();
                                    a1++;
                                }
                            }
                            if (a1 == 0)
                                System.out.println("Объекта с таким полем нет.");
                            break;
                        case 2:
                            int a2 = 0;
                            System.out.print("Введите искомую фамилию: ");
                            String SearchSurname = scan.nextLine();
                            for (int i = 0; i < Workers.size(); i++) {
                                if (Workers.get(i).getSurname().equals(SearchSurname)) {
                                    System.out.println("Объект номер " + (i + 1));
                                    Workers.get(i).getValue();
                                    a2++;
                                }
                            }
                            if (a2 == 0)
                                System.out.println("Объекта с таким полем нет.");
                            break;
                        case 3:
                            int a3 = 0;
                            System.out.print("Введите искомый возраст: ");
                            int SearchAge = scan.nextInt();
                            for (int i = 0; i < Workers.size(); i++) {
                                if (Workers.get(i).getAge() == SearchAge) {
                                    System.out.println("Объект номер " + (i + 1));
                                    Workers.get(i).getValue();
                                    a3++;
                                }
                            }
                            if (a3 == 0)
                                System.out.println("Объекта с таким полем нет.");
                            break;
                        case 4:
                            int a4 = 0;
                            System.out.print("Введите искомый город: ");
                            String SearchCity = scan.nextLine();
                            for (int i = 0; i < Workers.size(); i++) {
                                if (Workers.get(i).getCity().equals(SearchCity)) {
                                    System.out.println("Объект номер " + (i + 1));
                                    Workers.get(i).getValue();
                                    a4++;
                                }
                            }
                            if (a4 == 0)
                                System.out.println("Объекта с таким полем нет.");
                            break;
                        case 5:
                            int a5 = 0;
                            System.out.print("Введите искомый номер: ");
                            int SearchNumber = scan.nextInt();
                            for (int i = 0; i < Workers.size(); i++) {
                                if (Workers.get(i).getNumber() == SearchNumber) {
                                    System.out.println("Объект номер " + (i + 1));
                                    Workers.get(i).getValue();
                                    a5++;
                                }
                            }
                            if (a5 == 0)
                                System.out.println("Объекта с таким полем нет.");
                            break;
                        case 6:
                            int a6 = 0;
                            System.out.print("Введите искомый статус: ");
                            String SearchStatus = scan.nextLine();
                            for (int i = 0; i < Workers.size(); i++) {
                                if (Workers.get(i).getStatus().equals(SearchStatus)) {
                                    System.out.println("Объект номер " + (i + 1));
                                    Workers.get(i).getValue();
                                    a6++;
                                }
                            }
                            if (a6 == 0)
                                System.out.println("Объекта с таким полем нет.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("1. Вывести все объекты");
                    System.out.println("2. Вывести объект номеру элемента");
                    System.out.print("Выберите пункт меню: ");
                    localans5 = in.nextInt();
                    switch (localans5) {
                        case 1:
                            for (int i = 0; i < Workers.size(); i++) {
                                Workers.get(i).getValue();
                            }
                            break;
                        case 2:
                            System.out.printf("Какой объект вывести(1-%d): ", Workers.size());
                            n = in.nextInt();
                            Workers.get(n - 1).getValue();
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Количество объектов в списке: " + HealthWorker.getCount());
                    break;
                case 7:
                    in.nextLine();
                    System.out.print("Укажите путь файла из которого записать в список: ");
                    String new_path_in = in.nextLine().trim();
                    if (new_path_in.startsWith("\"") && new_path_in.endsWith("\"")) {
                        new_path_in = new_path_in.substring(1, new_path_in.length() - 1);
                    }
                    File files = new File(new_path_in);
                    System.out.println("~Начинаем запись в список~");
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.println(".");

                    if (Workers.size() != 0) {
                        System.out.println("Список объектов не пуст, будет выполнено его очищенеи");
                        for (int k = Workers.size() - 1; k > 0; k--) {
                            Workers.remove(k);
                        }
                        if (Workers.size() == 0) {
                            System.out.println("Список очищен");
                        }
                    }

                    if (!files.exists())
                        System.out.println("~Такого файла не существует~");
                    else if (!files.canWrite())
                        System.out.println("~Файл не подходит для записи~");
                    else if (files.isDirectory())
                        System.out.println("~Это не файл~");
                    else {
                        try (BufferedReader reader = new BufferedReader(new FileReader(files))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                String[] new_line = line.split(";   ~");
                                String name = new_line[0].split(" ")[1];
                                String surname = new_line[1].split(" ")[1];
                                int age = Integer.parseInt(new_line[2].split(" ")[1]);
                                String city = new_line[3].split(" ")[1];
                                int number = Integer.parseInt(new_line[4].split(" ")[2]);
                                String status = new_line[5].split(" ")[2];
                                Workers.add(new HealthWorker(name, surname, age, city, number, status));
                            }
                        } catch (IOException e) {
                            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Запись выполнена успешно\n" );
                    break;
                case 8:
                    in.nextLine();
                    System.out.print("Укажите путь файла в который записать список: ");
                    String new_path = in.nextLine().trim();
                    if (new_path.startsWith("\"") && new_path.endsWith("\"")) {
                        new_path = new_path.substring(1, new_path.length() - 1);
                    }
                    File file = new File(new_path);

                    if (!file.exists())
                        System.out.println("~Такого файла не существует~");
                    else if (!file.canWrite())
                        System.out.println("~Файл не подходит для записи~");
                    else if (file.isDirectory())
                        System.out.println("~Это не файл~");
                    else {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                            if (file.length() != 0) {
                                System.out.println("~Файл не пустой~");
                                writer.write(""); // Очистка файла
                                System.out.println((file.length() == 0) ? "~файл успешно очищен~" : "~Файл не удалось очистить~");
                            }
                            System.out.println("~Начинаем запись в файл~");
                            System.out.print(".");
                            Thread.sleep(300);
                            System.out.print(".");
                            Thread.sleep(300);
                            System.out.print(".");
                            Thread.sleep(300);
                            System.out.print(".");
                            Thread.sleep(300);
                            System.out.println(".");

                            for (int i = 0; i < Workers.size(); i++) {
                                String data_to_file = "~Имя: " + Workers.get(i).name + ";   ~Фамилия: " + Workers.get(i).surname + ";   ~Возраст: " + Integer.toString(Workers.get(i).age) +
                                        ";   ~Город: " + Workers.get(i).getCity() + ";   ~Номер клиники: " + Integer.toString(Workers.get(i).getNumber()) +
                                        ";   ~Гос Клиника: " + Workers.get(i).getStatus();

                                writer.write(data_to_file);
                                writer.newLine(); // Добавляем новую строку после каждой записи
                            }
                            System.out.println("~Запись в файл успешно завершена~\n");
                        } catch (IOException | InterruptedException e) {
                            System.out.println("~Ошибка при записи в файл~");
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        } while (ans != 9);
    }
}


class HealthWorker {
    static int count;
    String name;
    String surname;
    int age;
    hospital id;


    HealthWorker() {
        fillWorker();
        count++;
    }

    HealthWorker(String name, String surname, int age, String city, int number, String status) {
        setWorker(name, surname, age, city, number, status);
        count++;
    }

    void getValue() {
        System.out.println("{\n" +
                "Имя: " + name + ".\t\t\t\t" + "Город: " + id.city + ".\n"
                + "Фамилия: " + surname + ".\t\t" + "Номер клиники: " + id.number + ".\n"
                + "Возраст: " + age + ".\t\t\t" + "Гос клиника: " + id.statusGos + ". \n" + "}");
    }

    static void deletedCount() {
        count--;
    }

    void fillWorker() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = in.nextLine();
        System.out.print("Введите фамилию: ");
        this.surname = in.nextLine();
        System.out.print("Введите возраст: ");
        this.age = in.nextInt();
        this.id = new hospital();
    }

    void setWorker(String name, String surname, int age, String city, int number, String status) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = new hospital(city, number, status);
    }

    public static int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        id.setCity(city);
    }

    public void setNumber(int number) {
        id.setNumber(number);
    }

    public void setStatus(String status) {
        id.setStatusGos(status);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return id.city;
    }

    public int getNumber() {
        return id.number;
    }

    public String getStatus() {
        return id.statusGos;
    }
}


class hospital {

    String statusGos;
    String city;
    int number;


    hospital() {
        fillHospital();
    }

    hospital(String city, int number, String status) {
        this.city = city;
        this.number = number;
        this.statusGos = status;
    }

    void fillHospital() {
        String f1;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите в каком городе клиника: ");
        this.city = in.nextLine();
        System.out.print("Является ли клиника государственной(да/нет): ");
        this.statusGos = in.nextLine();
        System.out.print("Введите номер клиники: ");
        this.number = in.nextInt();
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStatusGos(String statusGos) {
        this.statusGos = statusGos;
    }

}
