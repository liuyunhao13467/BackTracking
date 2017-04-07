package com.lyh;

public class BackTrackingModel {
	int n = 8, k = 8;
	int[] x = new int[8];
	
	void backtrack(int t){
		if(t > n)
			System.out.println("");
		else
			for(int i = 1; i <= k; ++i){
				x[t] = value(i);
				if(constraint(t) && bound(t))
					backtrack(t+1);
			}
	}
	
	void iterativeBacktrack ()  
	{  
	    int t=1;  
	    while (t>0) {  
	        if(ExistSubNode(t)) //��ǰ�ڵ�Ĵ����ӽڵ�  
	        {  
	            for(int i = 1; i <= k; ++i)  //������ǰ�ڵ�������ӽڵ�  
	            {  
	                x[t]=value(i);//ÿ���ӽڵ��ֵ��ֵ��x  
	                if (constraint(t)&&bound(t))//����Լ���������޽�����   
	                {  
	                    //solution��ʾ�ڽڵ�t���õ���һ����  
	                    if (solution(t)) 
	                    	System.out.println("");//�õ������һ�����н⣬���  
	                    else 
	                    	t++;//û�еõ��⣬������������  
	                }  
	            }  
	        }  
	        else //�������ӽڵ㣬������һ��  
	        {  
	            t--;  
	        }  
	    }  
	} 
	
	/**
	 * Լ���������������㷵��true���������򷵻�false
	 * @param n
	 * @return
	 */
	boolean constraint(int n){
		return true;
	}
	
	/**
	 * �߽�����������ԭ��ͬ��
	 * @param n
	 * @return
	 */
	boolean bound(int n){
		return true;
	}
	
	/**
	 * �õ��ڵ�n��ֵ������
	 * @param n
	 * @return
	 */
	int value(int n){
		return n;
	}
	
	/**
	 * �ڽڵ�n�õ���һ����
	 * @param n
	 * @return
	 */
	boolean solution(int n){
		return true;
	}
	
	/**
	 * ���n�Ƿ�����ӽ��
	 * @param n
	 * @return
	 */
	boolean ExistSubNode(int n){
		return true;
	}
}
