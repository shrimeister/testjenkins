import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tests = br.readLine();

        int numTests = Integer.parseInt(tests);

        if( numTests >= 1 && numTests <= 3) {
            String cellSize = br.readLine();

            String[] cellSizeSplit = cellSize.split(" ");

            if (cellSizeSplit.length == 3) {
                int x = Integer.parseInt(cellSizeSplit[0]);
                int y = Integer.parseInt(cellSizeSplit[1]);
                int numHappyCells = Integer.parseInt(cellSizeSplit[2]);

                if (x >= 1 && y >= 1 && numHappyCells <= Math.pow(10, 5)) {
                    int[][] twoDArray = new int[x][y];

                    while (numHappyCells != 0) {
                        String kLine = br.readLine();

                        String[] kLineSplit = kLine.split(" ");

                        if (kLineSplit.length == 3) {
                            int a = Integer.parseInt(kLineSplit[0]);
                            int b = Integer.parseInt(kLineSplit[1]);
                            int happyValue = Integer.parseInt(kLineSplit[2]);
                            if(a <= x && b <= y && happyValue >= 1 && happyValue <= Math.pow(10,5))
                                if (a - 1 <= x - 1 && b - 1 <= y - 1) {
                                    twoDArray[a - 1][b - 1] = happyValue;
                                }
                        }
                        numHappyCells--;
                    }

                    int happyValue = 0;
                    int temp = 0;
                    for (int i = 0; i <= x - 1; i++) {
                        for (int j = temp; j <= y - 1; j++) {

                            happyValue += twoDArray[i][j];
                            if (j + 1 <= y - 1) {
                                happyValue += twoDArray[i][j + 1];
                                temp = j + 1;
                            }
                            temp = 0;
                            break;
                        }
                    }
                    if(happyValue > 1000000007)
                        happyValue = happyValue % 1000000007;

                    System.out.println(happyValue);
                }
            }
        }
    }
}