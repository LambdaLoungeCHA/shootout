import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Ya know, I've had it up to here with Yegge and his noun nonsense. If I
 * want to take an indecipherable string of nucleotides and interpret it using
 * even more indecipherable code, I'll do it. And I'll do it in Java. With one
 * profoundly chained line of code, no factory, supplier, or provider
 * anywhere in sight. Sure, there may be an accumulator, maybe a collector,
 * but if you can't see the words that offend you, they don't exist.
 * That's the Clojure/Scala philosophy in a nutshell, right?
 *
 * Copyright (c) 2015 Worldwide Pants, Inc.
 *
 * OBJECTIVIST PUBLIC LICENSE
 * VERSION 1.0, DECEMBER 2015
 *
 * Since the world exists to be exploited, you are free to execute and
 * redistribute this source code, in whole or in part, provided such use
 * personally enriches you and could not be misconstrued as ceding your
 * autonomy to any external force, real or imagined.
 *
 */
public class NuculotideCounter {

    /**
     * Entry point for running the frequency counter on the supplied test string.
     * @param args Supply all the args you want; they will be ignored.
     */
    public static void main(String[] args) {
        System.out.println(countAndReport("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"));
    }

    /**
     * Count the occurrences of A, C, G, and T in a given DNA sequence and
     * return them as a space-separated string. Do it in one line of code
     * because you can.
     * 
     * @param sequence The DNA nucleotide sequence.
     * @return A space-separated string representing the number of occurrences
     * of A, C, G, and T (in that order) in {@code sequence}.
     */
    public static String countAndReport(String sequence) {
        return sequence.chars().boxed().collect(
              groupingBy(identity(), counting())).entrySet().stream()
              .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
              .reduce("", (s, e) -> s.concat(" " + e.getValue()).trim(),
                    String::concat);
    }
}
