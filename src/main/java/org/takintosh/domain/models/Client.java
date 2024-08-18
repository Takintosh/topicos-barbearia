package org.takintosh.domain.models;

public class Client {
    private String cpf;
    private String name;
    private String contact;
    private int age;

    public Client(String cpf, String name, String contact, int age) {
        this.cpf = cpf;
        this.name = name;
        this.contact = contact;
        this.age = age;
    }

    // Getters and setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
