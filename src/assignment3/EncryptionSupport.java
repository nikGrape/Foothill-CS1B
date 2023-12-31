package assignment3;

import java.util.Random;

/**
 * EncryptionSupport contains only static methods that clients can use wherever
 * all method names should be fairly descriptive other than inverseMonN(), which
 * you can take as a black-box (see description of assignment)
 * 
 * @author Michael Loceff
 * @author Baba Kofi Weusijana
 */
class EncryptionSupport
{
    public static boolean isPrime(long x)
    {
        long k, loopLim;

        if (x < 2)
            return false;
        if (x < 4)
            return true;
        if (x % 2 == 0 || x % 3 == 0)
            return false;

        // now use the fact the all primes of form 6k +/- 1
        loopLim = (long) Math.sqrt(x);
        for (k = 5; k <= loopLim; k += 6)
        {
            if (x % k == 0 || x % (k + 2) == 0)
                return false;
        }
        return true;
    }

    public static long inverseModN(long a, long n)
    {
        // uses extended euclidean algorithm giving as + nt = gcd(n, a),
        // with gcd(n, a) = 1, and s, t discovered. s = 1/a, and t ignored

        long s, t, r, sPrev, tPrev, rPrev, temp, q, inverse;

        // special key encryption conditions; we will pick some prime e >= 3 for a
        if (a < 3 || a >= n || !isPrime(a))
            return 0; // error

        // we are now guaranteed 3 <= a < n and gcd(a, n) = 1;

        // initialize working variables
        s = 0;
        t = 1;
        r = n;
        sPrev = 1;
        tPrev = 0;
        rPrev = a;

        while (r != 0)
        {
            q = rPrev / r;

            temp = r;
            r = rPrev - q * r;
            rPrev = temp;

            temp = s;
            s = sPrev - q * s;
            sPrev = temp;

            temp = t;
            t = tPrev - q * t;
            tPrev = temp;
        }

        inverse = sPrev % n;
        if (inverse < 0)
            inverse += n;
        return inverse;
    }

    public static long getSmallRandomPrime()
    {
        int index;
        Random randObject = new Random(System.currentTimeMillis());
        long lowPrimes[] =
        { 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
                137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,
                251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373,
                379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
                503, 509, 521, 523, 541 };
        long arraySize = lowPrimes.length;

        // pick prime in the above array bet 0 and arraySize - 1
        index = (int) (randObject.nextDouble() * arraySize);

        return lowPrimes[index];
    }

    public static long getMedSizedRandomPrime()
    {
        int index;
        Random randObject = new Random(System.currentTimeMillis());
        long lowPrimes[] =
        { 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661,
                673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821,
                823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967,
                971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087,
                1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213,
                1217, 1223 };
        long arraySize = lowPrimes.length;

        // pick prime in the above array bet 0 and arraySize - 1
        index = (int) (randObject.nextDouble() * arraySize);

        return lowPrimes[index];
    }
}