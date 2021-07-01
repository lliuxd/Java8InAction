package jucpractice;

public class TestVolatile {

    public static void main(String[] args) {
        int i = 10;
        i = i++;
        System.out.println(i);

        int j = 20;
//        j = ++j;
        System.out.println(j);
        j = j + 1;
        int temp1 = j;
        j = temp1;
        System.out.println(j);

//        System.out.println(temp);
    }

}


