package com.prog.model;

public class Author extends User {
    private String sex;

    public Author(String id, String name, String sex) {
        super(id, name);
        this.sex = sex;
    }

    public Author(String name, String sex) {
        super(name);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "\nAuthor{" +
                "\n\tid='" + getId() + '\'' +
                ", \n\tname='" + getName() + '\'' +
                ", \n\tsex='" + sex + '\'' +
                "\n}";
    }
}
