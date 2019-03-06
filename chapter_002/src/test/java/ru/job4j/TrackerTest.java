package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteThenMoveToLeft() {
        Tracker tracker = new Tracker();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker.add(scnd);
        String id = scnd.getId();
        Item thrd = new Item("test2", "testDescription2", 12345L);
        tracker.add(thrd);
        tracker.delete(id);
        Item[] expect = {frst, thrd, null};
        assertThat(tracker.findAll(), is(expect));

    }

    @Test
    public void whenFindAllThenReturnAll() {
        Tracker tracker = new Tracker();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker.add(scnd);
        Item thrd = new Item("test2", "testDescription2", 12345L);
        tracker.add(thrd);
        Item[] expect = {frst, scnd, thrd};
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void whenFindByNameReturnNames() {
        Tracker tracker = new Tracker();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker.add(scnd);
        Item thrd = new Item("test2", "testDescription2", 12345L);
        tracker.add(thrd);
        Item[] expect = {frst, scnd};
        assertThat(tracker.findByName("test1"), is(expect));
    }

    @Test
    public void whenFindByIdReturnItem() {
        Tracker tracker = new Tracker();
        Item frst = new Item("test1", "testDescription0", 123L);
        tracker.add(frst);
        Item scnd = new Item("test1", "testDescription1", 1234L);
        tracker.add(scnd);
        Item thrd = new Item("test2", "testDescription2", 12345L);
        tracker.add(thrd);
        assertThat(tracker.findById(scnd.getId()), is(scnd));
    }

}
