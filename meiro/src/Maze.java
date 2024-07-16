import java.util.Vector;

public class Maze extends MyFrame{
	public void run() {
		int [][]kabe=new int[15][15];
		Vector<Integer> vec = new Vector<>();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if((i==0)||(j==0)||(i==14)||(j==14)) {
					kabe[i][j]=1;
				}else {
					kabe[i][j]=0;
				}
				if((i%2==0)&&(j%2==0)&&(i!=0)&&(j!=0)&&(i!=14)&&(j!=14)) {
					vec.add(i,j);
				}
			}
		}
		System.out.println(vec);
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(kabe[i][j]==1) {
					drawString("■",40+(i*19),70+(j*19),20);
				}
			}
		}
	}
}
