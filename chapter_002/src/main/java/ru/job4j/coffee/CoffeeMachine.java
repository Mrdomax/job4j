package ru.job4j.coffee;


import java.util.Arrays;

public class CoffeeMachine {
    /**
     *
     * @param value
     * @param price
     * @return
     * changes.length = 502 это максимальное количество монет в сдаче с 5000-й купюры.
     * В обычных кофемашинах принимают максимум 500р. Тогда changes.length можно сделать всего 52
     * Или можно вывести рассчет changes.length в отдельный метод и использовать агрегацию.
     */
    public int[] coffeeMachine(int value, int price) {
        int[] changes = new int[502];
        int i = 0;
        int[] coins = new int[] {10, 5, 2, 1};
        int change = value - price;
        for (int coin : coins) {
            while (change - coin >= 0) {
                changes[i] = coin;
                change = change - coin;
                i++;
            }
        }
        return Arrays.copyOf(changes, i);
    }
}
