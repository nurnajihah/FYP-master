package sg.edu.rp.c346.smacbizservice;

import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String name;
    private String type;
    private String user_incharge;
    private String percent_of_uic;
    private String liaison_person;
    private String person_of_lp;
    private String client;
    private String price;
    private String complete;
    private String billed;
    private String due_date;


    public Task(int id, String name, String type, String user_incharge, String percent_of_uic, String liaison_person, String person_of_lp, String client, String price, String complete, String billed, String due_date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.user_incharge = user_incharge;
        this.percent_of_uic = percent_of_uic;
        this.liaison_person = liaison_person;
        this.person_of_lp = person_of_lp;
        this.client = client;
        this.price = price;
        this.complete = complete;
        this.billed = billed;
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_incharge() {
        return user_incharge;
    }

    public void setUser_incharge(String user_incharge) {
        this.user_incharge = user_incharge;
    }

    public String getPercent_of_uic() {
        return percent_of_uic;
    }

    public void setPercent_of_uic(String percent_of_uic) {
        this.percent_of_uic = percent_of_uic;
    }

    public String getLiaison_person() {
        return liaison_person;
    }

    public void setLiaison_person(String liaison_person) {
        this.liaison_person = liaison_person;
    }

    public String getPerson_of_lp() {
        return person_of_lp;
    }

    public void setPerson_of_lp(String person_of_lp) {
        this.person_of_lp = person_of_lp;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getBilled() {
        return billed;
    }

    public void setBilled(String billed) {
        this.billed = billed;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }


    @Override
    public String toString() {
        return id + "\n" + name + "\n" + type + user_incharge + "\n" + percent_of_uic + "\n" + liaison_person + "\n" + person_of_lp + "\n" + client + "\n" + price + "\n" + complete + "\n" + billed + "\n" + due_date;
    }
}
