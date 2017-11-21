#include<sys/types.h>
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
int checkPrime(int d)
{	
	int i;
	for(i=2;i<=d/2;i++)	
	{
		if(d%i==0)
		   return 0;
	}
	return 1;
}

int main()
{

	int msg[]={105,3,42,13,54,2,55,29},no[8],k,c=0,j[8];
	int p[2],fd[2],i;
	int pid;
	if(pipe(p)<0 || pipe(fd)<0)
	   exit(1);
	for(i=0;i<8;i++)
		write(p[1],&msg[i],sizeof(msg[i]));//writing to child process through pipe p[]
	pid=fork();
	wait(1);
	if(pid==0)//child process
	{	
		printf("IN CHILD PROCESS\n");
		for(i=0;i<8;i++)
		{
	     	read(p[0],&no[i],sizeof(no[i]));
			if(checkPrime(no[i])==1)
			{
			   j[c]=no[i];
			   c++;
			}
		}
		close(p[0]);
		close(p[1]);
		   write(fd[1],&c,sizeof(j[i]));//writing to parent process through pipe fd[]
		for(i=0;i<c;i++)	
		   write(fd[1],&j[i],sizeof(j[i]));
	}
	else if(pid>0)//parent process
	{	
		printf("IN PARENT PROCESS\n");
		printf("The Prime Numbers are :\n");
		read(fd[0],&k,sizeof(k));
		int d=k;
		for(i=0;i<d;i++)
		{
			read(fd[0],&k,sizeof(k));
			printf("%d\n",k);
		}
	}
	else 
	    printf("Error in creation");
	close(fd[0]);
	close(fd[1]);
 	return 0;
}

