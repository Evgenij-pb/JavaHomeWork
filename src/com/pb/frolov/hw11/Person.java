package com.pb.frolov.hw11;

import java.time.LocalDate;
import java.util.List;

public class Person {

    private String fullName;
    private LocalDate birthDate;
    private List <String> phones;
    private String address;
    private LocalDate lastEdit;

    public Person() {
    }

    public Person(String fullName, LocalDate birthDate, List<String> phones, String address, LocalDate lastEdit) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phones = phones;
        this.address = address;
        this.lastEdit = lastEdit;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getPhones() {
        return phones;
    }

    //добавляет телефон контакту(Person)
    public void addPhones(String phone) {
        this.phones.add(phone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getLastEdit() {
        return lastEdit;
    }

    @Override
    public String toString() {
        return "\t   " + fullName + "\n" +           //Ф.И.О.
                "дата рождения: " + birthDate +"\n"+
                "дом. адрес: " + address + "\n" +
                "изменён: " + lastEdit + "\n"+
                "\t   телефон(ы): \n" + printPhones();

    }

    //Возвращает все телефоны контакта(Person)
    public String printPhones(){
        String ph ="";
        for (String p: getPhones())
            ph+= "   "+p + "\n";
        return ph;
    }
}
