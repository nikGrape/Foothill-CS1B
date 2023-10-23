package stack;

class FloatStack extends Stack
{
    public static final float STACK_EMPTY = Float.MIN_VALUE;

    public void pushFloat(float x)
    {
        // don't allow pushing of STACK_EMPTY
        if (x == STACK_EMPTY)
            return;    // could throw an exception when we learn how
        // create a new FloatNode
        FloatNode fp = new FloatNode(x);

        // push the StackNode onto the stack (base class call)
        super.push(fp);
    }

    public float popFloat()
    {
        // pop a node
        FloatNode fp = (FloatNode)pop();
        if (fp == null)
            return STACK_EMPTY;
        else
            return fp.getData();
    }
}
