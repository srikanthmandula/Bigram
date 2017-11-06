import java.io.*;
import java.util.*;

class BigramOps
{
public int rowsize()
{
int j=0;
try
{

FileReader fr1=new FileReader("input.txt");
BufferedReader br=new BufferedReader(fr1);
String s2;
while((s2=br.readLine())!= null)
{
String []words=s2.split(" ");
for(int t=0;t<words.length;t++)
{
if(t==words.length-1)
break;
j++;
}//for
}//while

}//try
catch(Exception e)
{
System.out.println(e);
}
return j;
}

public void fileRead(int q)
{
try
{
int j=q;
int te=0;

String[][] biarr=new String[j][3];
FileReader fr=new FileReader("input.txt");
BufferedReader br=new BufferedReader(fr);
String s1;
while((s1=br.readLine())!= null)
{
String []words=s1.split(" ");
for(int t=0;t<words.length;t++)
{

if(t==words.length-1)
break;
biarr[te][0]=words[t];
biarr[te][1]=words[t+1];
biarr[te][2]="1";
te++;
}//for
}//while

int a[]=new int[j];

for(int k=0;k<j;k++)
for(int p=k+1;p<j;p++)
if(biarr[k][0].equals(biarr[p][0]) && biarr[k][1].equals(biarr[p][1]))
{
a[k]=a[k]+1;
}

Workings ws;
ws=Workings.LINE;
ws.freq=new int[j];
ws.biarr2=new String[j];

for(int k=0;k<j;k++)
{
ws.freq[k]=a[k]+1;
ws.biarr2[k]=biarr[k][0]+" "+biarr[k][1];
}

ArrayList<String> at=new ArrayList<String>();
for(int k=0;k<j;k++)
{
at.add(ws.biarr2[k]+" "+ws.freq[k]);
}

int max=ws.freq[0];
for(int k=0;k<ws.freq.length;k++)
{
if(ws.freq[k]>max)
{
max=ws.freq[k];
}
}

int t=0;

while(max!=1)
{
for(int l=0;l<j;l++)
{
if(ws.freq[l]==max)// && (biarr[k][0].equals(biarr[l][0]) && biarr[k][1].equals(biarr[l][1])))
{
at.remove(ws.biarr2[l]+" "+ws.freq[l]);
at.add(t,ws.biarr2[l]+" "+ws.freq[l]);
t++;
}
}
max=max-1;
}

for(int k=0;k<at.size();k++)
System.out.println(at.get(k));

}//try

catch(Exception e)
{
System.out.println(e);
}//catch
}

enum Workings
{
LINE;
int freq[];
String biarr2[];
}

}//class

class BigramFreq
{
public static void main(String []args)
{
int j;
BigramOps b1=new BigramOps();
j=b1.rowsize();
b1.fileRead(j);

}//main
}//class

