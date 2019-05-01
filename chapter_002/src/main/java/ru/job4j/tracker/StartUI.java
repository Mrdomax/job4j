package ru.job4j.tracker;
import java.util.*;
import java.util.function.Consumer;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Consumer<String> output;
    private final Input input;
    private final Tracker tracker;
    private boolean working = true;


    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }


    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this, output);
        menu.fillActions();
        int[] ranges = menu.menuNambers();
        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}