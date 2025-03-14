package Objekt_beispiel;

public class Hund {

   private String name;
    private int age;

    public Hund (String neuername , int neueralter) {
        this.name = neuername;
        this.age =neueralter ;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void bellen(){
    System.out.println("wuff wuff");
}
public void friss (){
    System.out.println("mampf");
}
}

