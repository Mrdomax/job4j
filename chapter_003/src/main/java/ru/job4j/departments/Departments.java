package ru.job4j.departments;
import java.util.*;

public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            int result = 0;
            for(String aa: deps) {
                result = aa.compareTo(o.deps.listIterator().next());
            }
            if (result == 0) {
                result = this.deps.size() - o.deps.size();
            }
            return result;
        }

        @Override
        public String toString() {
            return deps.toString();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Org org = (Org) o;

            return this.deps.equals(org.deps);
        }

        public int hashCode() {
            return this.deps.hashCode();
        }
    }

    /**
     * Метод разделяет deps на составные части. Потом вложенными циклами создаёт иерархию подразделений.
     * @param deps лист ещё неразделенных строк
     * @return Метод должен возвращать List<Org> orgs уже отсортированных по шаблону.
     */

    public List<Org> convert(List<String> deps) {
        List<Org> orgs = new ArrayList<>();
        for(String aa: deps) {
            String[] divided = aa.split("\\W");
            List<String> temp = Arrays.asList(divided);
            for (int i = 0; i < temp.size(); i++) {
                List<String> tempMain = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    tempMain.add(temp.get(j));
                }
                Org org = new Org(tempMain);
                orgs.add(org);
            }
            }
        Collections.sort(orgs);
        return orgs;
    }

    public List<Org> sortAsc(List<Org> orgs) {
        return orgs;
    }

    public List<Org> sortDesc(List<Org> orgs) {
        orgs.sort(
                new Comparator<Org>() {
                    @Override
                    public int compare(Org o1, Org o2) {
                        int result = 0;
                        for (int i = 0; i < o1.deps.size() && i < o2.deps.size(); i++) {
                            result = o2.deps.listIterator().next().compareTo(o1.deps.listIterator().next());
                        }
                        if(result == 0) {
                            result = o1.deps.size() - o2.deps.size();
                        }
                        return result;
                    }
                }
        );
        return orgs;
    }
}
