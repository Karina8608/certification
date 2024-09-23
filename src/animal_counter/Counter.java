package animal_counter;

class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public void add() {
        if (closed) {
            throw new IllegalStateException("Ресурс закрыт!");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count == 0) {
            throw new Exception("Ошибка: не было добавлено ни одного животного.");
        }
        closed = true;
        System.out.println("Счетчик закрыт. Добавлено животных: " + count);
    }
}

