import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static int id=0;
    private String name;
    private List<Client> clients;

    @Override
    public String toString() {
        return "Trainer: "+ name + '\'' +
                ", clients=" + clients;
    }

    public Trainer(String name)
    {
        this.name=name;
        this.clients=new ArrayList<Client>();
        id++;
    }
    public void addClient(Client client)
    {
        if(!clients.contains(client)){
            clients.add(client);
        }
        else {
            System.out.println("Already in the team");
        }
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Trainer.id = id;
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

    public void deleteClient(Client client)
    {
        if(clients.contains(client))
        {
            clients.remove(client);
        }
        else {
            System.out.println("This client is not in the team");
        }
    }

}
