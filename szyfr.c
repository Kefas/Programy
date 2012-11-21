#include <stdio.h>
#include <stdlib.h>

int main(void)
{

char ch	;
int ok,zmiana;
float a,e,i,o,u,y,wszystkie,z;
  
  FILE *fp, *fs;
  fp=fopen("zamiana.txt","r");
  fs=fopen("zmiana.txt","w");
  ch=getc(fp);
  if(fp==NULL)
   {
   printf("nie moge otworzy pliku");
   exit(1);
   }
  

wszystkie=0;

if(fp!=NULL)
{

for (zmiana=0;zmiana<=25;zmiana++)
{
  wszystkie=0;
  z=0;
  a=0;
  e=0;
  i=0;
  o=0;
  u=0;
  y=0;
  
  while((ch=getc(fp))!=EOF)
   {
   wszystkie++;
   
    ok=0;
    if( ( (ch>='a'+zmiana)&&(ch<='z') ) || ( (ch>='A'+zmiana)&&(ch<='Z') ) )
     {
     ch=ch - zmiana;
     ok=1;
     }
    if( (((ch>='a')&&(ch<='a' + zmiana)) ||((ch>='A')&&(ch<='A' + zmiana))) && (ok==0))  ch=ch - zmiana + 26;
   
    
    if (ch=='a'||ch=='A') a++; 
    if (ch=='e'||ch=='E') e++;
    if (ch=='i'||ch=='I') i++;
    if (ch=='o'||ch=='O') o++;
    if (ch=='u'||ch=='U') u++;
    if (ch=='y'||ch=='Y') y++;
    z=(a+e+i+o+u+y);     
  }
  if (z>=((20*wszystkie)/100))
 {
  fseek(fp, 0L, SEEK_SET);
  break;
 }
fseek(fp, 0L, SEEK_SET);
}
}


if(fp!=NULL)
{
   while((ch=getc(fp))!=EOF)
   {
    ok=0;
    
    if( ( (ch>='a'+zmiana)&&(ch<='z') ) || ( (ch>='A'+zmiana)&&(ch<='Z') ) )
     {
     ch=ch - zmiana;
     ok=1;
     }
    if( (((ch>='a')&&(ch<='a' +zmiana)) || ((ch>='A')&&(ch<='A'+zmiana))) && (ok==0))  ch=ch - zmiana + 26;
    putc(ch, fs);
  }
}
fclose(fp);
fclose(fs);
return 0;
}

