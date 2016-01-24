package base;
import java.util.ArrayList;
import java.util.List;


public class MyPoint {
	public MyPoint(int id,double x,double y){
		this.id=id;
		this.x=x;
		this.y=y;
	}
	double x;
	double y;
	int id;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDistance(MyPoint point){
		return Math.sqrt(Math.pow(this.x-point.getX(),2)+Math.pow(this.y-point.getY(),2));
	}
	private MyPoint getShortestPoint(List<MyPoint> list,List<MyPoint>  excepts){
		MyPoint mp=null;
		double min=1000000;
		for(MyPoint p:list){
			if(min>this.getDistance(p)&&!find(excepts,p)){
				min=this.getDistance(p);
				mp=p;
			}
		}
		return mp;
	}
	private boolean find(List<MyPoint> list,MyPoint p){
		for(MyPoint o :list){
			if(o.getId()==p.getId()){
				return true;
			}
		}
		return false;
	}

	public List<MyPoint> getNearPoint(List<MyPoint> list,int n){
		 
		List<MyPoint> points = new ArrayList<MyPoint>();
		for(int i=0;i<n;i++){
			points.add(this.getShortestPoint(list,points));

		}
		return points;

	}
	public String toString(){
		return "id="+this.getId()+":("+this.getX()+","+this.getY()+")\n";
	}


}
