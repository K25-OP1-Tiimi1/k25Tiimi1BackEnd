package k25tiimi1backend.k25tiimi1backend.domain;

public class ReservationRequest {
    public String email;
    public String password;
    public int count;
    public Product item;

    // Constructors
    public ReservationRequest() {
    }

    public ReservationRequest(String email, String password, int count, Product item) {
        this.email = email;
        this.password = password;
        this.count = count;
        this.item = item;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }
}
