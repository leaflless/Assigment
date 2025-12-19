public class Restaurant {

    private String name;
    private String address;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayRestaurant() {
        System.out.println("Restaurant: " + name);
        System.out.println("Address: " + address);
    }
}

