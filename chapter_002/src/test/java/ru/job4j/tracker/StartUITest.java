package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.function.Consumer;

public class StartUITest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        public String toString() {
            return out.toString();
        }
    };
        @Test
        public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
            Tracker tracker = new Tracker();     // создаём Tracker
            Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
            new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
            assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        }

        @Test
        public void whenUpdateThenTrackerHasUpdatedValue() {
            // создаём Tracker
            Tracker tracker = new Tracker();
            //Напрямую добавляем заявку
            Item item = tracker.add(new Item("test name", "desc"));
            //создаём StubInput с последовательностью действий(производим замену заявки)
            Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
            // создаём StartUI и вызываем метод init()
            new StartUI(input, tracker, output).init();
            // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
            assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
        }

        @Test
        public void whenDeleteThenTrackerHasNextItem() {
            // создаём Tracker
            Tracker tracker = new Tracker();
            //Напрямую добавляем заявку
            Item item = tracker.add(new Item("test name", "desc"));
            Item item2 = tracker.add(new Item("test name2", "desc2"));
            Input input = new StubInput(new String[]{"3", item.getId(), "6"});
            new StartUI(input, tracker, output).init();
            assertThat(tracker.findAll().get(0).getName(), is("test name2"));
        }

        @Test
        public void whenFindByIdThenTrackerHasItem() {
            Tracker tracker = new Tracker();
            Item item = tracker.add(new Item("test name", "desc"));
            Input input = new StubInput(new String[]{"4", item.getId(), "6"});
            new StartUI(input, tracker, output).init();
            assertThat(tracker.findById(item.getId()).getName(), is("test name"));
        }

        private final StringBuilder menu = new StringBuilder()
                .append("Меню.")
                .append(System.lineSeparator())
                .append("0. Add new Item.")
                .append(System.lineSeparator())
                .append("1. Show all items.")
                .append(System.lineSeparator())
                .append("2. Edit item.")
                .append(System.lineSeparator())
                .append("3. Delete item.")
                .append(System.lineSeparator())
                .append("4. Find item by Id.")
                .append(System.lineSeparator())
                .append("5. Find items by name.")
                .append(System.lineSeparator())
                .append("6. Exit Program.")
                .append(System.lineSeparator());


        @Before
        public void loadOutput() {
            System.out.println("execute before method");
            System.setOut(new PrintStream(this.out));
        }

        @After
        public void backOutput() {
            System.setOut(System.out);
            System.out.println("execute after method");
        }

        @Test
        public void whenShowAllThenTrackerHasAll() {
            // создаём Tracker
            Tracker tracker = new Tracker();
            //Напрямую добавляем заявку
            Item item = tracker.add(new Item("test name", "desc"));
            Item item2 = tracker.add(new Item("test name2", "desc2"));
            Input input = new StubInput(new String[]{"1", "6"});
            new StartUI(input, tracker, output).init();
            assertThat(
                    this.output.toString(),
                    is(menu + new StringBuilder()
                            .append("Name: test name| Desc: desc| Id: ").append(item.getId())
                            .append(System.lineSeparator())
                            .append("Name: test name2| Desc: desc2| Id: ").append(item2.getId())
                            .append(System.lineSeparator())
                            .toString() + menu + "------------ Exit Program --------------" + (System.lineSeparator())

                    ));
        }

        @Test
        public void whenFindNameThenTrackerHasAllItemsByName() {
            // создаём Tracker
            Tracker tracker = new Tracker();
            //Напрямую добавляем заявку
            Item item = tracker.add(new Item("test name", "desc"));
            Item item2 = tracker.add(new Item("test name", "desc2"));
            Input input = new StubInput(new String[]{"5", item.getName(), "6"});
            new StartUI(input, tracker, output).init();
            assertThat(
                    this.output.toString(),
                    is(menu + new StringBuilder()
                            .append("------------ Поиск заявки по имени --------------")
                            .append(System.lineSeparator())
                            .append("Name: test name| Desc: desc| Id: ").append(item.getId())
                            .append(System.lineSeparator())
                            .append("Name: test name| Desc: desc2| Id: ").append(item2.getId())
                            .append(System.lineSeparator())
                            .toString() + menu + "------------ Exit Program --------------" + (System.lineSeparator())
                    ));
        }


    }
