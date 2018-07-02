package models;

import javax.persistence.*;

@Entity
@Table(name="guitar")
public class Guitar {

    private int id;
    private String make;
    private String model;

    public Guitar(){

    }

    public Guitar(String make, String model){
        this.make = make;
        this.model = model;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name="model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
