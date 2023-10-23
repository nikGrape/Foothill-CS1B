package assignment3;

public class FoothillOptionB
{
    public static void main(String[] args)
    {
        IuStack stack = new IuStack();

        stack.pushInternetUser(new Communicator("Bad User", "", 36, 360));
        stack.pushInternetUser(new Communicator("John Doe", "0.0.0.0",283, 1129));
        stack.pushInternetUser(new Communicator("Nick", "1.1.1.2"));
        stack.pushInternetUser(new Communicator("Anurag", "1.1.1.1", 557, 7));

        System.out.println(stack);
        System.out.println("---------------");

//        InternetUser user;
//        while((user = stack.popUser()) != null) {
//            System.out.println(user);
//        }

    }
}

/*----------------
----------------
Name: Anurag
IP Address: 1.1.1.1

(p, q) n, phi, e, d: (557, 7) 3899, 3336, 293, 2036
public key:(293, 3899)
private key:(2036, 3899)


----------------
Name: Nick
IP Address: 1.1.1.2

(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0
public key:(0, 0)
private key:(0, 0)


----------------
Name: John Doe
IP Address: 0.0.0.0

(p, q) n, phi, e, d: (283, 1129) 319507, 318096, 293, 235541
public key:(293, 319507)
private key:(235541, 319507)


----------------
Name: Bad User
IP Address: 0.0.0.0

(p, q) n, phi, e, d: (0, 0) 0, 0, 0, 0
public key:(0, 0)
private key:(0, 0)


Process finished with exit code 0
 */
