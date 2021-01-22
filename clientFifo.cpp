#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/stat.h>
#include<sys/types.h>
using namespace std;
int main()
{
	char fname[50],buffer[1025];
	int req,res,n,file;
	req = open("req.fifo",O_WRONLY);
	res = open("res.fifo",O_RDONLY);
	printf("Enter the filename\n");
	scanf("%s",fname);
	write(req,fname,sizeof(fname));
	while((n=read(res,buffer,sizeof(buffer)))>0)
	{
		printf("%s\n",buffer);
	}
	close(req);
	close(res);
	return 0; 
}
