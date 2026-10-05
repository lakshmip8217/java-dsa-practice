class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    void main() {
        increment();
        increment();
        IO.println(getCount());
    }
}
