package org.takintosh.domain.models;

import java.util.regex.Pattern;

public class Client {
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    private static final int MIN_AGE = 18;
    private static final Pattern PHONE_PATTERN_BR = Pattern.compile("^\\+55\\d{10,11}$");
    private static final Pattern PHONE_PATTERN_UY = Pattern.compile("^\\+598\\d{8}$");

    private String cpf;
    private String name;
    private String contact;
    private int age;

    public Client(String cpf, String name, String contact, int age) {
        // Validate CPF
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            throw new IllegalArgumentException("Invalid CPF format");
        }
        // Validate Name
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        // Validate Contact
        if (contact == null || contact.isEmpty() ||
                (!PHONE_PATTERN_BR.matcher(contact).matches() && !PHONE_PATTERN_UY.matcher(contact).matches())) {
            throw new IllegalArgumentException("Invalid contact format. Must be a valid phone number for Brazil or Uruguay.");
        }
        // Validate Age
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be at least 18");
        }

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
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            throw new IllegalArgumentException("Invalid CPF format");
        }
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        if (contact == null || contact.isEmpty() ||
                (!PHONE_PATTERN_BR.matcher(contact).matches() && !PHONE_PATTERN_UY.matcher(contact).matches())) {
            throw new IllegalArgumentException("Invalid contact format. Must be a valid phone number for Brazil or Uruguay.");
        }
        this.contact = contact;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        this.age = age;
    }
}
