package LotterySimulator

public class LotteryChecker {
    private int[] winningNum;
    private int[] currentNum;

    public LotteryChecker(int[] winningNum, int[] currentNum) {
        this.winningNum = winningNum;
        this.currentNum = currentNum;
    }

    public int getRank() {
        int matchCount = 0;
        boolean matchBonus = false;

        for (int current : currentNum) {
            for (int win : winningNum) {
                if (current == win) {
                    matchCount++;
                    break;
                }
            }
            if (current == winningNum[6]) { // Check for bonus number
                matchBonus = true;
            }
        }

        // Adjusted the condition checks for clarity and to avoid redundancy.
        if (matchCount == 6) return 1;
        else if (matchCount == 5 && matchBonus) return 1;
        else if (matchCount == 5) return 2;
        else if (matchCount == 4 && matchBonus) return 2;
        else if (matchCount == 4) return 3;
        else if (matchCount == 3) return 4;
        else return -1;
    }

    public int getPrize(int rank) {
        switch (rank) {
            case 1: return 100;
            case 2: return 50;
            case 3: return 20;
            case 4: return 10;
            default: return 0;
        }
    }
}
