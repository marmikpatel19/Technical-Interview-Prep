class MergeSortedArray {
    // time: O(n), space: O(n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // store final sorted array
        int[] temp = new int[n + m];

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while (p1 < m || p2 < n) {
            if (p1 < m && p2 < n) {
                if (nums1[p1] < nums2[p2]) {
                    temp[p3] = nums1[p1];
                    p1++;
                } else {
                    temp[p3] = nums2[p2];
                    p2++;
                }
            } else if (p1 < m) {
                temp[p3] = nums1[p1];
                p1++;
            } else {
                temp[p3] = nums2[p2];
                p2++;
            }

            p3++;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = temp[i];
        }
    }
}