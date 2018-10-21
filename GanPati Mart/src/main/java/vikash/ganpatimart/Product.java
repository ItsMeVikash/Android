package vikash.ganpatimart;

/**
 * Created by vikash kumar on 01-04-2018.
 */

public class Product {
    String  Serial_No,Item_Name,MRP,Market_Rate,Discount,Image;
    public Product(String Serial_No,String Item_Name,String MRP,String Market_Rate,String Discount,String Image){
        this.Serial_No=Serial_No;
        this.Item_Name=Item_Name;
        this.MRP=MRP;
        this.Market_Rate=Market_Rate;
        this.Discount=Discount;
        this.Image=Image;
    }
    public Product(){}
    public String getSerial_No() {
        return Serial_No;
    }

    public void setSerial_No(String serial_No) {
        Serial_No = serial_No;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getMRP() {
        return MRP;
    }

    public void setMRP(String MRP) {
        this.MRP = MRP;
    }

    public String getMarket_Rate() {
        return Market_Rate;
    }

    public void setMarket_Rate(String market_Rate) {
        Market_Rate = market_Rate;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
