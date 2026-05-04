package lbry;
class Person {
    protected String id;     // unique ID
    protected String name;   // person name

    // constructor
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter methods
    public String getId() { return id; }
    public String getName() { return name; }

    // return basic info
    public String getInfo() {
        return id + " - " + name;
    }

    // override toString for printing
    @Override
    public String toString() {
        return getInfo();
    }
}