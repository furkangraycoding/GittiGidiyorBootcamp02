package dev.patika.secondhomeworkgittigidiyor.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("VisitingResearcher")
public class VisitingResearcher extends Instructor {
    private double hourlySalary;

    public VisitingResearcher(String name, String address, int phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(){}

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
