class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean can = true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1)
                can = false;
            if (flowerbed[i] == 0) {
                // for last position
                if (can && i == flowerbed.length - 1) {
                    count++;
                } else if (can && flowerbed[i + 1] == 0) {
                    count++;
                    can = false;
                } else {
                    can = true;
                }
            }
        }
        return count >= n;
    }
}