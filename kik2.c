#include <stdio.h>
#include<string.h>
#include <time.h>

void wyswietl(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8);
int sprawdz(char);/*sprawdz czy wolne*/
char wygrana(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8);
int komputer(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8, int ruch2, int ok2, char wybor12, char wybor22); 
int komputer2(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8, int ruch2, int ok2, char wybor12, char wybor22);

int main(void) {
 
  char tablica[9] = {32, 32, 32, 32, 32, 32, 32, 32, 32};
  int p, index, ch, ruch, kto, poziom;
  char wyb, wybor1, wybor2, *wskaznik, gracz1[40], gracz2[40];
  
  printf("Witaj, oto gra w kólko i krzyżyk\n");
  
do
{
  printf("Wybierz opcję gry. \n1. Gracz kontra gracz.\n2. Gracz kontra komputer\n Twój wybór: ");
  scanf("%d",&ch); 
     switch(ch)
      {
case 1: 
    ruch=1;                                         /*inicjalizacja gracza ruchu i ustawienie p==0*/
    p=0; 
    printf("Wybrałeś opcję Gracz kontra Gracz.\n");
    printf("Podaj imię gracza pierwszego: ");
    scanf("%s", gracz1);
    printf("\nPodaj imię gracza drugiego: ");
    scanf("%s", gracz2);
    wskaznik=gracz1;

    while(wyb!='x' && wyb!='o')
     {    
    printf("\n%s wybiera: kółko o czy krzyzyk x -", gracz1);
    wyb = getchar();                                /*nie wiem czemu tak ma to byc ale jest*/
    scanf("%c", &wyb);
  
        if (wyb=='o')
          { 
           wybor1='O';
           wybor2='X';
          }
        if (wyb=='x')
          {
           wybor1='X';
           wybor2='O';
          }      
        if (wyb!='x' && wyb!='o') 
          {
           printf("w co ty sobie pogrywasz? Należy wcisnąć x lub o! Wciskaj, masz kolejna szanse: \n");
          }
    }

    printf("%s gra %c a %s gra %c \n\n",gracz1, wybor1, gracz2, wybor2);
        
printf(" 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 \n");
 while(ruch<=9)                                           /*pętla właściwej gry case 1*/
  {  
   printf("ruch %d, gracz: %s \n",ruch, wskaznik); 
  while(p<1)
   {
    index=10;
    while((index>9)||(index<0))
    {
    printf("%s wybiera pole(od 1 do 9) gdzie chce postawić znak\n Twój wybór : ",wskaznik);
    scanf("%d", &index);
    if ((index<0) || (index>9)) printf("stosuj się do poleceń!\n");
    }
    
    index=index-1;
    sprawdz(tablica[index]);
    (p=sprawdz(tablica[index]));
    if (sprawdz(tablica[index])==0) printf("Przykro mi, ale to pole jest już zajęte\n");  /*stąd wyniesiemy ok=1 i index rowny wyborowi*/
   }
    
    if (wskaznik==gracz1) tablica[index]=wybor1;
    if (wskaznik==gracz2) tablica[index]=wybor2;
   
                             
      wyswietl(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);
  
   if (wskaznik==gracz1) wskaznik=gracz2;
   else wskaznik=gracz1;   
                     
   
   wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);
   
   if (wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8])=='X')
    {
    if (wyb=='x')
    printf("Gratuluje, wygrał %s\n",gracz1);
    if (wyb=='o')
    printf("Gratuluje, wygrał %s\n",gracz2);
    break;
    }
   
   if (wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8])=='O')
    {
    if (wyb=='x')
    printf("Gratuluje, wygrał %s\n",gracz2);
    if (wyb=='o')
    printf("Gratuluje, wygrał %s\n",gracz1);
    break;
    }
   if (ruch==9) 
    {
    printf("Remis! Gratuluję obu graczom\n");  
    break;
    }
ruch++;
p=0;
} 
    
  break;
  
                                                                 /* CASE 2*/
