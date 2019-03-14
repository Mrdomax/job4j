package ru.job4j.tracker;

import java.util.*;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;

    private StartUI ui;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, StartUI ui) {
        this.input = input;
        this.tracker = tracker;
        this.ui = ui;
    }
    private class AddItem implements UserAction {

        public AddItem(int key, String info) {

        }

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }

        @Override
        public String info() {
            return "0. Add new Item.";
        }
    }

    private class ShowItems implements UserAction {

        public ShowItems(int key, String info) {

        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println();
            System.out.println();
            System.out.println("------------ Список всех заявок --------------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("Имя заявки: " + item.getName());
                System.out.println("Описание заявки: " + item.getDesc());
                System.out.println("Id заявки: " + item.getId());
                System.out.println("----------------------------------------------");
            }
            System.out.println();
            System.out.println();
        }

        @Override
        public String info() {
            return "1. Show all items.";
        }
    }

    private class UpdateItem implements UserAction {

        public UpdateItem(int key, String info) {

        }

        @Override
        public int key() {
            return 2;
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Edit item --------------");
            String id = input.ask("Введите id заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc, id);
            if (tracker.replace(id, item)) {
                System.out.println("Ваша заявка отредактирована");
            } else {
                System.out.println("Ваша заявка не отредактирована");
            }
        }

        @Override
        public String info() {
            return "2. Edit item.";
        }
    }

    private class DeleteItem implements UserAction {

        public DeleteItem(int key, String info) {

        }

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                System.out.println("Ваша заявка удалена");
            } else {
                System.out.println("Ваша заявка не удалена");
            }

        }

        @Override
        public String info() {
            return "3. Delete item.";
        }

    }

    private class FindItemById implements UserAction {

        public FindItemById(int key, String info) {

        }

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by Id --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Описание заявки: " + item.getDesc());
            System.out.println("Id заявки: " + item.getId());

        }

        @Override
        public String info() {
            return "4. Find item by Id.";
        }

    }

    private class FindItemsByName implements UserAction {

        public FindItemsByName(int key, String info) {

        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println("Имя заявки: " + item.getName());
                System.out.println("Описание заявки: " + item.getDesc());
                System.out.println("Id заявки: " + item.getId());
                System.out.println("----------------------------------------------");
            }
        }

        @Override
        public String info() {
            return "5. Find items by name.";
        }

    }

    private class ExitProgram implements UserAction {


        public ExitProgram(int key, String info) {

        }

        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Exit Program --------------");
            ui.stop();
        }

        @Override
        public String info() {
            return "6. Exit Program.";
        }

    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
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
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}