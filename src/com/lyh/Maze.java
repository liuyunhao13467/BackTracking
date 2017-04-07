package com.lyh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Maze {

	/**
	 * ��ʾ�Թ���ͼ�ϵ�����
	 * @author Administrator
	 */
	public class Point{
		public int x;
		public int y;
	}
	
	public Point getPoint(int x, int y){
		Point tmp = new Point();
		tmp.x = x;
		tmp.y = y;
		return tmp;
	}
	
	int N = 10;//�Թ���С
	int ENTRY_X = 0, ENTRY_Y = 0;//���λ����Ϊ(0,0)
	int EXIT_X = N-1, EXIT_Y = N-1;//����λ����Ϊ(N-1,N-1)
	
	int[][] maze = new int[N][N];//����һ���Թ�
	int pathCount = 0;//·��������
	List<Point> Path = new ArrayList<>();//·����������㼯��ʾ������
	List<Point> BestPath = new ArrayList<>();//���·��
	
	boolean isFirst = true;//��ǰ·���Ƿ�Ϊ��һ��·��
	
	/**
	 * ��ʼ���Թ���ͼ
	 */
	public void initMaze(){
		//�����Թ���ͼ
		int tmp[][]={  
				{0,0,1,1,1,1,1,1,1,1}, //0  
				{1,0,0,1,1,0,0,1,0,1}, //1  
				{1,0,0,1,0,0,0,1,0,1}, //2  
				{1,0,0,0,0,1,1,0,0,1}, //3  
				{1,0,1,1,1,0,0,0,0,1}, //4  
				{1,0,0,0,1,0,0,0,0,1}, //5  
				{1,0,1,0,0,0,1,0,0,1}, //6  
				{1,0,1,1,1,0,1,1,0,1}, //7  
				{1,1,0,0,0,0,0,0,0,0}, //8  
				{1,1,1,1,1,1,1,1,1,0}  //9  
				//0 1 2 3 4 5 6 7 8 9  
		}; 
		//����
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < N; ++j){
				maze[i][j] = tmp[i][j];
			}
		}
	}
	
	/**
	 * ����Ϊ��ǰ����㣬��ʼλ����(0,0)
	 * @param curr
	 */
	public void mazeBackTracking(Point curr){
		//�Ƚ���ǰ�����path�������õ�����Ϊ���߹�
		Path.add(curr);
		maze[curr.x][curr.y] = 1;
		System.out.println("Current point is: "+curr.x+", "+curr.y);
		
		//�����ǰ���ǳ��ڡ�����
		if(curr.x == EXIT_X && curr.y == EXIT_Y){
			pathCount++;//·��������һ
			//���Դ�ӡһ��·��
			Iterator<Point> pointIt = Path.iterator();
			while(pointIt.hasNext()){
				Point tmp = pointIt.next();
				System.out.println("("+tmp.x+","+tmp.y+")");
			}
			//�ж��Ƿ�����Ż�
			if(isFirst){//����ǵ�һ��·���������ŵ�
				BestPath.addAll(Path);
			}else{//������ǵ�һ��
				if(Path.size() < BestPath.size()){
					BestPath.clear();
					BestPath.addAll(Path);
				}
			}
		}
		
		//���ǳ��ڵĻ����жϸ�λ�õ����������Ƿ񣺣�1�����ڣ���Խ�磨2�����ߣ������ϰ���
		//�ϣ�(x-1, y)
		if((curr.x-1)>=0 && maze[curr.x-1][curr.y]==0){
			//�ݹ��ж�
			Point next = new Point();
			next.x = curr.x-1;
			next.y = curr.y;
			mazeBackTracking(next);
		}
		//�£�(x+1, y)
		if((curr.x+1)<N && maze[curr.x+1][curr.y]==0){
			//�ݹ��ж�
			Point next = new Point();
			next.x = curr.x+1;
			next.y = curr.y;
			mazeBackTracking(next);
		}
		//��(x,y-1)
		if((curr.y-1)>=0 && maze[curr.x][curr.y-1]==0){
			//�ݹ��ж�
			Point next = new Point();
			next.x = curr.x;
			next.y = curr.y-1;
			mazeBackTracking(next);
		}
		//�ң�(x,y+1)
		if((curr.y+1)<N && maze[curr.x][curr.y+1]==0){
			//�ݹ��ж�
			Point next = new Point();
			next.x = curr.x;
			next.y = curr.y+1;
			mazeBackTracking(next);
		}
		
		//��������ͷ�����һ��step
		Path.remove(curr);
		maze[curr.x][curr.y] = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maze mazeTest = new Maze();
		mazeTest.initMaze();
		Point currentPoint = mazeTest.getPoint(mazeTest.ENTRY_X, mazeTest.ENTRY_Y);
		mazeTest.mazeBackTracking(currentPoint);
		System.out.println("Path number is: "+mazeTest.pathCount);
		Iterator<Point> pointsIt = mazeTest.BestPath.iterator();
		while(pointsIt.hasNext()){
			Point tmp = pointsIt.next();
			System.out.println("("+tmp.x+","+tmp.y+")");
		}
	}

}