case 2:
  { 
   
    printf("Wybrałes opcję Gracz kontra komputer\n");    /*wybor imienia i poziomu*/
    printf("Wybierz poziom trudności:\n1. Poziom łatwy\n2. Poziom trudny\nTwój wybór : ");
    scanf("%d",&poziom);
    printf("\nWpisz swoje imię: ");
    scanf("%s", gracz1);
    char gracz2[40]="komputer";
  do
  {
    printf("\ngracz 1 : %s, gracz 2 : %s\n", gracz1, gracz2); /*wybor kolejnosci*/
    printf("Kto zaczyna? 1-gracz 2-komputer\nTwój wybór : ");    
    scanf("%d", &kto);
    if (kto==1)
      {
       wskaznik=gracz1;
      }
    if (kto==2)
      {
       wskaznik=gracz2;
      }
    else if ((kto<0)||(kto>2)) printf("\nStosuj się do poleceń!\n"); 
   } while ((kto<0)||(kto>2));

while(wyb!='x' && wyb!='o')                                  /*wybor znaku*/
     {    
    printf("\nProsze wybrac czym będzie grał %s kółko o czy krzyzyk x? : ", wskaznik); 
    wyb = getchar();                                /*nie wiem czemu tak ma to byc ale jest*/
    scanf("%c", &wyb);
  
        if (wyb=='o')
          { 
           wybor1='O';
           wybor2='X';
          }
        if (wyb=='x')
          {
           wybor1='X';
           wybor2='O';
          }      
        if (wyb!='x' && wyb!='o') 
          {
           printf("\nw co ty sobie pogrywasz? Należy wcisnąć x lub o! Wciskaj, masz kolejna szanse: \n");
          }
    }
    if (kto==2)
    printf("2 %s gra %c a %s gra %c \n",gracz1, wybor2, gracz2, wybor1);
    if (kto==1)
    printf("1 %s gra %c a %s gra %c \n",gracz1, wybor1, gracz2, wybor2);

 ruch=1;
    p=0;
do                                             /*ruch gracza*/
{
  if (((wskaznik==gracz1)&&(kto==1))||((wskaznik==gracz1)&&(kto==2)))
 {
  if (ruch==1) printf(" 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 \n");
  printf("\nruch %d, gracz: %s \n\n",ruch, wskaznik);
  
  while(p<1)
   {
    index=10;
    while((index>9)||(index<0))
     {
    printf("%s wybiera pole(od 1 do 9) gdzie chce postawić znak\nTwój wybór : ",wskaznik);
    scanf("%d", &index);
    if ((index<0) || (index>9)) printf("stosuj się do poleceń!\n");
     }
    
    index=index-1;
    sprawdz(tablica[index]);
    (p=sprawdz(tablica[index]));
    if (sprawdz(tablica[index])==0) printf("Przykro mi, ale to pole jest już zajęte\n");
   }
    
    if ((wskaznik==gracz1)&&(kto==1)) tablica[index]=wybor1;
    if ((wskaznik==gracz2)&&(kto==2)) tablica[index]=wybor1;
    if ((wskaznik==gracz1)&&(kto==2)) tablica[index]=wybor2;
    if ((wskaznik==gracz2)&&(kto==1)) tablica[index]=wybor2;
    
    if (wskaznik==gracz1) wskaznik=gracz2;
    else wskaznik=gracz1;
    
wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);
   
   if (wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8])=='X')
    {
wyswietl(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);    
    if ((wyb=='x')&&(kto==1))
    printf("Gratuluje, wygrał %s\n",gracz1);
    if ((wyb=='o')&&(kto==1))
    printf("Gratuluje, wygrał %s\n",gracz2);
    if ((wyb=='x')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz2);
    if ((wyb=='o')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz1);
    break;
    }
   
   if (wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8])=='O')
    {
wyswietl(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);    
    if ((wyb=='x')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz1);
    if ((wyb=='o')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz2);
    if ((wyb=='x')&&(kto==1))
    printf("Gratuluję, wygrał %s\n",gracz2);
    if ((wyb=='o')&&(kto==1)) 
    printf("Gratuluję, wygrał %s\n",gracz1);
    break;
    }
   if (((ruch==9)&&(poziom==1))||((ruch==9)&&(poziom==2))) 
    {
    printf("Remis! Gratuluję obu graczom\n");  
    break;
    }
    ruch++;
    p=0;           
 }                           
  
  
 if ((((wskaznik==gracz2)&&(kto==1))||((wskaznik==gracz2)&&(kto==2)))&&(poziom==2))   /*ruch komputera trudny*/
  {
   if (ruch==1)
    {
      if (kto==1) tablica[4]=wybor2;
      if (kto==2) tablica[4]=wybor1;
    }
   if (ruch>1)
   komputer(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8], ruch, kto, wybor1, wybor2);
   
   index=komputer(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8], ruch, kto, wybor1, wybor2);
   index=index-1;
 
    if (kto==1) tablica[index]=wybor2;
    if (kto==2) tablica[index]=wybor1;

     
    if (wskaznik==gracz1) wskaznik=gracz2;
    else wskaznik=gracz1;                 
    
