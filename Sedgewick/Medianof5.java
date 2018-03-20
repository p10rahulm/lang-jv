public class Medianof5 {
    /*public static void main(String[] args){
        int i1 = Integer.parseInt(args[0]);
        int i2 = Integer.parseInt(args[1]);
        int i3 = Integer.parseInt(args[2]);
        int i4 = Integer.parseInt(args[3]);
        int i5 = Integer.parseInt(args[4]);
        // We are going to divide and conquer. compare i1 and i2 in 1 step. Then sort i3,i4 and i5 in max of 3 steps.
        System.out.println("i1 = "+i1+", i2 = "+i2+", i3 = "+i3+", i4 = "+i4+", i5 = "+i5);
        int temp,median = i4;
        if(i1>i2){temp=i1;i1=i2;i2=temp;}
        if(i3>i4){temp=i3;i3=i4;i4=temp;}
        if(i3<i5 && i5<i4) {temp=i4;i4=i5;i5=temp;}
        if(i3>i5) {temp=i3;i3=i5;i5=i4;i4=temp;}
        System.out.println("i1 = "+i1+", i2 = "+i2+", i3 = "+i3+", i4 = "+i4+", i5 = "+i5);
        //Now i1,i2 are sorted. i3,i4 and i5 are sorted. We may need 3 comparisons
        if(i4<i1 && i5<i1)median=i5;
        if(i4<i1 && i5>i1)median=i1;
        if(i4>i1 && i3>i2)median=i3;
        if(i4>i1 && i3<i2&&i2<i4)median=i2;
        if(i4>i1 && i3<i2&&i2>i4)median=i4;
        System.out.println(median);
    }
    */

    public static void main(String[] args){
        int i1 = Integer.parseInt(args[0]);
        int i2 = Integer.parseInt(args[1]);
        int i3 = Integer.parseInt(args[2]);
        int i4 = Integer.parseInt(args[3]);
        int i5 = Integer.parseInt(args[4]);
        // We are going to divide and conquer. compare i1 and i2 in 1 step. Then sort i3,i4 and i5 in max of 3 steps.
        //System.out.println("i1 = "+i1+", i2 = "+i2+", i3 = "+i3+", i4 = "+i4+", i5 = "+i5);
        int temp,median;
        if(i1>i2){temp=i1;i1=i2;i2=temp;}
        if(i3>i4){temp=i3;i3=i4;i4=temp;}
        // we now have two sorted sets of 2
        if(i1>i3){
            if(i4>i5){temp=i3;i3=i5;i5=temp;}
            else{temp=i5;i5=i3;i3=i4;i4=temp;}
        } else{
            if(i2>i5){temp=i1;i1=i5;i5=temp;}
            else{temp=i5;i5=i1;i1=i2;i2=temp;}
        }
        // We have taken 4 steps. we now have two sorted sets of 2. The fifth (i5) is the smallest and cannot be the median
        if(i1<i3){
            if(i2<i3){median = i2;}
            else{median = i3;}
        } else{
            if(i1>i4){median = i1;}
            else{median=i4;}
        }


        if(i3<i5 && i5<i4) {temp=i4;i4=i5;i5=temp;}
        if(i3>i5) {temp=i3;i3=i5;i5=i4;i4=temp;}
        //System.out.println("i1 = "+i1+", i2 = "+i2+", i3 = "+i3+", i4 = "+i4+", i5 = "+i5);
        //Now i1,i2 are sorted. i3,i4 and i5 are sorted. We may need 3 comparisons
        if(i4<i1 && i5<i1)median=i5;
        if(i4<i1 && i5>i1)median=i1;
        if(i4>i1 && i3>i2)median=i3;
        if(i4>i1 && i3<i2&&i2<i4)median=i2;
        if(i4>i1 && i3<i2&&i2>i4)median=i4;
        System.out.println(median);
    }
}
