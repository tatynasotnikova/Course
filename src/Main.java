public class Main {
    public static void main(String[] args) {

        Park.Attraction[] attractions = {
                new Park("").new Attraction("Американские горки", "10:00-20:00", 350.0),
                new Park("").new Attraction("Колесо обозрения", "09:00-22:00", 200.0),
                new Park("").new Attraction("Карусель", "10:00-18:00", 150.0)
        };

        Park park = new Park("Диснейленд", attractions);

        park.displayParkInfo();

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",

                "Samsung Corp.", "Korea", 5599, true);


        productsArray[1] = new Product("Iphone 15", "02.03.2024",
                "Apple Corp.", "China", 6000, false);

        productsArray[2] = new Product("Iphone 16", "04.03.2025",
                "Apple Corp.", "China", 7500, false);

        productsArray[3] = new Product("Iphone 16", "02.03.2024",
                "Apple Corp.", "China", 7000, true);

        productsArray[4] = new Product("Huawei Pura 80", "10.05.2025",
                "Huawei Corp.", "China", 5500, false);

        for (int i = 0; i < productsArray.length ; i++) {
            productsArray[i].productInfo();
        }
    }
}
