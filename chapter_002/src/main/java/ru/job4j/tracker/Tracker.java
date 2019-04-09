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
    private final List<Item> items = new ArrayList<>();
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
        this.items.add(this.position++, item);
        return item;
    }

    /**
     * Метод возвращает все ячейки массива
     * @return
     */
    public List<Item> findAll() {
        return items;
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
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item a : items) {
            if (a != null && a.getName().equals(key)) {
                result.add(a);
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
                if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                    item.setId(id);
                    this.items.set(i, item);
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
            if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }
}
