package com.nurique;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
    @Id
    @SequenceGenerator(
        name = "customer_id_sequence",
        sequenceName = "customer_id_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Customer(Integer id,
                    String name,
                    String email,
                    Integer age
    ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer(){

    }

    public Integer getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}
