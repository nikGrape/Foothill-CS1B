package submission3B;

import java.util.Random;

/**
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 * @version 1.0
 * <p>
 * This class is used to perform second phase of tests for Communicator class
 */
public class Foothill
{
    public static void main(String[] args)
    {
        Communicator c0 = new Communicator();
        Communicator c1 = new Communicator(36, 360);
        Communicator c2 = new Communicator("Nick", "1.1.1.2");
        Communicator c3 = new Communicator(283, 1129);
        Communicator c4 = new Communicator("Anurag", "1.1.1.1", 557, 7);

        System.out.print("Derived Class Constructor Testing ***************");
        System.out.println(c0);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}

/* ---------------------------------------------------------
Derived Class Constructor Testing ***************
----------------
Name: (undefined)
IP Address: 0.0.0.0

(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0
public key:(0, 0)
private key:(0, 0)


----------------
Name: (undefined)
IP Address: 0.0.0.0

(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0
public key:(0, 0)
private key:(0, 0)


----------------
Name: Nick
IP Address: 1.1.1.2

(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0
public key:(0, 0)
private key:(0, 0)


----------------
Name: (undefined)
IP Address: 0.0.0.0

(p, q) n, phi, e, d: (283, 1129) 319507, 318096, 181, 98853
public key:(181, 319507)
private key:(98853, 319507)


----------------
Name: Anurag
IP Address: 1.1.1.1

(p, q) n, phi, e, d: (557, 7) 3899, 3336, 181, 517
public key:(181, 3899)
private key:(517, 3899)


Process finished with exit code 0
--------------------------------------------------------- */

/**
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 * @version 1.0
 * <p>
 * This class is used to perform first phase of tests for InternetUser class
 */
class FoothillPhase1
{
    public static void main(String[] args)
    {
        InternetUser user1 = new InternetUser();
        InternetUser user2 = new InternetUser("Anurag", "1.1.1.1");
        InternetUser user3 = new InternetUser("Nick", "1.1.1.2");

        user1.setName("John Doe");
        user1.setIp("9.9.9.9");

        System.out.println("Base Class Testing ***********************\n");
        System.out.println(user1);
        System.out.println();
        System.out.println(user2);
        System.out.println();
        System.out.println(user3);
    }
}

/* ---------------------------------------------------------
Base Class Testing ***********************

Name: John Doe
IP Address: 9.9.9.9

Name: Anurag
IP Address: 1.1.1.1

Name: Nick
IP Address: 1.1.1.2

--------------------------------------------------------- */


/**
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 * @version 1.0
 * <p>
 * This class is used to perform option B phase of tests for IuStack
 */
class FoothillOptionB
{
    public static void main(String[] args)
    {
        IuStack stack = new IuStack();

        stack.pushInternetUser(new Communicator("Bad User", "", 36, 360));
        stack.pushInternetUser(new Communicator("John Doe", "0.0.0.0",283, 1129));
        stack.pushInternetUser(new Communicator("Nick", "1.1.1.2"));
        stack.pushInternetUser(new Communicator("Anurag", "1.1.1.1", 557, 7));

        System.out.println("---------------");

        InternetUser user;
        while((user = stack.popInternetUser()) != IuStack.STACK_EMPTY) {
            System.out.println(user);
        }
    }
}

/**
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 * @version 1.0
 * <p>
 * one object of this class represents an Internet User
 */
class InternetUser
{
    public final static int MAX_NAME_LENGTH = 50;
    public final static int MIN_NAME_LENGTH = 2;
    public final static int MIN_IP_LENGTH = 7;
    public final static int MAX_IP_LENGTH = 15;
    public final static String DEFAULT_IP = "0.0.0.0";
    public final static String DEFAULT_NAME = "(undefined)";

    private String name;
    private String ip;

    public InternetUser(String name, String ip)
    {
        if (validateIP(ip))
        {
            this.ip = ip;
        } else
        {
            this.ip = DEFAULT_IP;
        }
        if (validateName(name))
        {
            this.name = name;
        } else
        {
            this.name = DEFAULT_NAME;
        }
    }

    private boolean validateIP(String ip)
    {
        return ip.length() >= MIN_IP_LENGTH && ip.length() <= MAX_IP_LENGTH;
    }

    private boolean validateName(String name)
    {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public InternetUser()
    {
        this.name = DEFAULT_NAME;
        this.ip = DEFAULT_IP;
    }

    public String getName()
    {
        return name;
    }

    public boolean setName(String name)
    {
        if (validateName(name))
        {
            this.name = name;
            return true;
        }
        return false;
    }

    public String getIp()
    {
        return ip;
    }

    public boolean setIp(String ip)
    {
        if (validateIP(ip))
        {
            this.ip = ip;
            return true;
        }
        return false;
    }

    public String toString()
    {
        return "Name: " + this.name + "\nIP Address: " + this.ip + "\n\n";
    }
}

/**
 * IntPair allows public, no filtering; classes that use it will protect it
 *
 * @author Michael Loceff
 */
class IntPair
{
    public long firstInt;
    public long secondInt;

    // constructors
    IntPair()
    {
        firstInt = secondInt = 0;
    }

    IntPair(long frst, long scnd)
    {
        firstInt = frst;
        secondInt = scnd;
    }

