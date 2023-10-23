package assignment3;

public class Foothill
{
    public static void main(String[] args)
    {
        Communicator c1 = new Communicator(36, 360);
        Communicator c2 = new Communicator("Nick", "1.1.1.2");;
        Communicator c3 = new Communicator(283, 1129);
        Communicator c4 = new Communicator("Anurag", "1.1.1.1", 557, 7);

        System.out.print("Derived Class Constructor Testing ***************");
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
Name: Nick
IP Address: 1.1.1.2

(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0
public key:(0, 0)
private key:(0, 0)


----------------
Name: (undefined)
IP Address: 0.0.0.0

(p, q) n, phi, e, d: (283, 1129) 319507, 318096, 131, 160973
public key:(131, 319507)
private key:(160973, 319507)


----------------
Name: Anurag
IP Address: 1.1.1.1

(p, q) n, phi, e, d: (557, 7) 3899, 3336, 131, 2768
public key:(131, 3899)
private key:(2768, 3899)


Process finished with exit code 0

--------------------------------------------------------- */
