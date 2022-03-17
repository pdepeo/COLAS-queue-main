public class QueueImpl<E> implements Queue<E>{

    private E[] data;
    private int max;
    private int p;

    public QueueImpl(int max)
    {
        this.data = (E[]) new Object[max];
        this.max = max;
        this.p = 0;
    }


    @Override
    public E pop() throws EmptyQueueException {
        E e;
        if (this.p != 0) {
            e = data[0];

            for (int i = 0; i < this.p-1; i++)
                data[i] = data[i + 1];

            data[this.p-1] = null;
            this.p--;
            return e;
        }
        else
            throw new EmptyQueueException();

    }

    @Override
    public void push(E e) throws FullQueueException {
        if (this.p < max) {
            data[this.p] = e;
            this.p++;
        }
        else
            throw new FullQueueException();
    }

    @Override
    public int size() {
        return this.p;
    }

    public static void main (String[] args) {
        Queue<Integer> q = new QueueImpl<Integer>(5);
        try {
            q.push(7);
            q.push(2);
            q.push(1);
            q.push(3);
            q.push(5);

        } catch (FullQueueException e) {
            e.printStackTrace();
        }

        try {

            System.out.println("Position 1 = " + q.pop());
            System.out.println("Position 2 = " + q.pop());
            System.out.println("Position 3 = " + q.pop());
            System.out.println("Position 4 = " + q.pop());
            System.out.println("Position 5 = " + q.pop());

        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }

        System.out.println("Size = " + q.size());

    }
}

