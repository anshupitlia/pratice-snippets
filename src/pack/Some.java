package pack;

public class Some {
    public static void main(String[] args) {
        int[] A = new int[]{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        solution(A);
    }
    public static int solution(int[] A) {
        int[][] stableMovements = new int[100][2];
        int stableMovementIndex = 0;
        int diff = 0;
        int minIndex = 0;
        int maxIndex = 0;
        int[] returnValue = loop(minIndex, A);
        if (returnValue[2]  == 1) {
            stableMovements[stableMovementIndex][0] = returnValue[0];
            stableMovements[stableMovementIndex][1] = returnValue[1];
            stableMovementIndex++;
        }
        maxIndex = returnValue[1];;
        while (maxIndex < A.length - 1) {
            returnValue = loop(maxIndex, A);
            if (returnValue[2]  == 1) {
                stableMovements[stableMovementIndex][0] = returnValue[0];
                stableMovements[stableMovementIndex][1] = returnValue[1];
                stableMovementIndex++;
            }
            maxIndex = returnValue[1];
        }
        System.out.println(stableMovements.toString());

        return 0;
    }

    public static int[] loop(int minIndex, int[] A) {
        int maxIndex = 0;
        int atLeastCount = 2;
        int diff = A[minIndex] - A[minIndex + 1];
        int i;
        for (i = minIndex; i < A.length - 1; i++, atLeastCount--) {
            if (diff != A[i] - A[i+1]) {
                break;
            }
        }
        maxIndex = i;
        int[] returnValue = new int[3];
        returnValue[0] = minIndex;
        returnValue[1] = maxIndex;
        if ( atLeastCount <= 0) {
            returnValue[2] = 1;
        }
        else returnValue[2] = 0;
        return returnValue;
    }

}
