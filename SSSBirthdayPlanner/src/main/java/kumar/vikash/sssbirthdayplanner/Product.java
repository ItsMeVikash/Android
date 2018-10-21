package kumar.vikash.sssbirthdayplanner;

/**
 * Created by vikash kumar on 02-06-2018.
 */
public class Product {
    String  Name,Price,Image,Description;
    public Product(String Name,String Price,String Image,String Description){
        this.Name=Name;
        this.Price=Price;
        this.Image=Image;
        this.Description=Description;
    }
    public Product(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
