public class Item {
    
    private String name;
    //stat boosts
    private int s;
    private int d;
    private int i;
    private int f;
    private int p;
    private int c;
    private int h;
    private int y;

    public Item( String n, int a, int b, int x, int z, int e, int q, int g, int hungryhunger ) {
	name = n;
	s = a;
	d = b;
	i = x;
	f = z;
	p = e;
	c = q;
	h = g;
	y = hungryhunger;
    }
    
    //accessors
    public int gets() { return s; }
    public int getd() { return d; }
    public int geti() { return i; }
    public int getf() { return f; }
    public int getp() { return p; }
    public int getc() { return c; }
    public int geth() { return h; }
    public int gety() { return y; }
    public String getN() { return name; }
}
	

