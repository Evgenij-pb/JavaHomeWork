package com.pb.frolov.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

class PersonNameComparator implements Comparator<Person> {

    public int compare(Person a, Person b) {
        return a.getFullName().toLowerCase().compareTo(b.getFullName().toLowerCase());
    }
}

class PersonBirthDateComparator implements Comparator<Person> {

    public int compare(Person a, Person b) {
        if (a.getBirthDate().isAfter(b.getBirthDate()))
            return 1;
        else if (a.getBirthDate().isBefore(b.getBirthDate()))
            return -1;
        else
            return 0;
    }
}

public class Phonebook {
    public static void main(String[] args) throws Exception{

        System.out.println("\tТЕЛЕФОННЫЙ СПРАВОЧНИК\n");

        List <Person> phonebook = new ArrayList<>();
/*      phonebook.add(new Person("Тихов И.И.", LocalDate.of(1989, 5, 10), Arrays.asList ("0676225896","0666458712"), "пр. Свободы",LocalDate.now()));
        phonebook.add(new Person("Cидоров И.И.", LocalDate.of(1988,8,21),  Arrays.asList("0675234550","0682356620","0933355789","0675227788"), "пр. Победы",LocalDate.now()));
        phonebook.add(new Person("Аваков И.И.", LocalDate.of(1990,10,15),  Arrays.asList("0557859640"), "пр. Правды",LocalDate.now()));*/

        Path path = Paths.get("C:\\1\\phonebook.txt");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(module);


        //проверяем наличие файла с сохраненными контактами
        if (Files.notExists(path) | Files.isDirectory(path) ) {
            System.out.println("Файл со списком контактов отсутствует");
        }else if (Files.size(path)!=0){
            // если файл не пуст, тогда считываем его.

            //Считываем контакты из файла, десериализуем и добавляем в List<Person> phonebook
            jsonPersonFromFile (objectMapper,phonebook, path);
        }

        Scanner in = new Scanner(System.in);

        while (true){
            System.out.println("---Выберите действие:-----------------------------------------------");
            System.out.println("1. Вывод всех контактов ");
            System.out.println("2. Добавить контакт");
            System.out.println("3. Найти контакт");
            System.out.println("4. Удалить контакт");
            System.out.println("5. Редактировать контакт");

            String choice = in.next();
            switch (choice) {
                case "1": //---------------------Вывод всех контактов-------------------------
                    System.out.println("\nДля сортировки контактов введите: \n" +
                            "\t1 - сортировать по фамилии\n" +
                            "\t2 - сортировать по дате рождения\n" +
                            "\t3 - не сортировать");
                    choice = in.next();
                    if ("1".equals(choice)){
                        sortByName(phonebook);

                    }else if("2".equals(choice)){
                        sortByBirthdate(phonebook);

                    }else if("3".equals(choice)){
                        for (Person p: phonebook)
                            System.out.println(p);
                    }else {
                        System.out.println("Вы ввели недопустимое значение");
                    }
                    break;

                case "2": //--------------------Добавить контакт-----------------------
                    phonebook.add( createNewPerson() ); // createNewPerson() возвращает Person person

                    // сериализуем List<Person> phonebook и записываем результат в файл
                    ListToJsonToFile (objectMapper, phonebook, path);
                    break;
                case "3": //-------------------Найти контакт--------------------------
                    System.out.print("\nВведите фамилию: ");
                    String searchName = in.next();
                    List<Person> seachResult =searchPersonByName(searchName, phonebook);
                    if (seachResult.isEmpty()) {
                        System.out.println("Поиск не дал результатов\n");
                    } else
                    for (Person p: seachResult)
                        System.out.println(p);

                    break;
                case "4": //--------------------Удалить контакт----------------------------
                    System.out.print("\nВведите ФИО: ");

                    String removePersonName = in.next();
                    removePersonFromPhonebook(removePersonName, phonebook);

                    // сериализуем List<Person> phonebook и записываем результат в файл
                    ListToJsonToFile (objectMapper, phonebook, path);

                    break;

                case "5": //--------------------Редактировать контакт----------------------------

                    System.out.print("\nВведите ФИО: ");

                    String editPersonName = in.next();
                    for (Person p: phonebook) {
                        if (p.getFullName().toLowerCase().contains(editPersonName.toLowerCase())) {
                            System.out.println(p);
                            System.out.print("Вы этот контакт хотите редактировать? (введите Да или Нет) ");
                            if ("да".equals(in.next().toLowerCase())) {
                                phonebook.set(phonebook.indexOf(p),createNewPerson());
                                System.out.println("---Контакт изменен--------------------------------------------------\n");
                                ListToJsonToFile (objectMapper, phonebook, path);
                                break;
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Недопустимое значение...\n");
            }
        }
    }


    static Person createNewPerson(){

        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите ФИО: ");

        String name = in.nextLine();

        System.out.print("Введите дату рождения (пример 2001-10-27): ");
        LocalDate birthDate = LocalDate.parse(in.nextLine());

        System.out.print("Введите домашний адрес: ");
        String address = in.nextLine();

        System.out.println("Введите номер телефона (если номеров несколько разделите их пробелами): ");
        List <String> phones = Arrays.asList(in.nextLine().split(" "));

        Person person =new Person(name, birthDate, phones, address,LocalDate.now());
        return person;
    }

    //поиск контактов по фамилии
    static List<Person> searchPersonByName(String name, List<Person> phonebook){
        List<Person> seachResult =new ArrayList<>();
        for (Person p : phonebook) {
            if (p.getFullName().toLowerCase().contains(name.toLowerCase())){
            seachResult.add(p);
            }
        }
    return seachResult;
    }

    //удаляем донтакт
    static void removePersonFromPhonebook(String name,List<Person> phonebook){
        Scanner in = new Scanner(System.in);
        for (Person p: phonebook) {
            if (p.getFullName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                System.out.print("Вы этот контакт хотите удалить? (введите Да или Нет) ");
                if ("да".equals(in.next().toLowerCase())){
                    phonebook.remove(p);
                    System.out.println("---Контакт удален------------------------------\n");
                    break;
                }
            }
        }
    }

    //Сортирует List<Person> по фамилии
    static void sortByName(List<Person> list){
        PersonNameComparator NameComparator = new PersonNameComparator();
        TreeSet<Person> sortList = new TreeSet<>(NameComparator);
        sortList.addAll(list);
        sortList.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person p) {
                System.out.println(p + "\n");
            }
        });
    }

