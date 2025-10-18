public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    double price;
    boolean bookingStatus;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }
    public void productInfo() {
        System.out.println(" Название " + this.name + " Дата производства " + this.productionDate +
                " Производитель " + this.manufacturer + " Страна производства "+ this.countryOfOrigin + " Цена " + this.price +
                " Сотстояние бронирования покупателем " + this.bookingStatus);
    }
}