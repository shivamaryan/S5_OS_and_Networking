#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

void forkexample()
{
	int x=1;
	
	if(fork()==0)
		printf("\n Child Process \n");
		
	else
		printf("Parent Process \n");
}

void main()
{
	int fds[2];
	pipe(fds);
	
	return 0;
}
