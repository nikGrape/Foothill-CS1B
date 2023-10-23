package assignment3;

public class Communicator extends InternetUser
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
        if (p != q)
        {
            this.firstPrime = p;
            this.secondPrime = q;
            return computeBothEncrKeys(p, q);
        }

        return false;

    }

    public IntPair getPublicKey()
    {
        return publicKey;
    }

    public IntPair getPrivateKey()
    {
        return privateKey;
    }

    private boolean computeBothEncrKeys(long p, long q)
    {
        if (!EncryptionSupport.isPrime(p) || !EncryptionSupport.isPrime(q))
            return false;

        n = p * q;
        phi = (p - 1) * (q - 1);

        long randomPrime;
        int attempts = 10_000_000;
        do
        {
            randomPrime = EncryptionSupport.getSmallRandomPrime();
            if (attempts-- <= 0)
                return false;
        } while (randomPrime > phi || phi % randomPrime == 0); //TODO ??? LAS THAN

        e = randomPrime;
        d = EncryptionSupport.inverseModN(e, n);

        publicKey = new IntPair(e, n);
        privateKey = new IntPair(d, n);

        return true;
    }

    @Override public String toString()
    {
        return "\n----------------\n" + super.toString().trim() + String.format("%n%n(p, q) n, phi, e, d: (%d, %d) %d, %d, %d, %d%n", firstPrime,
                secondPrime, n, phi, e, d) + String.format("public key:%s%nprivate key:%s%n", publicKey, privateKey);
    }
}
