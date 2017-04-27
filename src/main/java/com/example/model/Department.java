package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @SequenceGenerator(name = "departmentSequence", sequenceName = "department_d_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSequence")
    @Column(name = "d_id")
    private Integer id;

    @Column(name = "d_name")
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
