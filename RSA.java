import java.util.*;
import java.math.*;
import java.lang.*;

class RSA
{
	public static void main(String[] args)
	{
		int p = 13;
		int q = 11;
		
		int n = p*q;
		int phi = (p-1)*(q-1);
		int e=0,d=0;

		for(int i =2;i<phi;i++)
		{
			if(gcd(i,phi) == 1)
			{
				e = i;
				break;
			}
		}

		//calculate public key
		for(int i =0;i<=9;i++)
		{
			int x = 1+(i*phi);
			if(x%e == 0)
			{
				d = x/e;
				break;
			}
		}

		int msg = 14;
		System.out.println("original msg: "+msg);
		//generate cipher text(encrypt)
		double c = Math.pow(msg,e)%n;
		System.out.println("\ndecrypted msg:" +c);
		BigInteger N = BigInteger.valueOf(n);

		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		BigInteger msgBack = C.pow(d).mod(N);

		System.out.println("decrypted msg:"+ msgBack);
	}

	public static int gcd(int a,int b)
	{
		if(a == 0)
		return b;
		
		return gcd(b%a,a);
	}
}
