public class Park {
    private String name;
    private Attraction[] attractions;

    public class Attraction {
        public String name;
        public String workTime;
        public double price;

        public Attraction(String name, String workTime, double price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workTime);
            System.out.println("Стоимость: " + price + " руб.");
        }
    }

    public Park(String name) {
        this.name = name;
    }

    public Park(String name, Attraction[] attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public void displayParkInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Аттракционы:");
        for (int i = 0; i < attractions.length ; i++) {
            attractions[i].displayInfo();

        }

    }

    // Пример использования
    public static void main(String[] args) {
        // Создаем аттракционы

    }
}