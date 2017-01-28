package app.travelling.srw;

/**
 * Created by User on 04/06/2016.
 */
public class Destination {

    private int id;
    private String name;
    private String category;
    private String description;
    private int price;
    private int facility;
    private int distance;

    public Destination(int id, String name, String category, String description, int price, int facility, int distance) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.facility = facility;
        this.distance = distance;
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

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public int getFacility() {

        return facility;
    }

    public void setFacility(int facility) {

        this.facility = facility;
    }

    public int getDistance() {

        return distance;
    }

    public void setDistance(int distance) {

        this.distance = distance;
    }
}
