package com.lyh;

public class Queen8 {
	
	int[] a = new int[9];
	int n = 8, count = 0;
	
	/**
	 * λ�ó�ͻ�㷨��i��ʾ�����̵ĵ�i�У�a[i]��ʾ�ڵ�i�������Ӱ�����һ��
	 * ����ѭ�ĺ��Ĺ����ǣ���(a[i]-a[j])/(i-j)=��1ʱ���ʺ�֮��������ͻ
	 * ���巽���ǣ��ӵڶ��п�ʼ���Ա��к������ļ��зֱ�Ƚϣ����Ƿ������ͻ���Դ��ַ���������������Ƿ���ڳ�ͻ
	 * @param a
	 * @param n
	 * @return
	 */
	boolean Chongtu(int a[], int n)//a[]λ�����飬n�ʺ���� 
	{
	    int i = 0, j = 0;
	 
	    for (i = 2; i <= n; ++i)//i��λ�� 
	        for (j = 1; j <= i-1; ++j)//j��λ�� 
	            if ((a[i] == a[j]) || (Math.abs(a[i]-a[j]) == i-j))//1����һ�У�2���ڶԽ����� 
	                return false;   //��ͻ 
	    return true;//����ͻ 
	}
	
	/**
	 * �˻ʺ����⣺�����㷨���ݹ�棩 
	 * ������������ݹ�ڷŵڼ����ʺ�
	 * @param k
	 */
	void Queens8(int k)//����k���ݹ�ڷŵ�k���ʺ� 
	{
	    int i = 0;
	 
	    if (k > n)//k>n����k>8��ʾ���һ���ʺ�ڷ���� 
	    {
	    	++count;
	        System.out.println("��"+count+"�������");
	        for (i = 1; i <= n; ++i)
	            System.out.println(a[i]);//��ӡ��� 
	        System.out.println("\n");
	    }
	    else//8���ʺ�δȫ���ڷ����        
	    {
	        for (i = 1; i <= n; ++i)//�ڷŵ�k���ʺ�ʱ��ת��һ�У� 
	        {   //���δ��ж��˿�ʼ������һֱ���е׶ˣ�ֱ���ҵ�����λ��,���δ�ҵ����Զ������ϲ�ݹ�(����) 
	            a[k] = i;               
	            if (Chongtu(a,k))//����ͻ 
	                Queens8(k+1);//�ݹ�ڷ���һ���ʺ�
	        }
	    }
	    return;
	}
	
	public static void main(String[] args) {
		Queen8 test = new Queen8();
		test.Queens8(1);//����1����ʾ�ڷŵ�1���ʺ�
	}
}
