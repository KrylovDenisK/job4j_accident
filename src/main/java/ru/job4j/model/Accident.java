package ru.job4j.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private AccidentType type;
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "accident_rule",
            joinColumns = @JoinColumn(name = "accident_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<Rule> rules;
    @Column(name = "text")
    private String text;
    @Column(name = "address")
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
        return id == accident.id &&
                Objects.equals(name, accident.name) &&
                Objects.equals(type, accident.type) &&
                Objects.equals(rules, accident.rules) &&
                Objects.equals(text, accident.text) &&
                Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, rules, text, address);
    }
}
