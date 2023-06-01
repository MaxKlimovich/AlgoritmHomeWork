public class PiramidaSerchHomeWork2Sem {
    public static void main(String[] args) {
        int[] array = new int[]{
                4, 2, 5, 6, 3, 7, 9, 7, 8, 0
        };

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        // Один за другим извлекаем элементы из кучи
        for (int  i = array.length -1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // нициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый 2*rootIndex + 1
        int rightChild = 2 * rootIndex + 2; // правый = 2*rootsIndex2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = rightChild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        // если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
