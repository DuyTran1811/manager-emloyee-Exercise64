package BT4;

public class Smartphone implements Comparable<Smartphone> {
    private String id;
    private String brand;
    private String name;
    private float price;
    private int year;
    private String screenSize;

    public Smartphone() {
    }

    public Smartphone(String id, String brand, String name, float price,
                      int year, String screenSize)throws InvalidBrandNameException {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.year = year;
        this.screenSize = screenSize;
    }

    public void setBrand(String brand) throws InvalidBrandNameException {
        if (checBrandOk(brand)) {
            this.brand = brand;
        } else {
            this.brand = null;
            var smg = "Ten Hang Khong Hop Le " + brand;
            throw new InvalidBrandNameException(smg, brand);
        }
    }

    private boolean checBrandOk(String brand) {
        String[] brands = {"apple", "samsung", "huawei", "xiaomi", "oppo", "vsmart"};
        for (String item : brands) {
            if (brand.toLowerCase().compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getScreenSize() {
        return screenSize;
    }

    @Override
    public int compareTo(Smartphone o) {
        return id.compareTo(o.id);
    }
}