ruch++;
}
if ((((wskaznik==gracz2)&&(kto==1))||((wskaznik==gracz2)&&(kto==2)))&&(poziom==1))   /*ruch komputera łatwy*/
{
  komputer2(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8], ruch, kto, wybor1, wybor2);

   index=komputer2(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8], ruch, kto,    wybor1, wybor2);
   index=index-1;
 
    if (kto==1) tablica[index]=wybor2;
    if (kto==2) tablica[index]=wybor1;

     
    if (wskaznik==gracz1) wskaznik=gracz2;
    else wskaznik=gracz1; 

    ruch++;
}

   wyswietl(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);    

   wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8]);
   
   if (wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8])=='X')
    {
    if ((wyb=='x')&&(kto==1))
    printf("Gratuluje, wygrał %s\n",gracz1);
    if ((wyb=='o')&&(kto==1))
    printf("Gratuluje, wygrał %s\n",gracz2);
    if ((wyb=='x')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz2);
    if ((wyb=='o')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz1);
    break;
    }
   
   if (wygrana(tablica[0], tablica[1], tablica[2], tablica[3], tablica[4], tablica[5], tablica[6], tablica[7], tablica[8])=='O')
    {
    if ((wyb=='x')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz1);
    if ((wyb=='o')&&(kto==2))
    printf("Gratuluje, wygrał %s\n",gracz2);
    if ((wyb=='x')&&(kto==1))
    printf("Gratuluję, wygrał %s\n",gracz2);
    if ((wyb=='o')&&(kto==1)) 
    printf("Gratuluję, wygrał %s\n",gracz1);
    break;
    }
   if (((ruch==10)&&(poziom==1))||((ruch==10)&&(poziom==2))) 
    {
    printf("Remis! Gratuluję obu graczom\n");  
    break;
    }
  
} while (ruch<=10);   
break;
}

default : printf("błędna opcja\n");
      } 
} while ((ch<0)||(ch>2));
  
  return 0;

}
void wyswietl(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8)
{

  printf(" %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n\n",p0,p1,p2,p3,p4,p5,p6,p7,p8);

}

int sprawdz(char b)
{
int ok;
  if ((b==88)||(b==79))
  ok=0;

  else
  ok=1;
 
 return ok;
}

char wygrana(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8)
{
char wygr;

  if (((p0=='X') && (p1=='X') && (p2=='X')) || ((p3=='X') && (p4=='X') && (p5=='X')) || ((p6=='X') && (p7=='X') && (p8=='X'))
     || ((p0=='X') && (p3=='X') && (p6=='X')) || ((p1=='X') && (p4=='X') && (p7=='X')) || ((p2=='X') && (p5=='X') && (p8=='X'))
     || ((p0=='X') && (p4=='X') && (p8=='X'))|| ((p2=='X') && (p4=='X') && (p6=='X')))
   wygr='X';

  if (((p0=='O') && (p1=='O') && (p2=='O')) || ((p3=='O') && (p4=='O') && (p5=='O')) || ((p6=='O') && (p7=='O') && (p8=='O'))
     || ((p0=='O') && (p3=='O') && (p6=='O')) || ((p1=='O') && (p4=='O') && (p7=='O')) || ((p2=='O') && (p5=='O') && (p8=='O'))
     || ((p0=='O') && (p4=='O') && (p8=='O'))|| ((p2=='O') && (p4=='O') && (p6=='O')))
   wygr='O';

return wygr;
}

