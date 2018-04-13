//axis aligned rectangles
public class Rectangle {
    private final double center_x,center_y,width,height;

    public Rectangle(double center_x, double center_y, double width, double height) {
        this.center_x = center_x;
        this.center_y = center_y;
        this.width = width;
        this.height = height;
    }
    public double area(){
        return width*height;
    }
    public double perimeter() {
        return 2.0*(width+height);
    }
    public boolean contains(Rectangle a){
        /*
        StdOut.printf("a.center_x-a.width/2 = %f, center_x-width/2 = %f, a.center_x+a.width/2 = %f, center_x+width/2 = %f, " +
                        "a.center_y-a.height/2 = %f, center_y-height/2 = %f, a.center_y+a.height/2 = %f, center_y+height/2 = %f",
                            a.center_x-a.width/2,center_x-width/2,a.center_x+a.width/2,center_x+width/2,
                            a.center_y-a.height/2,center_y-height/2,a.center_y+a.height/2,center_y+height/2);
        */
        if((a.center_x-a.width/2>center_x-width/2)&& 
                (a.center_x+a.width/2<center_x+width/2)&&
                (a.center_y-a.height/2>center_y-height/2)&&
                (a.center_y+a.height/2<center_y+height/2)){
            return true;
        }
        return false;
    }
    public boolean intersects(Rectangle a){
        /*StdOut.printf("a.center_x-a.width/2 = %f, center_x-width/2 = %f\na.center_x+a.width/2 = %f, center_x+width/2 = %f\n" +
                        "a.center_y-a.height/2 = %f, center_y-height/2 = %f\na.center_y+a.height/2 = %f, center_y+height/2 = %f\n",
                a.center_x-a.width/2,center_x-width/2,a.center_x+a.width/2,center_x+width/2,
                a.center_y-a.height/2,center_y-height/2,a.center_y+a.height/2,center_y+height/2);
        if((a.center_x - a.width / 2 <= center_x - width / 2) && (a.center_x + a.width / 2 >= center_x - width / 2))return true;
        if((a.center_x - a.width / 2 <= center_x + width / 2) && (a.center_x + a.width / 2 >= center_x + width / 2))return true;
        if((a.center_y - a.height / 2 <= center_y - height / 2) && (a.center_y + a.height / 2 >= center_y - height / 2))return true;
        if((a.center_y - a.height / 2 <= center_y + height / 2) && (a.center_y + a.height / 2 >= center_y + height / 2))return true;*/
        if(this.outside(a)||this.contains(a)||a.contains(this))return false;
        return true;
    }
    public boolean outside(Rectangle a){
        if(a.center_x + a.width / 2 < center_x - width / 2)return true;
        if(a.center_x - a.width / 2 > center_x + width / 2)return true;
        if(a.center_y + a.height/ 2 < center_y - height / 2)return true;
        if(a.center_y - a.height/ 2 > center_y + height / 2)return true;
        return false;
    }
    public void draw(Rectangle a){
        StdDraw.clear();
        double minx,maxx,miny,maxy;
        minx = Math.min(a.center_x-a.width/2,center_x-width/2);
        maxx = Math.max(a.center_x+a.width/2,center_x+width/2);
        miny = Math.min(a.center_y-a.height/2,center_y-height/2);
        maxy = Math.max(a.center_y+a.height/2,center_y+height/2);
        //StdOut.printf("minx = %f,miny = %f,maxx = %f,maxy = %f,0.9*miny=%f,1.05*maxy=%f",minx,miny,maxx,maxy,0.9*miny,1.05*maxy);
        StdDraw.setXscale(minx-0.05*maxx,1.05*maxx);
        StdDraw.setYscale(miny-0.05*maxy,1.05*maxy);
        //StdDraw.setYscale(0,1);
        {
            StdDraw.line(center_x-width/2,center_y-height/2,center_x-width/2,center_y+height/2);
            StdDraw.line(center_x-width/2,center_y-height/2,center_x+width/2,center_y-height/2);
            StdDraw.line(center_x+width/2,center_y+height/2,center_x-width/2,center_y+height/2);
            StdDraw.line(center_x+width/2,center_y+height/2,center_x+width/2,center_y-height/2);
            //pause for 0.5secs before drawing second. just for show :P
            StdDraw.pause(500);
        }
        {
            StdDraw.line(a.center_x-a.width/2,a.center_y-a.height/2,a.center_x-a.width/2,a.center_y+a.height/2);
            StdDraw.line(a.center_x-a.width/2,a.center_y-a.height/2,a.center_x+a.width/2,a.center_y-a.height/2);
            StdDraw.line(a.center_x+a.width/2,a.center_y+a.height/2,a.center_x-a.width/2,a.center_y+a.height/2);
            StdDraw.line(a.center_x+a.width/2,a.center_y+a.height/2,a.center_x+a.width/2,a.center_y-a.height/2);
            StdDraw.pause(1000);
        }
    }
    public static void draw(Rectangle[] rects){
        StdDraw.clear();
        double minx=Double.POSITIVE_INFINITY,maxx=Double.NEGATIVE_INFINITY,miny=Double.POSITIVE_INFINITY,maxy=Double.NEGATIVE_INFINITY;
        for (int i = 0; i < rects.length; i++) {
            if((rects[i].center_x-rects[i].width/2) <minx){minx = (rects[i].center_x-rects[i].width/2);}
            if((rects[i].center_x+rects[i].width/2) >maxx){maxx = (rects[i].center_x+rects[i].width/2);}
            if((rects[i].center_y-rects[i].height/2)<miny){miny = (rects[i].center_y-rects[i].height/2);}
            if((rects[i].center_y+rects[i].height/2)>maxy){maxy = (rects[i].center_y+rects[i].height/2);}

        }
        //StdOut.printf("minx = %f,miny = %f,maxx = %f,maxy = %f,0.9*miny=%f,1.05*maxy=%f",minx,miny,maxx,maxy,0.9*miny,1.05*maxy);
        StdDraw.setXscale(minx-0.05*maxx,1.05*maxx);
        StdDraw.setYscale(miny-0.05*maxy,1.05*maxy);
        //StdDraw.setYscale(0,1);
        for (int i = 0; i < rects.length; i++) {
            StdDraw.line(rects[i].center_x-rects[i].width/2,rects[i].center_y-rects[i].height/2,rects[i].center_x-rects[i].width/2,rects[i].center_y+rects[i].height/2);
            StdDraw.line(rects[i].center_x-rects[i].width/2,rects[i].center_y-rects[i].height/2,rects[i].center_x+rects[i].width/2,rects[i].center_y-rects[i].height/2);
            StdDraw.line(rects[i].center_x+rects[i].width/2,rects[i].center_y+rects[i].height/2,rects[i].center_x-rects[i].width/2,rects[i].center_y+rects[i].height/2);
            StdDraw.line(rects[i].center_x+rects[i].width/2,rects[i].center_y+rects[i].height/2,rects[i].center_x+rects[i].width/2,rects[i].center_y-rects[i].height/2);
            //StdDraw.pause(50);
        }
    }
    public static void main(String[] args){
        Rectangle a;
        Rectangle b;
        {
            a = new Rectangle(0.5,0.5,0.75,0.6);
            b = new Rectangle(0.5,0.5,0.55,0.4);
            a.draw(b);
            String contains;
            contains=a.contains(b)?"contains ":"does not contain ";
            StdOut.println("Rectangle A "+contains+"Rectangle B");
            String intersects;
            intersects=a.intersects(b)?"intersects ":"does not intersect ";
            StdOut.println("Rectangle A "+intersects+"Rectangle B");
            StdOut.println("");
        }
        {
            a = new Rectangle(0.5,0.5,0.75,0.6);
            b = new Rectangle(0.75,0.5,0.55,0.4);
            a.draw(b);
            String contains;
            contains=a.contains(b)?"contains ":"does not contain ";
            StdOut.println("Rectangle A "+contains+"Rectangle B");
            String intersects;
            intersects=a.intersects(b)?"intersects ":"does not intersect ";
            StdOut.println("Rectangle A "+intersects+"Rectangle B");
            StdOut.println("");
        }
        {
            a = new Rectangle(0.25,0.5,0.5,0.6);
            b = new Rectangle(0.75,0.5,0.5,0.4);
            a.draw(b);
            String contains;
            contains=a.contains(b)?"contains ":"does not contain ";
            StdOut.println("Rectangle A "+contains+"Rectangle B");
            String intersects;
            intersects=a.intersects(b)?"intersects ":"does not intersect ";
            StdOut.println("Rectangle A "+intersects+"Rectangle B");
            StdOut.println("");
        }
        {
            a = new Rectangle(0.5,0.75,0.5,0.6);
            b = new Rectangle(0.5,0.25,0.5,0.3);
            a.draw(b);
            String contains;
            contains=a.contains(b)?"contains ":"does not contain ";
            StdOut.println("Rectangle A "+contains+"Rectangle B");
            String intersects;
            intersects=a.intersects(b)?"intersects ":"does not intersect ";
            StdOut.println("Rectangle A "+intersects+"Rectangle B");
            StdOut.println("");
        }
        {
            int num_rects =1000;
            Rectangle[] rects = new Rectangle[num_rects];
            for (int i = 0; i < num_rects; i++) {
                rects[i] = new Rectangle(Math.random(),Math.random(),Math.random(),Math.random());
            }
            draw(rects);
            int num_intersecting = 0,count=0;
            for (int i = 0; i < rects.length; i++) {
                for (int j = i+1; j < rects.length; j++) {
                    count++;
                    if(rects[i].intersects(rects[j]))num_intersecting++;
                }
            }
            StdOut.printf("The average number of rectangles intersecting = %f\n",(double)num_intersecting/count);

        }
    }
    
}
