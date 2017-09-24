/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

/**
 *
 * @author Rene Deicker
 */
import java.util.LinkedList;
import java.util.List;
public class Gcd {
    public static void main(String[] args) {
        int counter = 1;
        System.out.printf("Example %d, numbers: 1989, 867\n",counter++);
        System.out.printf("     Eucledian Algorithm: %d\n",gcdEucledian(1989, 867));
        System.out.printf("     PrimeFactors Algorithm: %d\n",gcdPrimeFactors(1989, 867));
        System.out.printf("Example %d, numbers: 8, 32\n",counter++);
        System.out.printf("     Eucledian Algorithm: %d\n",gcdEucledian(8, 32));
        System.out.printf("     PrimeFactors Algorithm: %d\n",gcdPrimeFactors(8, 32));
        System.out.printf("Example %d, numbers: 654, 894\n",counter++);
        System.out.printf("     Eucledian Algorithm: %d\n",gcdEucledian(654, 894));
        System.out.printf("     PrimeFactors Algorithm: %d\n",gcdPrimeFactors(654, 894));
        System.out.printf("Example %d, numbers: 65, 50\n",counter++);
        System.out.printf("     Eucledian Algorithm: %d\n",gcdEucledian(65, 50));
        System.out.printf("     PrimeFactors Algorithm: %d\n",gcdPrimeFactors(65, 50));
    }

    private static int gcdPrimeFactors(int a, int b) {
        List<Integer> listOfDividersA = new LinkedList<>();
        int divider = 2,gcd = 1;
        while(a > 1){
            if (a%divider == 0) {
                a /= divider;
                listOfDividersA.add(divider);
            }
            else divider++;
        }        
        divider = 2;
        while(b > 1){
            if (b%divider == 0) {
                b /= divider;
                if(listOfDividersA.contains(divider)){
                    gcd*=divider;
                    listOfDividersA.remove(listOfDividersA.indexOf(divider));
                }
            }
            else divider++;
        }
        return gcd;
    }

    private static int gcdEucledian(int a, int b) {
        int cacheA;
        do {
            cacheA = a;
            a = b;
            b = cacheA % a;
        } while (b > 0);
        return a;
    }
    
}
