package assignment3;

public class FoothillPhase1
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
