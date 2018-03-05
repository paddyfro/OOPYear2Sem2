// Question 9 - Find Prime numbers - using Set (is Set necessary?) 
package week3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Question09 {
    public static void main(String args[])
    {
        Question09 q = new Question09();
        q.start();
    }

    public void start()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What number would you like to find primes up to?");
        int num = in.nextInt();
        Set<Integer> candidates = findPrimes(num);
        Iterator<Integer> iter = candidates.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
            if (iter.hasNext()) {
                System.out.print(",");
            }
        }
    }

    private Set<Integer> findPrimes(int N)
    {
        Set<Integer> candidates = new HashSet<>();
        for (int i = 2; i <= N; i++) {
            candidates.add(i);
        }
        int mult = 0;
        for (int i = 2; i < N; i++) {
            mult = 0;
            int count = 2;
            if (candidates.contains(i)) {
                while (mult < N) {
                    mult = i * count;
                    count++;
                    candidates.remove(mult);
                }
            }
        }

        return candidates;
    }

}
