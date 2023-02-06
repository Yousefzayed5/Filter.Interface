import java.util.ArrayList;
// interface Filter.java
public interface Filter{
    boolean accept(Object x);
}
// Rectangle.java

// BigRectangleFilter.java
public class BigRectangleFilter implements Filter{

    @Override
    public boolean accept(Object x) {

        Rectangle rec=(Rectangle)x;
        double perimeter=2*(rec.height+rec.width); // calculate perimeter
        if(perimeter>10)
            return true;

        return false;
    }

    public static ArrayList<Object> collectAll(ArrayList<Object> rects, Filter f){

        ArrayList<Object> all=new ArrayList<Object>();
        f=new BigRectangleFilter();
        for(Object x:rects)
        {
            if(f.accept(x))
                all.add(x);
        }
        return all;
    }

}

// BigRectLister.java
public class BigRectLister {

    public static void main(String[] args) {
        ArrayList<Object> rects=new ArrayList<Object> ();

        rects.add(new Rectangle(1,1));
        rects.add(new Rectangle(2,1));
        rects.add(new Rectangle(3,8));
        rects.add(new Rectangle(4,1));
        rects.add(new Rectangle(1,2));
        rects.add(new Rectangle(1,3));
        rects.add(new Rectangle(1,4));
        rects.add(new Rectangle(2,2));
        rects.add(new Rectangle(3,4));
        rects.add(new Rectangle(6,5));
        System.out.println("Rectangles Before applying filter: ");
        for(Object o:rects)
        {
            Rectangle r=(Rectangle)o;
            System.out.println(r);
        }
        Filter f = null;
        rects=BigRectangleFilter.collectAll(rects,f);

        System.out.println("Rectangles after applying filter: ");
        for(Object o:rects)
        {
            Rectangle r=(Rectangle)o;
            System.out.println(r);
        }

    }

}