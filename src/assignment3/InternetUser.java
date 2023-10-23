package assignment3;

public class InternetUser
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

