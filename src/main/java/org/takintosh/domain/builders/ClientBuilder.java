package org.takintosh.domain.builders;

import org.takintosh.domain.models.Client;

public class ClientBuilder {
    private String cpf;
    private String name;
    private String contact;
    private int age;

    public ClientBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClientBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder withContact(String contact) {
        this.contact = contact;
        return this;
    }

    public ClientBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public Client build() {
        return new Client(cpf, name, contact, age);
    }
}