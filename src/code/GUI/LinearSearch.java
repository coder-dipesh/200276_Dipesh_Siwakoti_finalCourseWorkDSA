package code.GUI;

//Linear Search
public  class LinearSearch {
//    Return index of data in given list if available
    public static int getIndex(String[] arr, String data) {
        int index = -1;
        for(int i=0; i<arr.length; i++) {
            if (arr[i].equals(data)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