    public String toString()
    {
        return "(" + firstInt + ", " + secondInt + ")";
    }
}

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
        long lowPrimes[] = { 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
                113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
                233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353,
                359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479,
                487, 491, 499, 503, 509, 521, 523, 541 };
        long arraySize = lowPrimes.length;

        // pick prime in the above array bet 0 and arraySize - 1
        index = (int) (randObject.nextDouble() * arraySize);

        return lowPrimes[index];
    }

    public static long getMedSizedRandomPrime()
    {
        int index;
        Random randObject = new Random(System.currentTimeMillis());
        long lowPrimes[] = { 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
                647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787,
                797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937,
                941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061,
                1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187,
                1193, 1201, 1213, 1217, 1223 };
        long arraySize = lowPrimes.length;

        // pick prime in the above array bet 0 and arraySize - 1
        index = (int) (randObject.nextDouble() * arraySize);

        return lowPrimes[index];
    }
}

/**
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 * @version 1.0
 * <p>
 * one object of this class represents a Communicator
 */
class Communicator extends InternetUser
{
    public static final int ERROR_FLAG_NUM = 0;
    private static final double MAX_PQ = Math.sqrt(Long.MAX_VALUE);
    private IntPair publicKey;
    private IntPair privateKey;
    private long firstPrime;
    private long secondPrime;
    private long n, phi, e, d;

    Communicator()
    {
        super();
        firstPrime = secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
        publicKey = new IntPair(0, 0);
        privateKey = new IntPair(0, 0);
    }

    Communicator(long firstPrime, long secondPrime)
    {
        super();
        if (!setPrimes(firstPrime, secondPrime))
        {
            this.firstPrime = this.secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
            publicKey = new IntPair(0, 0);
            privateKey = new IntPair(0, 0);
        }
    }

    Communicator(String name, String ip)
    {
        super(name, ip);
        firstPrime = secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
        publicKey = new IntPair(0, 0);
        privateKey = new IntPair(0, 0);
    }

    Communicator(String name, String ip, long firstPrime, long secondPrime)
    {
        super(name, ip);
        if (!setPrimes(firstPrime, secondPrime))
        {
            this.firstPrime = this.secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
            publicKey = new IntPair(0, 0);
            privateKey = new IntPair(0, 0);
        }
    }

    public boolean setPrimes(long p, long q)
    {
        if (p == q)
            return false;

        this.firstPrime = p;
        this.secondPrime = q;
        return computeBothEncrKeys();
    }

    public IntPair getPublicKey()
    {
        return publicKey;
    }

    public IntPair getPrivateKey()
    {
        return privateKey;
    }

    private boolean computeBothEncrKeys() {
        if(!EncryptionSupport.isPrime(firstPrime) || !EncryptionSupport.isPrime(secondPrime))
            return false;

        n = firstPrime * secondPrime;
        phi = (firstPrime - 1) * (secondPrime - 1);
        e = EncryptionSupport.getSmallRandomPrime();

        long numTries = 0;
        while(e > phi || phi % e == 0) {
            if (numTries > 10_000_000)
                return false;
            e = EncryptionSupport.getSmallRandomPrime();
            numTries++;
        }

        d = EncryptionSupport.inverseModN(e, n);
        publicKey = new IntPair(e, n);
        privateKey = new IntPair(d, n);
        return true;
    }

    @Override public String toString()
    {
        return "\n----------------\n" + super.toString().trim() + String.format(
                "%n%n(p, q) n, phi, e, d: (%d, %d) %d, %d, %d, %d%n", firstPrime, secondPrime, n, phi, e,
                d) + String.format("public key:%s%nprivate key:%s%n", publicKey, privateKey);
    }
}


class IuStack extends Stack
{
    public static final InternetUser STACK_EMPTY = new InternetUser("", "");

    public void pushInternetUser(InternetUser x)
    {
        IuNode fp = new IuNode(x);
        super.push(fp);
    }

    public InternetUser popInternetUser()
    {
        IuNode fp = (IuNode) pop();
        if (fp == null)
            return STACK_EMPTY;
        else
            return fp.getData();
    }
}

class IuNode extends StackNode
{
    private InternetUser data;

    public IuNode(InternetUser x)
    {
        super();
        if (x == null)
            data = new InternetUser("", "");
        else
            data = x;
    }

    public InternetUser getData()
    {
        return data;
    }

    @Override public String toString()
    {
        return (data == null) ? "[0.0.0.0]" : "[" + data + "]";
    }
}

class Stack
{
    private StackNode top;

    public Stack()
    {
        top = null;
    }

    public void push(StackNode newNode)
    {
        if (newNode == null)
            return;
        newNode.next = top;
        top = newNode;
    }

    public StackNode pop()
    {
        StackNode temp;

        temp = top;
        if (top != null)
        {
            top = top.next;
            temp.next = null;
        }
        return temp;
    }

    @Override public String toString()
    {
        StringBuilder output = new StringBuilder();
        StackNode p;

        for (p = top; p != null; p = p.next)
            output.append(p);

        return output.toString();
    }

    public void showStack()
    {
        System.out.println(this);
    }
}

class StackNode
{
    protected StackNode next;

    public StackNode()
    {
        next = null;
    }

    @Override public String toString()
    {
        return " (generic node) ";
    }

    public void show()
    {
        System.out.println(this);
    }
}