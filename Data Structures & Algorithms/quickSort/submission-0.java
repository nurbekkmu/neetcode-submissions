// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> quickSort(List<Pair> pairs, int s, int e) {
        if (s >= e) {
            return pairs;
        }

        Pair pivot = pairs.get(e);
        int left = s;

        for (int i = s; i <= e; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
        }

        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        quickSort(pairs, s, left - 1);
        quickSort(pairs, left + 1, e);

        return pairs;
    }
}