    //Сортирует List<Person> по дате рождения
    static void sortByBirthdate(List<Person> list){
        PersonBirthDateComparator BirthDateComparator = new PersonBirthDateComparator();
        TreeSet<Person> sortByBirth = new TreeSet<>(BirthDateComparator);
        sortByBirth.addAll(list);
        sortByBirth.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person p) {
                System.out.println(p+"\n");//
            }
        });
    }

    //Считываем контакты из файла (контакты в формате JSON) в String, десериализуем и добавляем в phonebook<Person>
    static List<Person> jsonPersonFromFile (ObjectMapper objectMapper,List<Person> phonebook, Path path) throws Exception{
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");               //line+= reader.readLine() + "*\n";
            }
                                                            //System.out.println(sb);   чтоб просмотреть считаный JSON
        } catch (Exception ex) {
            System.out.println("Error!!! Ошибка чтения файла." + ex);
        }
        phonebook.addAll(objectMapper.readValue(sb.toString(), new TypeReference<List<Person>>() {}));
        return phonebook;
    }

    // сериализуем List<Person> и записываем результат в файл
    static void ListToJsonToFile (ObjectMapper objectMapper, List<Person> phonebook,Path path) throws Exception{
        String jsonPerson = objectMapper.writeValueAsString(phonebook);
        //System.out.println(jsonPerson);  чтоб просмотреть список контактов в JSON

        // cохраняем контакты (jsonPerson) в файл в формате JSON
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonPerson);
        }
        catch (Exception ex){
            System.out.println("Error!!! Ошибка записи файла."+ex);
        }
    }
}
