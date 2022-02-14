package santander.coders.rebels.ic.utils;

import santander.coders.rebels.ic.domain.Rebel;

public class Utils {
    public static Rebel[] selectionSortByName(Rebel array[]) {
        int i, j, minIndex;
        for (i = 0; i < array.length-1; i++) {
            minIndex = i;
            for (j = i+1; j < array.length; j++) {
                if (array[j].getName().compareToIgnoreCase(array[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }

            Rebel temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static Rebel[] selectionSortByAge(Rebel array[]) {
        int i, j, minIndex;
        for (i = 0; i < array.length-1; i++) {
            minIndex = i;
            for (j = i+1; j < array.length; j++) {
                if (array[j].getAge() < array[minIndex].getAge()) {
                    minIndex = j;
                }
            }

            Rebel temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static Rebel[] selectionSortByRaceKind(Rebel array[]) {
        int i, j, minIndex;
        for (i = 0; i < array.length-1; i++) {
            minIndex = i;
            for (j = i+1; j < array.length; j++) {
                if (array[j].getRace().ordinal() < array[minIndex].getRace().ordinal()) {
                    minIndex = j;
                }
            }

            Rebel temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
