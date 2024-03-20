public class Main {
    public static void main(String[] args) {
        Staff staf=new Staff("Sami");
        Client c1=new Client("Dave",18);
        Client c2=new Client("Bela",19);
        Client c3=new Client("Rose",20);
        Client c4=new Client("John",21);

        Trainer t1=new Trainer("Jose");
        Trainer t2=new Trainer("Jannifer");
        staf.addClient(c1);
        staf.addClient(c2);
        staf.addClient(c3);
        staf.addClient(c4);

    }
}