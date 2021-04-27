package ru.job4j.model;

import java.util.Objects;
import java.util.Set;

public class Accident {
    private int id = 0;
    private String name;
    private AccidentType type;
    private Set<Rule> rules;
    private String text;
    private String address;


    public Accident() {
    }

    public static Accident of(Integer id, String name, AccidentType type, Set<Rule> rules, String text, String address) {
        Accident accident = new Accident();
        accident.id = id;
        accident.name = name;
        accident.type = type;
        accident.rules = rules;
        accident.text = text;
        accident.address = address;
        return accident;
    }

    public static Accident of(Integer id, String name) {
        Accident accident = new Accident();
        accident.id = id;
        accident.name = name;
        return accident;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return Objects.equals(id, accident.id)
                && Objects.equals(name, accident.name)
                && Objects.equals(text, accident.text)
                && Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, address);
    }
}
