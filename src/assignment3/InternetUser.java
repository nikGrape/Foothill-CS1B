package assignment3;

public class InternetUser
{
    public static int MAX_NAME_LENGTH = 50;
    public static int MIN_NAME_LENGTH = 2;
    public static int MIN_IP_LENGTH = 7;
    public static int MAX_IP_LENGTH = 15;
    public static String DEFAULT_IP = "0.0.0.0";
    public static String DEFAULT_NAME = "default name";

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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String toString()
    {
        return "Name: " + this.name + "\nIP Address: " + this.ip;
    }
}

