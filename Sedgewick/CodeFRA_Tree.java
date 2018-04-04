public class CodeFRA_Tree {
    public static void main(String[] args){
        recursiveTree(.5,0.1,90,0.3,7);
    }
    public static void recursiveTree(double base_center_x,double base_center_y,int base_angle_in_degrees,double baselength,int level){
        double base_x1 = base_center_x+baselength*Math.cos((double)(base_angle_in_degrees)/360*2*Math.PI);
        double base_y1 = base_center_x+baselength*Math.sin((double)(base_angle_in_degrees)/360*2*Math.PI);
        StdDraw.line(base_center_x,base_center_y,base_x1,base_y1);
        double branch1_length=baselength*0.35;
        double branch2_length=baselength*0.25;
        double branch3_length=baselength*0.3;
        int branch1_angle = base_angle_in_degrees-40;
        int branch2_angle = base_angle_in_degrees+10;
        int branch3_angle = base_angle_in_degrees+45;
        recursiveTree(base_x1,base_y1,branch1_angle,branch1_length,level-1);
        recursiveTree(base_x1,base_y1,branch2_angle,branch2_length,level-1);
        recursiveTree(base_x1,base_y1,branch3_angle,branch3_length,level-1);



    }
}
