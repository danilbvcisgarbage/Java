import java.util.*;

// Клас CoffeeList, що реалізує інтерфейс List
public class CoffeeList<T extends Coffee> implements List<T> {

    // Внутрішній клас Node для однозв'язного списку
    private static class Node<T> {
        T data;         // Дані у вузлі
        Node<T> next;   // Посилання на наступний вузол

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Голова списку
    private int size;     // Розмір списку

    // Конструктор: порожній список
    public CoffeeList() {
        this.head = null;
        this.size = 0;
    }

    // Конструктор, що приймає один об'єкт Coffee
    public CoffeeList(T coffee) {
        this();
        add(coffee);
    }

    // Конструктор, що приймає стандартну колекцію об'єктів Coffee
    public CoffeeList(Collection<? extends T> coffees) {
        this();
        addAll(coffees);
    }

    // Додати елемент у кінець списку
    @Override
    public boolean add(T coffee) {
        Node<T> newNode = new Node<>(coffee);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    // Додати елемент на певну позицію
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Отримати елемент за індексом
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Видалити елемент за індексом
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<T> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = removedNode.next;
        }
        size--;
        return removedNode.data;
    }

    // Отримати розмір списку
    @Override
    public int size() {
        return size;
    }

    // Перевірка на порожність
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистити список
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    // Конвертувати в масив
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    // Додати всі елементи з колекції
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T coffee : c) {
            add(coffee);
        }
        return true;
    }

    // Додаткові методи List
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