int komputer(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8, int ruch2, int kto2, char wybor12, char wybor22)
{
  char wybor2;
  int zarodek, numer;
    zarodek= time(NULL);
    srand(zarodek); 
   
   
  numer=0;
   if ((ruch2==2)&&(p4==32)) numer=5;
   if ((ruch2==2)&&((p4='X')||(p4='O'))&&(numer!=5))
     {
      do
      {
       if ((rand()%8+1)==0) numer=1;
       if ((rand()%8+1)==2) numer=3;
       if ((rand()%8+1)==6) numer=7;
       if ((rand()%8+1)==8) numer=9;
      } while((numer!=1)&&(numer!=2)&&(numer!=3)&&(numer!=4));
     }
                                                            /*warun na zwycięstwo*/
if (kto2==2) wybor2=wybor12;
if (kto2==1) wybor2=wybor22;                                         
/*poz1*/
if ((numer==0)&&(ruch2>2))
{
   
   
   if ((ruch2>2)&&((p0==wybor2)&&(p1==wybor2)&&(p2==32))) numer=3; 
   if ((ruch2>2)&&((p0==wybor2)&&(p2==wybor2)&&(p1==32))) numer=2;
   if ((ruch2>2)&&((p1==wybor2)&&(p2==wybor2)&&(p0==32))) numer=1;
/*poz2*/
   if ((ruch2>2)&&((p3==wybor2)&&(p4==wybor2)&&(p5==32))) numer=6;
   if ((ruch2>2)&&((p4==wybor2)&&(p5==wybor2)&&(p3==32))) numer=4;                     
   if ((ruch2>2)&&((p3==wybor2)&&(p5==wybor2)&&(p4==32))) numer=5;
/*poz3*/
   if ((ruch2>2)&&((p6==wybor2)&&(p7==wybor2)&&(p8==32))) numer=9;
   if ((ruch2>2)&&((p6==wybor2)&&(p8==wybor2)&&(p7==32))) numer=8;
   if ((ruch2>2)&&((p7==wybor2)&&(p8==wybor2)&&(p6==32))) numer=7;           
/*pion1*/ 
   if ((ruch2>2)&&((p0==wybor2)&&(p3==wybor2)&&(p6==32))) numer=7;
   if ((ruch2>2)&&((p0==wybor2)&&(p6==wybor2)&&(p3==32))) numer=4;
   if ((ruch2>2)&&((p3==wybor2)&&(p6==wybor2)&&(p0==32))) numer=1; 
/*pion2*/
   if ((ruch2>2)&&((p1==wybor2)&&(p4==wybor2)&&(p7==32))) numer=8;
   if ((ruch2>2)&&((p1==wybor2)&&(p7==wybor2)&&(p4==32))) numer=5;
   if ((ruch2>2)&&((p4==wybor2)&&(p7==wybor2)&&(p1==32))) numer=2;
/*pion3*/
   if ((ruch2>2)&&((p2==wybor2)&&(p5==wybor2)&&(p8==32))) numer=9;
   if ((ruch2>2)&&((p2==wybor2)&&(p8==wybor2)&&(p5==32))) numer=6;
   if ((ruch2>2)&&((p5==wybor2)&&(p8==wybor2)&&(p2==32))) numer=3;
/*skos P*/
   if ((ruch2>2)&&((p0==wybor2)&&(p4==wybor2)&&(p8==32))) numer=9;
   if ((ruch2>2)&&((p0==wybor2)&&(p8==wybor2)&&(p4==32))) numer=5;
   if ((ruch2>2)&&((p4==wybor2)&&(p8==wybor2)&&(p0==32))) numer=1;
/*skos L*/
   if ((ruch2>2)&&((p2==wybor2)&&(p4==wybor2)&&(p6==32))) numer=7;
   if ((ruch2>2)&&((p2==wybor2)&&(p6==wybor2)&&(p4==32))) numer=5;
   if ((ruch2>2)&&((p4==wybor2)&&(p6==wybor2)&&(p2==32))) numer=3;
}  
   


if (kto2==2) wybor2=wybor22;
if (kto2==1) wybor2=wybor12;                                         /*tutaj będzie warun na obrone*/
/*poz1*/
if ((numer==0)&&(ruch2>2))
{ 
   if ((ruch2>2)&&((p0==wybor2)&&(p1==wybor2)&&(p2==32))) numer=3;
   if ((ruch2>2)&&((p0==wybor2)&&(p2==wybor2)&&(p1==32))) numer=2;
   if ((ruch2>2)&&((p1==wybor2)&&(p2==wybor2)&&(p0==32))) numer=1;
/*poz2*/
   if ((ruch2>2)&&((p3==wybor2)&&(p4==wybor2)&&(p5==32))) numer=6;
   if ((ruch2>2)&&((p4==wybor2)&&(p5==wybor2)&&(p3==32))) numer=4;                     
   if ((ruch2>2)&&((p3==wybor2)&&(p5==wybor2)&&(p4==32))) numer=5;
/*poz3*/
   if ((ruch2>2)&&((p6==wybor2)&&(p7==wybor2)&&(p8==32))) numer=9;
   if ((ruch2>2)&&((p6==wybor2)&&(p8==wybor2)&&(p7==32))) numer=8;
   if ((ruch2>2)&&((p7==wybor2)&&(p8==wybor2)&&(p6==32))) numer=7;           
/*pion1*/
   if ((ruch2>2)&&((p0==wybor2)&&(p3==wybor2)&&(p6==32))) numer=7;
   if ((ruch2>2)&&((p0==wybor2)&&(p6==wybor2)&&(p3==32))) numer=4;
   if ((ruch2>2)&&((p3==wybor2)&&(p6==wybor2)&&(p0==32))) numer=1; 
/*pion2*/
   if ((ruch2>2)&&((p1==wybor2)&&(p4==wybor2)&&(p7==32))) numer=8;
   if ((ruch2>2)&&((p1==wybor2)&&(p7==wybor2)&&(p4==32))) numer=5;
   if ((ruch2>2)&&((p4==wybor2)&&(p7==wybor2)&&(p1==32))) numer=2;
/*pion3*/
   if ((ruch2>2)&&((p2==wybor2)&&(p5==wybor2)&&(p8==32))) numer=9;
   if ((ruch2>2)&&((p2==wybor2)&&(p8==wybor2)&&(p5==32))) numer=6;
   if ((ruch2>2)&&((p5==wybor2)&&(p8==wybor2)&&(p2==32))) numer=3;
/*skos P*/ 
   if ((ruch2>2)&&((p0==wybor2)&&(p4==wybor2)&&(p8==32))) numer=9;
   if ((ruch2>2)&&((p0==wybor2)&&(p8==wybor2)&&(p4==32))) numer=5;
   if ((ruch2>2)&&((p4==wybor2)&&(p8==wybor2)&&(p0==32))) numer=1;
/*skos L*/ 
   if ((ruch2>2)&&((p2==wybor2)&&(p4==wybor2)&&(p6==32))) numer=7;
   if ((ruch2>2)&&((p2==wybor2)&&(p6==wybor2)&&(p4==32))) numer=5;
   if ((ruch2>2)&&((p4==wybor2)&&(p6==wybor2)&&(p2==32))) numer=3;
}
if (kto2==2) wybor2=wybor12;
if (kto2==1) wybor2=wybor22; 

if (ruch2==4)
     {
   if (((p0==wybor2)&&(p4==wybor2)&&((p8=='X')||(p8=='O')))||((p4==wybor2)&&(p8==wybor2)&&((p0=='X')||(p0=='O')))||((p2==wybor2)&&(p4==wybor2)&&((p6=='X')||(p6=='O')))||((p6==wybor2)&&(p4==wybor2)&&((p2=='X')||(p2=='O'))))
    do
      {
       if (((rand()%9)==1)&&(p0==32))  numer=1;
       if (((rand()%9)==3)&&(p0==32))  numer=3;
       if (((rand()%9)==7)&&(p0==32))  numer=7;
       if (((rand()%9)==9)&&(p0==32))  numer=9;
      } while((numer==0)||((numer!=1)&&(numer!=3)&&(numer!=7)&&(numer!=9)));
     }


if(numer==0) 
{
        do
         {
        if (ruch2==10) break;
        if (((rand()%9)==0)&&(p0==32)) numer=1;
        if (((rand()%9)==1)&&(p1==32)) numer=2; 
        if (((rand()%9)==2)&&(p2==32)) numer=3; 
        if (((rand()%9)==3)&&(p3==32)) numer=4; 
        if (((rand()%9)==4)&&(p4==32)) numer=5;
        if (((rand()%9)==5)&&(p5==32)) numer=6; 
        if (((rand()%9)==6)&&(p6==32)) numer=7; 
        if (((rand()%9)==7)&&(p7==32)) numer=8; 
        if (((rand()%9)==8)&&(p8==32)) numer=9; 
        }while((numer==0)||((numer!=1)&&(numer!=2)&&(numer==3)&&(numer!=4)&&(numer!=5)&&(numer!=6)&&(numer&=7)&&(numer!=8)&&(numer!=9))); 
} 
     
                                                                       

if (ruch2==1) numer=0;                      
return numer;

}

int komputer2(char p0, char p1,char p2,char p3, char p4,char p5, char p6, char p7, char p8, int ruch2, int kto2, char wybor12, char wybor22)
{
  int zarodek, numer;
    zarodek= time(NULL);
    srand(zarodek); 
    numer=0;
 do
         {
        if (ruch2==11) break;
        if (((rand()%9)==0)&&(p0==32)) numer=1;
        if (((rand()%9)==1)&&(p1==32)) numer=2; 
        if (((rand()%9)==2)&&(p2==32)) numer=3; 
        if (((rand()%9)==3)&&(p3==32)) numer=4; 
        if (((rand()%9)==4)&&(p4==32)) numer=5;
        if (((rand()%9)==5)&&(p5==32)) numer=6; 
        if (((rand()%9)==6)&&(p6==32)) numer=7; 
        if (((rand()%9)==7)&&(p7==32)) numer=8; 
        if (((rand()%9)==8)&&(p8==32)) numer=9; 
        }while((numer==0)||((numer!=1)&&(numer!=2)&&(numer==3)&&(numer!=4)&&(numer!=5)&&(numer!=6)&&(numer&=7)&&(numer!=8)&&(numer!=9))); 
         
return numer;
}









