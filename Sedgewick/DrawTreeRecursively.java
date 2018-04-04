public class DrawTreeRecursively {
    public static void main(String[] args){
        //recursiveTree(.5,0.1,90,0.3,9,0.01);
        recursiveTree2(.5,0.1,90,0.3,9,0.01);
        StdDraw.save("Trees/tree2.png");
        StdOut.print("Done");
    }
    public static void recursiveTree2(double base_center_x,double base_center_y,
                                     int base_angle_in_degrees,double baselength,int level,double penwidth){
        if(level==0)return;
        //StdOut.printf("angle = %d, baselength =  %f\n",base_angle_in_degrees,baselength);
        double base_x1 = base_center_x+baselength*Math.cos((double)(base_angle_in_degrees)/360*2*Math.PI);
        double base_y1 = base_center_y+baselength*Math.sin((double)(base_angle_in_degrees)/360*2*Math.PI);
        StdDraw.setPenRadius(penwidth);
        StdDraw.line(base_center_x,base_center_y,base_x1,base_y1);
        double branch1_length=baselength*0.6;
        double branch2_length=baselength*0.3;
        double branch3_length=baselength*0.65;
        int branch1_angle = base_angle_in_degrees-20;
        int branch2_angle = base_angle_in_degrees+15;
        int branch3_angle = base_angle_in_degrees+50;
        //StdOut.printf("%d, %d, %d\n",branch1_angle,branch2_angle,branch3_angle);
        recursiveTree(base_x1,base_y1,branch1_angle,branch1_length,level-1,penwidth*0.8);
        recursiveTree(base_x1,base_y1,branch2_angle,branch2_length,level-1,penwidth*0.8);
        recursiveTree(base_x1,base_y1,branch3_angle,branch3_length,level-1,penwidth*0.8);
    }
    public static void recursiveTree(double base_center_x,double base_center_y,
                                     int base_angle_in_degrees,double baselength,int level,double penwidth){
        if(level==0)return;
        //StdOut.printf("angle = %d, baselength =  %f\n",base_angle_in_degrees,baselength);
        double base_x1 = base_center_x+baselength*Math.cos((double)(base_angle_in_degrees)/360*2*Math.PI);
        double base_y1 = base_center_y+baselength*Math.sin((double)(base_angle_in_degrees)/360*2*Math.PI);
        StdDraw.setPenRadius(penwidth);
        StdDraw.line(base_center_x,base_center_y,base_x1,base_y1);
        double branch1_length=baselength*0.6;
        double branch2_length=baselength*0.3;
        double branch3_length=baselength*0.65;
        int branch1_angle = base_angle_in_degrees-20;
        int branch2_angle = base_angle_in_degrees+15;
        int branch3_angle = base_angle_in_degrees+50;
        //StdOut.printf("%d, %d, %d\n",branch1_angle,branch2_angle,branch3_angle);
        recursiveTree(base_x1,base_y1,branch1_angle,branch1_length,level-1,penwidth*branch1_length/baselength);
        recursiveTree(base_x1,base_y1,branch2_angle,branch2_length,level-1,penwidth*branch2_length/baselength);
        recursiveTree(base_x1,base_y1,branch3_angle,branch3_length,level-1,penwidth*branch3_length/baselength);
    }
}
