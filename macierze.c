#include <stdio.h>
#include <stdlib.h>

void sum( int a, int b, int matrice1[a][b], int matrice2[a][b], int matriceC[a][b]);
void print( int a, int b, int matrice[a][b]);
void multiply(int a, int b, int y, int q, int matrice1[a][b], int matrice2[b][a], int matriceC[y][y]);

int main(void)
{
  int m,n,z,i,j,x,w ;
  


  printf(" This is a program to multiply and sum matrices\n");
  printf(" You can summing matrices in the same sizes and multipying matrices of inverse sizes.");
  
  while(z!=3)
  {
  printf("What do You wish for? \n 1. Sum up matrices \n 2. Multiply matrices\n 3. Exit \n");
  scanf("%d",&z);
  
  if (z==2)
   {
    printf("Type number of lines matrice A: m= ");
    scanf("%d", &m);
    printf("Type number of columns matrice A: n= ");
    scanf("%d", &n);
    printf("Matrice A has got %d-lines and %d-columnes", m, n);
    printf("Matrice B has got %d-lines and %d-columnes", n, m);

    int matriceA[m][n];
    int matriceB[n][m];
    if (n<m) {x=m;w=n;}  else {x=n;w=m;} /* x>w */
    int matriceC[x][x];

    printf("Fill in matrice A");
    
    for(i=0;i<n;i++)
    {
      for(j=0;j<m;j++)
	{
          printf("Type %d,%d element",i,j);
          scanf("%d", &matriceA[i][j]);
	}
    }
  
    printf("Fill in matrice B");
    
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
	{
          printf("Type %d,%d element",i,j);
          scanf("%d", &matriceB[i][j]);
	}
    }
    
   
    for(i=0;i<x;i++)                        /*Filling 0  matrice C*/
    {  
      for(j=0;j<x;j++)
       {
	matriceC[i][j]=0;
       }
    }   

     print(x,x,matriceC); 

    printf("\nMatrice A\n");
     print(m,n,matriceA);
    printf("\nMatrice B\n");
     print(n,m,matriceB);
    printf("\nMatrice C before\n");
     print(x,x,matriceC);
    
    multiply(n,m,w,x,matriceA, matriceB, matriceC);
    
    printf("\nMatrice C after\n");
    print(x,x, matriceC);

     
   }

  if(z==1)  /* Dodawanie */
    {
      printf(" Do you remember? You can only summing matrices of this same size");
    printf("Type number of lines: m= ");
    scanf("%d", &m);
    printf("Type number of columns: n= ");
    scanf("%d", &n);

    int matriceA[m][n];
    int matriceB[m][n];
    int matriceC[m][n];
    
    
printf("Fill in matrice A");
    
    for(i=0;i<n;i++)
    {
      for(j=0;j<m;j++)
	{
          printf("Type %d,%d element",i,j);
          scanf("%d", &matriceA[i][j]);
	}
    }
  
    printf("Fill in matrice B");
    
    for(i=0;i<n;i++)
    {
      for(j=0;j<m;j++)
	{
          printf("Type %d,%d element",i,j);
          scanf("%d", &matriceB[i][j]);
	}
    }
    printf("\nMatriceA\n");
     print(m,n, matriceA);
    printf("\nMatriceB\n");
     print(m,n, matriceB);
     sum(m,n, matriceA, matriceB,matriceC);
    printf("\nMatriceC\n");
    print(m,n,matriceC);

    }
  }


return 0;
}

void print( int a, int b, int matrice[a][b]) 
{ 
  int i,j;

  for(i=0;i<b;i++)
    {
      for(j=0;j<a;j++)
	{
	  printf(" %d ", matrice[i][j]);
        }
      printf("\n");
    }
}

void multiply(int a, int b, int y, int q, int matrice1[a][b], int matrice2[b][a], int matriceC[y][y]) /* y<q */
{
  int i,j,w;

  for(i=0;i<q;i++)
    {printf(" i=%d ",i);
      
      for(j=0;j<q;j++)
	{ printf(" j=%d ",j); /*nie działa dla innych rozmiarów niż kwadrat*/
          for(a=0;a<y;a++)
	    {
             printf(" a=%d ",a);
	     matriceC[j][i]=matriceC[j][i]+ (matrice1[j][a]*matrice2[a][i]);
	    }
	}
    }
}

void sum( int a, int b, int matrice1[a][b], int matrice2[a][b], int matriceC[a][b])
   {
     int i,j;
 
     for(i=0;i<b;i++)
     {
       for(j=0;j<a;j++)
       {
	 matriceC[i][j]=matrice1[i][j]+matrice2[i][j];
       }
     }
   }
