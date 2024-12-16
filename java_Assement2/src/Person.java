// 文件路径: src/Person.java
public abstract class Person {
    private String name;
    private int age;
    private String id;

    public Person() {
        // 抽象类不能被实例化，因此可以留空或者抛出异常
    }

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}