package assignment5;

public class QueueEmptyException extends Exception
{
    public QueueEmptyException(){
        super("The queue is empty");
    }
}
