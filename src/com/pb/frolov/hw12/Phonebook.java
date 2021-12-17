package com.pb.frolov.hw12;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.stream.Stream;


public class Phonebook {

    @FunctionalInterface
    public interface SearchPersonByName {
        void search(String s,List<Person> ph);
    }

    @FunctionalInterface
    public interface RemovePersonFromPhonebook {
        void remove(List<Person> ph);
    }

    @FunctionalInterface
    public interface CreateNewPerson {
        Person newPerson ();
    }

        @FunctionalInterface
    public interface JsonPersonFromFile {
        List<Person> read(List<Person> ph, Path fp) throws JsonProcessingException;
    }

    @FunctionalInterface
    public interface ListToJsonToFile {
        void write(List<Person> ph, Path fp) throws JsonProcessingException;
    }

    @FunctionalInterface
    public interface SortPhonebook {
        void sort(List<Person> ph, Comparator<Person> comp);
    }


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

            JsonPersonFromFile jsonPersonFromFile = (ph,fp) ->{
                StringBuilder sb = new StringBuilder();
                try (BufferedReader reader = Files.newBufferedReader(fp)) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");               //line+= reader.readLine() + "*\n";
                    }
                    //System.out.println(sb);   чтоб просмотреть считаный JSON
                } catch (Exception ex) {
                    System.out.println("Error!!! Ошибка чтения файла." + ex);
                }
                ph.addAll(objectMapper.readValue(sb.toString(), new TypeReference<List<Person>>() {}));
                return ph;
            };

            //Считываем контакты из файла, десериализуем и добавляем в List<Person> phonebook
            jsonPersonFromFile.read(phonebook, path);

        }

        ListToJsonToFile listToJsonToFile = (ph, fp) ->{
            String jsonPerson = objectMapper.writeValueAsString(ph);
            //System.out.println(jsonPerson);  чтоб просмотреть список контактов в JSON
            // cохраняем контакты (jsonPerson) в файл в формате JSON
            try(BufferedWriter writer = Files.newBufferedWriter(fp)) {
                writer.write(jsonPerson);
            }
            catch (Exception ex){
                System.out.println("Error!!! Ошибка записи файла."+ex);
            }
        };

        Scanner in = new Scanner(System.in);

        CreateNewPerson createNewPerson = () ->{
            System.out.println("\n---Новый контакт----------------------------------------------------");
            System.out.print("\nВведите ФИО: ");
            in.nextLine();
            String name = in.nextLine();

            System.out.print("Введите дату рождения (пример 2001-10-27): ");
            LocalDate birthDate = LocalDate.parse(in.nextLine());

            System.out.print("Введите домашний адрес: ");
            String address = in.nextLine();

            System.out.println("Введите номер телефона (если номеров несколько разделите их пробелами): ");
            List <String> phones = Arrays.asList(in.nextLine().split(" "));

            Person person =new Person(name, birthDate, phones, address,LocalDate.now());
            return person;
        };

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
                    System.out.println("\n---Для сортировки контактов введите:-------------------------------- \n" +
                            "\t1 - сортировать по фамилии\n" +
                            "\t2 - сортировать по дате рождения\n" +
                            "\t3 - не сортировать");
                    choice = in.next();

                    //sortPhonebook.sort cортирует List<Person> по фамилии или дате рождения
                    SortPhonebook sortPhonebook = (ph,comp) ->{

                        Stream <Person> stream = ph.stream();
                        stream.sorted(comp)
                                .forEach(System.out::println);

                        /*  без Stream      //https://metanit.com/java/tutorial/10.8.php
                        List<Person> sortedList = new ArrayList<>();
                        sortedList.addAll(ph);
                        Collections.sort(sortedList , comp );
                        for (Person p: sortedList)
                            System.out.println(p);*/
                };

                    if ("1".equals(choice)){
                        sortPhonebook.sort(phonebook, Person.nameComparator);

                    }else if("2".equals(choice)){
                        sortPhonebook.sort(phonebook, Person.birthDateComparator);

                    }else if("3".equals(choice)){
                        phonebook.forEach(p -> System.out.println(p) );

                        /*for (Person p: phonebook)
                            System.out.println(p);*/
                    }else {
                        System.out.println("Вы ввели недопустимое значение");
                    }
                    break;

                case "2": //--------------------Добавить контакт-----------------------

                    phonebook.add( createNewPerson.newPerson() ); // createNewPerson.newPerson() возвращает Person person
                    System.out.println("---Контакт добавлен------------------------------------------------- \n");


                    // сериализуем List<Person> phonebook и записываем результат в файл
                    listToJsonToFile.write(phonebook,path);
                    break;

                case "3": //-------------------Найти контакт--------------------------
                    System.out.print("\nВведите фамилию: ");
                    String searchName = in.next();

                    SearchPersonByName searchPersonByName = (sn,ph) -> {
                        Stream <Person> stream = ph.stream();
                        stream.filter(p -> p.getFullName().toLowerCase().contains(sn.toLowerCase()))
                               .forEach(System.out::println);
                        
                        /*        без Stream
                        List<Person> seachResult = new ArrayList<>();
                        for (Person p : ph) {
                            if (p.getFullName().toLowerCase().contains(sn.toLowerCase())) {
                                seachResult.add(p);
                            }
                        }
                        return seachResult;*/
                    };
                    searchPersonByName.search(searchName,phonebook);
                    break;

                case "4": //--------------------Удалить контакт----------------------------

                    //удаляем донтакт
                    RemovePersonFromPhonebook removePersonFromPhonebook = (ph)->{
                        System.out.print("\nВведите ФИО: ");
                        String removePersonName = in.next();
                        for (Person p: ph) {
                            if (p.getFullName().toLowerCase().contains(removePersonName.toLowerCase())) {
                                System.out.println(p);
                                System.out.print("Вы этот контакт хотите удалить? (введите Да или Нет) ");
                                if ("да".equals(in.next().toLowerCase())){
                                    ph.remove(p);
                                    System.out.println("---Контакт удален-----------------------------------------\n");
                                    break;
                                }
                            }
                        }
                    };

                    removePersonFromPhonebook.remove(phonebook);

                    // сериализуем List<Person> phonebook и записываем результат в файл
                    listToJsonToFile.write(phonebook,path);
                    break;

                case "5": //--------------------Редактировать контакт----------------------------

                    System.out.print("\nВведите ФИО: ");

                    String editPersonName = in.next();
                    for (Person p: phonebook) {
                        if (p.getFullName().toLowerCase().contains(editPersonName.toLowerCase())) {
                            System.out.println(p);
                            System.out.print("Вы этот контакт хотите редактировать? (введите Да или Нет) ");
                            if ("да".equals(in.next().toLowerCase())) {
                                phonebook.set(phonebook.indexOf(p),createNewPerson.newPerson());
                                System.out.println("---Контакт изменен--------------------------------------------------\n");

                                // сериализуем List<Person> phonebook и записываем результат в файл
                                listToJsonToFile.write(phonebook,path);
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
}
