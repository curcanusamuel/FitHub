import java.util.ArrayList;
import java.util.List;
public class Staff {
    private static int id=0;
    private String name;
    private List<Client> clients;
    private List<Trainer> trainers;

    public Staff(String name)
    {
        this.name=name;
        this.clients=new ArrayList<Client>();
        this.trainers=new ArrayList<Trainer>();
        id++;

    }

    public static int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Staff:" + name + '\'' +
                ", clients: " + clients +
                ", trainers: " + trainers;
    }

    public static void setId(int id) {
        Staff.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void addTrainer(Trainer trainer)
    {
        if(!trainers.contains(trainer))
        {
            trainers.add(trainer);
        }
    }
    public void addClient(Client client)
    {
        if(!clients.contains(client))
        {
            clients.add(client);
        }
    }



}
