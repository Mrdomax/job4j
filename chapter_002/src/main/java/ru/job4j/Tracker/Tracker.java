package ru.job4j.tracker;
import java.util.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private String id;
    private static final Random RN = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод возвращает все ячейки массива
     * @return
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Возвращает значение item по его id
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает item с заданным именем
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position - 1];
        for (int i = 0; i != this.position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                System.arraycopy(items, i, result, i, 1);
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     *  Метод public boolean replace(String id, Item item) должен заменить ячейку в массиве this.items.
     *  Для этого необходимо найти ячейку в массиве по id.
     *  Метод должен вернуть boolean результат - удалось ли провести операцию.
     * @param id
     * @param item
     * @return
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                this.items[i].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     *  Метод public boolean delete(String id) должен удалить ячейку в массиве this.items.
     *  Для этого необходимо найти ячейку в массиве по id.
     *  Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy().
     *  Метод должен вернуть boolean результат - удалось ли провести операцию.
     * @param id
     * @return
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, this.position - i);
                result = true;
                break;
            }
        }
        return result;
    }
}
