package com.thou.coffee.entity;

//tuong lai se co @Entity, @OneToMany... ORM
public class Category {

    //@Id...
    private Long id;  //kieu key tu tang
    private String name;
    private String description;  //gay nhieu, ko can xo ra o UI

    public Category() {
    }

    //key tu tang thi phai xoa tham so id, ko can truyen vao
    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
