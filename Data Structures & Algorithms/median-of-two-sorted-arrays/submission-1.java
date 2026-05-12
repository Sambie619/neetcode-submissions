class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Assign arrays to local variables for easier swapping
        int[]A=nums1;
        int[]B=nums2;
        // Total number of elements across both arrays
        int total=A.length+B.length;
        // Number of elements that must be on the LEFT side of the partition
        // (+1 handles both odd and even lengths uniformly)
        int half=(total+1)/2;
        /*
         * We ALWAYS binary search on the smaller array.
         * This guarantees O(log(min(n, m))) time complexity.
         */
        if(B.length<A.length){
            int[]temp=A;
            A=B;
            B=temp;
        }
        // Binary search boundaries on array A
        int l=0;
        int r=A.length;
        /*
         * Binary search loop:
         * We are searching for a partition index i in A
         * such that the combined left partitions of A and B
         * contain exactly 'half' elements.
         */
         while(l<=r){
            // Partition index for A (midpoint of binary search)
            int i=(l+r)/2;
            // Partition index for B (derived from A)
            int j=half-i;
            /*
             * Now we identify the elements immediately
             * to the LEFT and RIGHT of the partition in both arrays.
             * We use -∞ and +∞ to safely handle edge cases,
             * where the partition touches the array boundaries.
             */
            int Aleft=(i>0)?A[i-1]:Integer.MIN_VALUE;
            int Aright=(i<A.length)?A[i]:Integer.MAX_VALUE;
            int Bleft  = (j > 0)        ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < B.length) ? B[j]     : Integer.MAX_VALUE;
            /*
             * VALID PARTITION CHECK:
             * All elements in left partitions must be
             * <= all elements in right partitions.
             */
             if(Aleft<=Bright && Bleft <=Aright ){
                /*
                 * If total number of elements is ODD,
                 * median is the largest element on the LEFT side.
                 */
                 if(total%2!=0){
                    return Math.max(Aleft,Bleft);
                 }
                 /*
                 * If total number of elements is EVEN,
                 * median is the average of:
                 * - max of left elements
                 * - min of right elements
                 */
                 return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;
             }
             /*
             * If Aleft is too big, we moved too far right in A.
             * Move binary search LEFT.
             */
             else if(Aleft>Bright){
                r=i-1;
             }
             /*
             * Otherwise, we haven’t taken enough elements from A.
             * Move binary search RIGHT.
             */
             else{
                l=i+1;
             }
         }
        // This should never be reached if input arrays are sorted
        return -1;
    }
}
