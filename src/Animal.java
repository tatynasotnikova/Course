public class Animal {
    public int swimLim;
    public int runLim;
    public String name;
    public static int animalCount;

    public Animal() {
        animalCount++;
    }


    public void run (int runLength) {
        if (runLength > runLim || runLength < 0) {
            System.out.println(name + " не может пробежать столько");
        } else {
            System.out.println(name + " пробежал/а: " + runLength);
        }
    }

    public void swim(int swimLength) {
         if (swimLength > swimLim || swimLength < 0) {
             System.out.println(name + " не может проплыть столько");
         } else {
             System.out.println(name + " проплыл/а: " + swimLength);
         }
    }

}
