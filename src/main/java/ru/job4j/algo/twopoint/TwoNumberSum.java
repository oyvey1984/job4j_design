package ru.job4j.algo.twopoint;

public class TwoNumberSum {
    public static int[] getIndexes(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] getIndexes2Point(int[] array, int target) {
        /*
         * Инициализируем два указателя: left в начале массива, right в конце
         */
        int left = 0;
        int right = array.length - 1;

        /*
         * Пока левый указатель меньше правого (не пересеклись)
         */
        while (left < right) {
            /*
             * Вычисляем сумму элементов на текущих позициях указателей
             */
            int sum = array[left] + array[right];

            /*
             * Если сумма равна целевому значению
             */
            if (sum == target) {
                /*
                 * Возвращаем индексы найденной пары
                 */
                return new int[]{left, right};
            } else if (sum < target) {
                /*
                 * Если сумма меньше целевого значения
                 * Увеличиваем левый указатель (нужна большая сумма)
                 */
                left++;
            } else {
                /*
                 * Если сумма больше целевого значения
                 * Уменьшаем правый указатель (нужна меньшая сумма)
                 */
                right--;
            }
        }

        /*
         * Если пара не найдена, возвращаем пустой массив
         */
        return new int[0];
    }
}