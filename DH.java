import java.util.*;
import java.math.*;
import java.lang.*;

public class DH
{
	public static void main(String[] args)
	{
		int p,q,a,b;
		double x,y,ka,kb;

		Scanner in = new Scanner(System.in);
		System.out.println("\n enter prime number:");
		q = in.nextInt();
		System.out.println("\nenter primitive root:");
		p = in.nextInt();

		System.out.println("\nenter private key for user 1:");
		a = in.nextInt();
		System.out.println("\nenter private key for user 2:");
		b = in.nextInt();

		//calculate public key
		x = Math.pow(p,a)%q;
		y = Math.pow(p,b)%q;
		System.out.println("\npublic key for user1:" +x+ " public key for user 2: "+y);

		//calculate symmetric key after exchanging public keys
		ka = Math.pow(y,a)%q;
		kb = Math.pow(x,b)%q;

		System.out.println("\nsymmetric key for user1:" +ka+ " Symmetric key for user 2: "+kb);
	}
}

