
public class Table {
	int size;
	char[][] t;
	public Table(int size){
		this.size = size;
		this.t = new char[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size;j++){
				t[i][j] = '.';
			}
		}
	}
	
	public Table(Table table){
		this.size = table.size;
		this.t = new char[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size;j++){
				t[i][j] = table.t[i][j];
			}
		}
	}
	
	public void insert(int i, int j, char color){
		t[i][j] = color;
	}
	public void remove(int i, int j){
		t[i][j] = '.';
	}
	
	public int valueOfTable(){
		double d = Math.random() * size;
		return (int) d;
	}
	
	private boolean[][] mark;
	
	public char azmunHadaf(){
		mark = new boolean[size][size];
		for(int i = 0; i < size;i++){
			if(t[0][i] == 'r' && mark[0][i] == false && hadaf(0,i,'r')){
				return 'r';
			}
		}
		mark = new boolean[size][size];
		for(int i = 0; i < size;i++){
			if(t[i][0] == 'b' && mark[i][0] == false && hadaf(i,0,'b')){
				return 'b';
			}
		}
		return '.';
//		for(int i = 0; i < size;i++){
//			if(hadaf(0,i,'r')){
//				return 'r';
//			}
//		}
//		for(int i = 0; i < size;i++){
//			if(hadaf(i,0,'b')){
//				return 'b';
//			}
//		}
//		return '.';
	}
	
	private boolean hadaf(int i,int j, char color){
		mark[i][j]=true;
//		hamsayeha
//		i,j+1
//		i,j-1
//		i+1,j
//		i-1,j
//		i-1,j+1
//		i+1,j-1
		if(color == 'r'){
			if(i==size-1)
				return true;
			if(j < size-1 && mark[i][j+1] == false && t[i][j+1] == 'r' && hadaf(i,j+1,'r'))
				return true;
			if(j > 0 && mark[i][j-1] == false && t[i][j-1] == 'r' && hadaf(i,j-1,'r'))
				return true;
			if(i < size-1 && mark[i+1][j] == false && t[i+1][j] == 'r' && hadaf(i+1,j,'r'))
				return true;
			if(i > 0 && mark[i-1][j] == false && t[i-1][j] == 'r' && hadaf(i-1,j,'r'))
				return true;
			if(i > 0 && j < size-1 && mark[i-1][j+1] == false && t[i-1][j+1] == 'r' && hadaf(i-1,j+1,'r'))
				return true;
			if(i < size-1 && j > 0 && mark[i+1][j-1] == false && t[i+1][j-1] == 'r' && hadaf(i+1,j-1,'r'))
				return true;
			return false;
		}
		else{
			if(j==size-1)
				return true;
			if(j < size-1 && mark[i][j+1] == false && t[i][j+1] == 'b' && hadaf(i,j+1,'b'))
				return true;
			if(j > 0 && mark[i][j-1] == false && t[i][j-1] == 'b' && hadaf(i,j-1,'b'))
				return true;
			if(i < size-1 && mark[i+1][j] == false && t[i+1][j] == 'b' && hadaf(i+1,j,'b'))
				return true;
			if(i > 0 && mark[i-1][j] == false && t[i-1][j] == 'b' && hadaf(i-1,j,'b'))
				return true;
			if(i > 0 && j < size-1 && mark[i-1][j+1] == false && t[i-1][j+1] == 'b' && hadaf(i-1,j+1,'b'))
				return true;
			if(i < size-1 && j > 0 && mark[i+1][j-1] == false && t[i+1][j-1] == 'b' && hadaf(i+1,j-1,'b'))
				return true;
			return false;
		}
		
//		if(i==size || j==size)
//			return true;
//		if(color == 'r'){
//			if(t[i][j] != 'r')
//				return false;
//			if(hadaf(i+1,j,'r'))
//				return true;
//			if(j>0 && hadaf(i+1,j-1,'r'))
//				return true;
//			return false;
//		}
//		else{
//			if(t[i][j] != 'b')
//				return false;
//			if(hadaf(i,j+1,'b')){
//				System.out.println(i + " " + j + " avali");
//				return true;
//			}
//			if(i>0 && hadaf(i-1,j+1,'b')){
//				System.out.println(i + " " + j + " dovomi");
//				return true;
//			}
//			return false;
//		}
	}
	
	public void showTable(){
		for(int i = 0; i < size;i++){
			System.out.print( " " + "R");
		}
		System.out.println();
		for(int i = 0; i < size;i++){
			for(int k = 0; k < i;k++){
				System.out.print(" ");
			}
			System.out.print("B ");
			for(int j = 0; j < size;j++){
				System.out.print(t[i][j] + " ");
			}
			System.out.println("B");
		}

		for(int i = 0; i <= size;i++){
			System.out.print( " ");
		}
		for(int i = 0; i < size;i++){
			System.out.print( " " + "R");
		}
		System.out.println();
	}
}
