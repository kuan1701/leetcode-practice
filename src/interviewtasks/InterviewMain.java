package interviewtasks;

public class InterviewMain {

    public static void main(String[] args) {
        int[][] doubleArray =
                {
                        {0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0}
                };

        System.out.println(countShipsByHorizontal(doubleArray));
        System.out.println(countShips(doubleArray));
    }

    public static int countShips(int[][] doubleArray) {
        int shipCounter = 0;

        for (int [] intArray : doubleArray) {
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] == 1) {
                    if ((j != intArray.length - 1 && intArray[j + 1] == 1) || (j > 0 && intArray[j - 1] == 0)) {
                        shipCounter++;
                    }
                }
            }
        }

        return shipCounter;
    }

    public static int countShipsByHorizontal(int[][] doubleArray) {
        int shipCounter = 0;

        for (int [] intArray : doubleArray) {
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] == 1) {
                    if (j == 0 || intArray[j - 1] == 0) {
                        shipCounter++;
                    }
                }
            }
        }

        return shipCounter;
    }
}
