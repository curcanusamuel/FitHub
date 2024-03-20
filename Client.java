public class Client {
    private static int id=0;
    private String name;
    private int age;
    private boolean activity=false;
    private Trainer trainer;
    public Client(String name, int age){
        this.age=age;
        this.name=name;
        this.trainer=null;
        id++;
    }

    public boolean startStopActivity()
    {
        if(!activity) {
            activity = true;
        }
        else {
            activity=false;
        }
        return activity;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void assignToATrainer(Trainer trainer){
        if(this.trainer==null)
        {
            trainer.addClient(this);
            this.trainer=trainer;
        }
    }

    @Override
    public String toString() {
        return "Client:" + name + '\'' +
                ", age=" + age +
                ", trainer=" + trainer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Client.id = id;
    }
}
