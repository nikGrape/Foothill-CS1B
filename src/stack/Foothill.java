package stack;

public class Foothill
{
    public static void main (String[] args)
    {
        Stack stk = new Stack();
        FloatNode p;

        // build the stack
        for (int k = 0; k < 5; k++)
        {
            p = new FloatNode(k + .5f);
            stk.push(p);
        }

        // show the stack, deleting as you pop
        while ( (p = (FloatNode)stk.pop()) != null)
            p.show();
        System.out.println();
    }
}
