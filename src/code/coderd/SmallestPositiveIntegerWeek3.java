package code.coderd;

//         Given a string of number, return missing smallest positive integer. the time complexity for
//         given algorithm must be 0(n)
//          coder-dipesh

public class SmallestPositiveIntegerWeek3 {

    public int smallestNumber(String givenNumber){
        int number;
        int n=givenNumber.length();
        int[] num =new int[10];

        for (int i=0;i<n;i++){
            number=Integer.parseInt(givenNumber.charAt(i)+"");
            num[number]=1;
        }
        for (int i=1;i<10;i++){
            if(num[i]==0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String input1="1689";
        String input2="689345";
        SmallestPositiveIntegerWeek3 num= new SmallestPositiveIntegerWeek3();

        int output1= num.smallestNumber(input1);
        System.out.println("First Output :- " + output1);
        int output2= num.smallestNumber(input2);
        System.out.println("Second Output :- " + output2);
    }


}
