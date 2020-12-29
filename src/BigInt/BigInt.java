package BigInt;
/**
 * BigInt - a BigInteger implementation in Java.
 * This file is licensed under the MIT license.
 * Do not remove this comment.
 * 2020
 * @author HaithamOumerzoug
 */
import java.util.ArrayList;
import java.util.List;

public class BigInt {
	StringBuffer s;
		
	public BigInt() {
		this.s=new StringBuffer("");
	}
	public BigInt(StringBuffer s) { 
		StringBuffer news= new StringBuffer("");
		int c=0;
		news=s;
		for(int i=0 ; i<news.length() ; i++) {
			 if(!check(news.charAt(i))) {
				 c++;
			 }
		}
		if(c!=0) {
			System.out.println("Char at string is not a valid int");
			System.exit(0);
		}
		else this.s= new StringBuffer(s);
		
	}
	static boolean check(char c) {
		switch (c) {  // Check if values are only integer.
			case '-': return true;
			case '0': return true;
			case '1': return true;
			case '2': return true;
			case '3': return true;
			case '4': return true;
			case '5': return true;
			case '6': return true;
			case '7': return true;
			case '8': return true;
			case '9': return true;
			default:
				  return false;
		}
	}
	//Addition method
	public BigInt Add(BigInt b) {
		//Declaration of variables
		int carry=0;
		int sm=0;
		int n=this.s.length();
		int m=b.s.length();
		StringBuffer nothing=new StringBuffer("");
		BigInt ocp = this;
		BigInt ocp2 = b;
		BigInt y=new BigInt(nothing);
		
		if(n==0 & m==0) {
			y.s.append("0");
		}
		else if(ocp.s.charAt(0) == '-' && ocp2.s.charAt(0) == '-') {
			ocp.s.delete(0,1);
			ocp2.s.delete(0, 1);
			y=ocp.Add(ocp2);
			y.s.insert(0, '-');
		}
		else if(ocp.s.charAt(0) == '-') {
			ocp.s.delete(0,1);
			y=ocp2.Sub(ocp);
		}
		else if(b.s.charAt(0) == '-') {
			ocp2.s.delete(0,1);
			y=ocp.Sub(ocp2);
		}
		else {
			List<Integer> list = new ArrayList<Integer>();
			for(int i=n-1,j=m-1;i>=0 || j>=0;i--,j--) {
				sm=carry;
				if(i>=0) {
					sm=sm+ocp.s.charAt(i)-'0';
				}
				if(j>=0) {
					sm=sm+ocp2.s.charAt(j)-'0';
				}
				list.add(sm%10);
				carry=sm/10;
			}
			if(carry!=0) {
				list.add(carry);
			}
			for(int i=list.size()-1;i>=0;i--) {
				y.s.append(Integer.toString((list.get(i))));
			}
		}
		return y;
	}
	//Subtraction method
	public BigInt Sub(BigInt b) {
		StringBuffer zero = new StringBuffer("0");
		BigInt answer= new BigInt(zero);
		BigInt ocp = this;
		BigInt ocp2 = b;
		StringBuffer ans,temp;
		int carry=0,k,y=0;
		int flag=0,flag1=0,sm=0;
		
		if(ocp.s.toString().equals(ocp2.s.toString())) {
			if((ocp.s.charAt(0)=='-' && ocp2.s.charAt(0)=='-') || (ocp.s.charAt(0)!='-' && ocp2.s.charAt(0)!='-')) {
				BigInt rs= new BigInt(zero);
				return rs;	
			}
		}
		else if(ocp.s.charAt(0) == '-' && ocp2.s.charAt(0) == '-') {
			flag1=1;
			ocp.s.delete(0,1);
			ocp2.s.delete(0, 1);
		}
		else if(ocp.s.charAt(0) == '-' && ocp2.s.charAt(0) != '-') {
			ocp.s.delete(0, 1);
			answer=ocp.Add(ocp2);
			answer.s.insert(0,'-');
			return answer;
		}
		else if(ocp.s.charAt(0) != '-' && ocp2.s.charAt(0) == '-') {
			ocp2.s.delete(0,1);
			answer=ocp.Add(ocp2);
			return answer;
		}
		ans=ocp.Max(ocp2);
		if(ans == ocp2.s) {
			temp = ocp.s;
			ocp.s=ocp2.s;
			ocp2.s=temp;
			flag=1;
		}
		int n=ocp.s.length();
		int m=ocp2.s.length();
		if(n>m) {
			k=n;
		}else k=m;
		
		int[] list = new int[k+1];
		for(int i=n-1,j=m-1;i>=0 || j>=0;i--,j--) {
			sm=0;
			if(i>=0) {
				sm=sm + ocp.s.charAt(i)-'0';
			}
			if(j>=0) {
				if(sm < (ocp2.s.charAt(j)-'0'+carry)) {
					sm+=10;
					sm=sm-(ocp2.s.charAt(j)-'0'+carry);
					carry=1;
				}
				else {
					sm=sm - (ocp2.s.charAt(j)-'0'+carry);
					carry=0;
				}
			}
			if(carry!=0 && j<0) {
				if(sm < carry) {
					sm+=10;
					sm=sm-carry;
					carry=1;
				}
				else {
					sm=sm-carry;
					carry=0;
				}
			}
			list[y++]=sm;
			
			
		}
		for(int i=k-1;i>=0;i--) {
			answer.s.append(Integer.toString(list[i]));
		}
		
		boolean check=false;
		int c=0;
		if(answer.s.charAt(0) == '-') {
			check=true;
			c++;
		}
		while(answer.s.charAt(c) == '0') {
			c++;
		}
		if(check)answer.s.delete(1, c);
		else answer.s.delete(0, c);
		
		if(flag==0 && flag1==1) {
			answer.s.insert(0,'-');
		}
		else if(flag==1 && flag1==0) {
			answer.s.insert(0,'-');}
		
		return answer;
	}
	//Max method
	public StringBuffer Max(BigInt b) {
		StringBuffer answer= new StringBuffer("");
		if(this.s.charAt(0) == '-' && b.s.charAt(0) != '-' && this.s.length() == b.s.length()) {
			for(int i=0 ; i<this.s.length() ; i++) {
				if(this.s.charAt(i)-'0' < b.s.charAt(i)-'0') {
					return b.s;
				}
				else if(this.s.charAt(i)-'0' > b.s.charAt(i)-'0') {
					return this.s;
				}
				else if(this.s.charAt(i)-'0' == b.s.charAt(i)-'0') {
					continue;
				}
			}
		}
		else if(this.s.charAt(0) != '-' && b.s.charAt(0) == '-' && this.s.length() == b.s.length()) {
			for(int i=0 ; i<this.s.length() ; i++) {
				if(this.s.charAt(i)-'0' < b.s.charAt(i)-'0') {
					return b.s;
				}
				else if(this.s.charAt(i)-'0' > b.s.charAt(i)-'0') {
					return this.s;
				}
				else if(this.s.charAt(i)-'0' == b.s.charAt(i)-'0') {
					continue;
				}
			}
		}
		else if(this.s.charAt(0)!='-' && b.s.charAt(0)!='-' && this.s.length()==b.s.length()) {
			for(int i=0;i<this.s.length();i++) {
				
				if(this.s.charAt(i)-'0'<b.s.charAt(i)-'0') {
					return b.s;
				}
				else if(this.s.charAt(i)-'0' > b.s.charAt(i)-'0') {
					return this.s;
				}
				else if(this.s.charAt(i)-'0' == b.s.charAt(i)-'0') {
					continue;
				}
				
			}
		}
		else if(this.s.charAt(0)=='-' && b.s.charAt(0)!='-') {
			return b.s;
		}
		else if(this.s.charAt(0)!='-' && b.s.charAt(0)=='-') {
			return this.s;
		}
		else if(this.s.charAt(0)!='-' && b.s.charAt(0)!='-' && this.s.length()>b.s.length()) {
			return this.s;
		}
		else if(this.s.charAt(0)!='-' && b.s.charAt(0)!='-' && this.s.length()<b.s.length()) {
			return b.s;
		}
		else if(this.s.charAt(0)=='-' && b.s.charAt(0)=='-' && this.s.length()>b.s.length()) {
			return b.s;
		}
		else if(this.s.charAt(0)=='-' && b.s.charAt(0)=='-' && this.s.length()<b.s.length()) {
			return this.s;
		}
		else if(this.s.charAt(0) == '-' && b.s.charAt(0) == '-' && this.s.length() == b.s.length()) {
			for(int i=0 ; i<this.s.length() ; i++) {
				if(this.s.charAt(i)-'0' < b.s.charAt(i)-'0') {
					return b.s;
				}
				else if(this.s.charAt(i)-'0' > b.s.charAt(i)-'0') {
					return this.s;
				}
				else if(this.s.charAt(i)-'0' == b.s.charAt(i)-'0') {
					continue;
				}
			}
		}
		
		return answer;
	}
	//Multiplication modulo
	public BigInt Mult(BigInt b) {
		int flag=0,flag1=0;
		StringBuffer cps=new StringBuffer(this.s);
		StringBuffer cps2=new StringBuffer(b.s);
		if(cps.charAt(0) == '-' && cps2.charAt(0) == '-') {
			cps.delete(0, 1);
			cps2.delete(0, 1);
		}
		else if(cps.charAt(0) == '-') {
			cps.delete(0,1);
			flag1=1;
			}
		else if(cps2.charAt(0) == '-') {
			cps2.delete(0, 1);
			flag1=1;
			}
		int n=cps.length();
		int m=cps2.length();
		int[] list = new int[n+m];
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				int mul=(cps.charAt(i)-'0')*(cps2.charAt(j)-'0');
				int sum=list[i+j+1]+mul;
				list[i+j]= list[i+j]+(sum/10);
				list[i+j+1] = sum%10;
			}
		}
		BigInt rs= new BigInt();
		for(int i=0;i<m+n;i++) {
			if(list[i]!=0 || flag!=0) {
				if(list[i]!=0) {
					flag=1;
				}
			}
			if(flag==1) {
				rs.s.append(Integer.toString(list[i]));
			}
		}
		if(flag1==1) {
			rs.s.insert(0,'-');
		}
		if(rs.s.length()==0) {
			rs=new BigInt();
		}
		return rs;
	}
	//Division method
	public BigInt Divs(BigInt b) {
		StringBuffer zero = new StringBuffer("0");
		StringBuffer ones = new StringBuffer("1");
		BigInt one=new BigInt(ones);
		BigInt ocp=this;
		BigInt ocp1=b;
		BigInt Q=new BigInt(ones);
		if(ocp1.s.toString().equals(zero.toString())){
			System.out.println("The divisor must be not-null");
			Q=null;
		}
		else if(ocp.s.charAt(0)=='-' && ocp1.s.charAt(0)=='-') {
			ocp.s.delete(0,1);
			ocp1.s.delete(0,1);
		}
		else if(ocp.s.charAt(0)!='-' && ocp1.s.charAt(0)=='-') {
			ocp.s.delete(0,1);
			Q.s.insert(0, '-');
		}
		else if(ocp.s.charAt(0)=='-' && ocp1.s.charAt(0)!='-') {
			ocp1.s.delete(0, 1);
			Q.s.insert(0, '-');
		}
		while(ocp1.inf(ocp)) {
			ocp=ocp.Sub(ocp1);
			Q=Q.Add(one);
		}
		return Q;
	}
	public boolean inf(BigInt b) {
		if(this.s.length() > b.s.length()) {
			return false;
		}
		else if(this.s.length() < b.s.length()) {
			return true;
		}
		else if(this.s.length() == b.s.length()){
			if(this.s.toString().equals(b.s.toString())) {
				return false;
			}
			else {
				for(int i=0 ; i<this.s.length() ; i++) {
					if(this.s.charAt(i)-'0' < b.s.charAt(i)-'0') {
						return false;
					}
					else if(this.s.charAt(i)-'0' >= b.s.charAt(i)-'0') {
						continue;
					}
				}
			}
		}
		return false;
	}
	//Modulo method
	public BigInt Mod(BigInt a,BigInt b) {
		return a.Sub(b.Mult(a.Divs(b)));
	}
	
	public BigInt AddMod(BigInt a, BigInt b) {
		return this.Mod(this.Add(a), b);
	}
	public BigInt SubMod(BigInt a, BigInt b) {
		return this.Mod(this.Sub(a), b);
	}
	public BigInt MultMod(BigInt a, BigInt b) {
		return this.Mod(this.Mult(a), b);
	}
	public BigInt DivsMod(BigInt a,BigInt b) {
		return this.Mod(this.Divs(a), b);
	}
	//Main function
	public static void main(String[] args) {
		System.out.println("*Java-BigInt*");
		StringBuffer s1=new StringBuffer("-56788545667765455786557775433456899875555444565434567889976755");
		StringBuffer s2=new StringBuffer("-56776656778867654456789997544776544456677887655444455667780112346");
		StringBuffer s3=new StringBuffer("27654565456677654567899907654321234565677765434567889976755");
		BigInt a =new BigInt(s1);
		BigInt b =new BigInt(s2);
		BigInt c =new BigInt(s3);
		System.out.println("Sum ="+(a.Add(b)).s);
		System.out.println("Subtraction = "+(a.Sub(b)).s);
		System.out.println("Multiplication = "+(a.Mult(b)).s);
		System.out.println("Division = "+(a.Divs(b)).s);
		System.out.println("Sum modulo "+ s3 +"= "+(a.AddMod(b,c)).s);
		System.out.println("Subtraction modulo "+ s3 +"= "+(a.SubMod(b,c)).s);
		System.out.println("Multiplication modulo "+ s3 +"= "+(a.MultMod(b,c)).s);
		System.out.println("Division modulo "+ s3 +"= "+(a.DivsMod(b,c)).s);
	}
	//Thank you for reading my repository, i hope you learn something new .
	//T
}

