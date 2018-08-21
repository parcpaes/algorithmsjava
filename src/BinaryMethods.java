public class BinaryMethods {
    public static void main(String arg[]){
        int i = 9;
        System.out.println("Number : "+i);
        System.out.println("Binary: "+Integer.toBinaryString(i));
        System.out.println("Number of one bits "+Integer.bitCount(i));
        System.out.println("Higest one bit "+ Integer.highestOneBit(i));
        System.out.println("number of trailing zeros "+ Integer.numberOfTrailingZeros(Integer.highestOneBit(i)));
        System.out.println(Math.log(170)/Math.log(2));
    }
}
