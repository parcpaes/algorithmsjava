import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparar {
    public static class Laptop implements Comparable<Laptop> {
        private String brand;
        private int ram;
        private int price;

        public Laptop(String brand, int ram, int price) {
            this.brand = brand;
            this.ram = ram;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getRam() {
            return ram;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Laptop{" +
                    "brand='" + brand + '\'' +
                    ", ram=" + ram +
                    ", price=" + price +
                    '}';
        }

        @Override
        public int compareTo(Laptop lap2) {
            if(this.brand.compareTo(lap2.brand) == 0){
                return this.ram - lap2.ram;
            }else{
                return this.brand.compareTo(lap2.brand);
            }
        }
    }
    public static void main(String arg[]){
        List<Laptop> laps = new ArrayList<>();
        laps.add(new Laptop("Dell",16,800));
        laps.add(new Laptop("Apple",8,1200));
        laps.add(new Laptop("Acer",12,700));
        Collections.sort(laps);
        for(Laptop l: laps){
            System.out.println(l);
        }
    }
}
