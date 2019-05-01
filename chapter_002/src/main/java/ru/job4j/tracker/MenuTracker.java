package ru.job4j.tracker;

import java.util.*;
import java.util.function.Consumer;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private StartUI ui;
    private List<UserAction> actions = new ArrayList<>();
    private int key = 0;
    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, StartUI ui, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.ui = ui;
        this.output = output;
    }
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                    item.getName(), item.getDesc(), item.getId()));
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                        item.getName(), item.getDesc(), item.getId()));
            }
        }
    }



    private class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Edit item --------------");
            String id = input.ask("Введите id заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc, id);
            if (tracker.replace(id, item)) {
                output.accept("Ваша заявка отредактирована");
            } else {
                output.accept("Ваша заявка не отредактирована");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Delete item --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                output.accept("Ваша заявка удалена");
            } else {
                output.accept("Ваша заявка не удалена");
            }
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Find item by Id --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                    item.getName(), item.getDesc(), item.getId()));
        }

        }

    private class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            List<Item> items = tracker.findByName(name);
            for (Item item : items) {
                output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                        item.getName(), item.getDesc(), item.getId()));
            }
        }
    }

    private class ExitProgram extends BaseAction {


        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Exit Program --------------");
            ui.stop();
        }
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(key++, "Add new Item."));
        this.actions.add(new ShowItems(key++, "Show all items."));
        this.actions.add(new UpdateItem(key++, "Edit item."));
        this.actions.add(new DeleteItem(key++, "Delete item."));
        this.actions.add(new FindItemById(key++, "Find item by Id."));
        this.actions.add(new FindItemsByName(key++, "Find items by name."));
        this.actions.add(new ExitProgram(key++, "Exit Program."));
    }

   public int[] menuNambers() {
   int[] ranges = new int[getActionsLength()];
       for (int i = 0; i < getActionsLength(); i++) {
           ranges[i] = i;
       } return ranges;
   }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        output.accept("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}