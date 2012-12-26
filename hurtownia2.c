#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define x 7
#define y 7

/*Funkcja przepisz_miejscowosci przepisuje główne i pobocnze miasta do osobnych list, każde głowne miasto ma wskaźnik do pierwszego i ostatniego miasta pobocznego */



struct glowne
{
  char *miasto_g;
  struct glowne *next_m;
  struct poboczne *myhead;
  struct poboczne *mytail;
};

struct poboczne
{
  char *miasto_p;
  int odleglosc;
  struct poboczne *next_p;
};

struct head
{
  struct glowne *glowne_head;
  struct poboczne *poboczne_head;
  struct artykuly *artykuly_head;
  struct hurtownie *hurtownie_head;
  struct stan *stan_head;
  struct zlecenia *zlecenia_head;
};

struct artykuly
{
  long int id;
  char *artykul;
  struct artykuly *next_a;
};

struct hurtownie
{
 char *hurtownia;
 struct stan *myhead_art;
 struct stan *mytail_art;
 struct hurtownie *next_h;
 };

struct stan
{
  long int id_s;
  int ilosc;
  float cena;
  int dzien, miesiac, rok;
  struct stan *next_s;
};

struct zlecenia
{
  char *przeznaczenie;
  int nr_zamowienia_z,ilosc_z;
  int dzien_z, miesiac_z, rok_z;
  long int id_z;
  struct zlecenia *next_z;
};


typedef struct glowne struktura1;
typedef struct poboczne struktura2;
typedef struct head struktura3;
typedef struct artykuly struktura4;
typedef struct hurtownie struktura5;
typedef struct stan struktura6;
typedef struct zlecenia struktura7;

struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci);

struktura3 przepisz_artykuly(struktura4 *head_a, struktura3 head, FILE *artykuly);

struktura3 przepisz_hurtownie(struktura5 *head_h, struktura6 *head_s, struktura3 head,  FILE *hurtownie);

struktura3 przepisz_zlecenia(struktura7 *head_z, struktura3 head, FILE *zlecenia);

void uwolnij(struktura3 head);

/*Wskaźniki do pierwszych elementów listy glownych miast i pobocznych miast są przechowywane w typedef struct head struktura3 */
  

int main(void)
{
  struktura1 *head_g=NULL;
  struktura2 *head_p=NULL;
  struktura3 head;
  struktura4 *head_a=NULL;
  struktura5 *head_h=NULL;
  struktura6 *head_s=NULL;
  struktura7 *head_z=NULL;
  FILE *miejscowosci,*artykuly,*hurtownie,*zlecenia;

  miejscowosci = fopen("miejscowosci_v2.dat","r");
  artykuly = fopen("artykuly.dat","r");
  hurtownie = fopen("hurtownie.dat","r");
  zlecenia = fopen("zlecenie.dat","r");
  if(miejscowosci==NULL)
    {
      perror("miejscowosci_v2.dat");
      return 1;
    }
  if(artykuly==NULL)
    {
      perror("artykuly.dat");
      return 1;
    }
  if(hurtownie==NULL)
    {
      perror("hurtownie.dat");
      return 1;
    }
  if(zlecenia==NULL)
    {
      perror("zlecenie.dat");
    }

  /*usunalem head.glowne_head=NULL*/
  head=przepisz_miejscowosci(head_g, head_p, head, miejscowosci);
  head=przepisz_artykuly(head_a, head, artykuly);
  head=przepisz_hurtownie(head_h, head_s, head, hurtownie);
  head=przepisz_zlecenia(head_z, head, zlecenia);

  /*
  printf("Główne miasto %s",head.glowne_head->miasto_g);
  printf("Główna hurtownia %s", head.hurtownie_head->hurtownia);
  */

  /*----------------INTERFACE--------------------*/
  printf("Witaj w programie wspomagającym obsługę hurtowni\n");
  printf("Zaktualizowane dane po realizacji zleceń znajdują się w pliku hurtownie_stan1.dat\n Nazwy artykułów, dla których przewidywany termin przydatności jest krótszy niż %d dni znajduje się w pliku przeterminowane.dat\n Nazwy artykułów, dla których przewidywanytermin wyczerpania zapasu jest krótszy niż %d dni znajduję się w pliku koncowki.dat\n Plik zawierający dane o sposobie i koszcie realizacji zamówień znajduje się w pliku realizacja_zlecen.dat\n",x,y); 

  uwolnij(head);
  fclose(miejscowosci);
  fclose(artykuly);
  fclose(hurtownie);
  printf("Do widzenia\n");
  return 0;
}

struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci)
{
  int i=0;/* i jest mi potrzebne do ustalania myheada dla pierwszego */
  char temp[255],buff[255],*result;
  struktura1 *current_g, *previous_g;
  struktura2 *current_p, *previous_p;
  head_g=NULL;  

  rewind(miejscowosci); /*profilaktyki nigdy za duzo*/
  current_g=(struktura1 *)malloc(sizeof(struktura1));
  current_p=(struktura2 *)malloc(sizeof(struktura2));
  
  /* head_g=current_g;*/
  while(result!=NULL) /*może EOF? */
    { 
          result = fgets(temp,100,miejscowosci);
      
	  if((temp[0]<=90 && temp[0]>=65) || (temp[0]<=122 && temp[0]>=97))
	    {
	     if(head_g==NULL)
	       {
		 head_g=current_g;
		 /*head do "najpierwszego" ↓ */
		 current_g->myhead=current_p;
		 i=0;
               }
	     else
	       {		 	 
                 current_g=(struktura1 *)malloc(sizeof(struktura1));
		 previous_g->next_m=current_g;                  
	       }
	     current_g->next_m=NULL;
	     /*instrukcje*/
	     current_g->miasto_g=(char*)malloc(sizeof(char)*strlen(temp)+1);
	     strcpy(current_g->miasto_g,temp);

	     previous_g=current_g;         
             i=1;	        	    
	    }
	  else
	    {
	     if(head_p==NULL)
	       {
		 head_p=current_p;
		 i=0;
	       }
	     else
	       {
                 current_p=(struktura2 *)malloc(sizeof(struktura2));	
	         previous_p->next_p=current_p;
		 if(i==1)
		   {
		     current_g->myhead=current_p;
		     i=0;
		   }
               }    
	     current_p->next_p=NULL;
	     /*instrukcje*/
	     /*%[A-Za-z ] wczytuje tylko te określone znaki i spacje dzięki temu moge pobrac 2 słowa jako jeden string*/
	     sscanf(temp, "%d %[A-Za-z ] \n",&current_p->odleglosc,buff);
	     current_p->miasto_p=(char*)malloc(sizeof(char)*strlen(buff)+1);
	     strcpy(current_p->miasto_p,buff);
	     
             /*koniec pobocznych od głównego to ↓ */
             current_g->mytail=current_p;
	     previous_p=current_p;
	    }
   
    }
  /*  current_p=head_p;
  current_g=head_g;
  
  while(current_g!=NULL)
    {
      printf("%s",head_p->miasto_p);
      printf("Myhead: %s, %d\n",current_g->myhead->miasto_p,current_g->myhead->odleglosc);
      printf("Mytail: %s  %d\n",current_g->mytail->miasto_p,current_g->mytail->odleglosc);
 current_p=current_g->myhead;
       
      
      do
	{
	  printf("-%s - %d\n",current_p->miasto_p, current_p->odleglosc);
	  current_p=current_p->next_p;
	}while(current_p!=current_g->mytail);
      
      current_g=current_g->next_m;
      }*/
  head.glowne_head=head_g;
  head.poboczne_head=head_p;
    
return head;
}

struktura3 przepisz_artykuly(struktura4 *head_a, struktura3 head, FILE *artykuly)
{
  struktura4 *current_a,*previous_a;
  char temp[255],buff[255], *result;

  /* to pewnie mogę dać do funkcji */
  current_a=(struktura4 *)malloc(sizeof(struktura4));
  rewind(artykuly);
  
  while(result!=NULL)
    {
      result=fgets(temp,100,artykuly);

      if(head_a==NULL)
	{
	  head_a=current_a;
	}
      else
	{
	  current_a=(struktura4 *)malloc(sizeof(struktura4));
	  previous_a->next_a=current_a;
	}
      current_a->next_a=NULL; 
      sscanf(temp, "%ld %[a-zA-Z0-9\\ /,.)(- ]\n",&current_a->id,buff);      
      current_a->artykul=(char *)malloc(sizeof(char)*strlen(buff)+1);
      strcpy(current_a->artykul,buff);
     
      previous_a=current_a;
    }
  head.artykuly_head=head_a;

  return head;
}

struktura3 przepisz_hurtownie(struktura5 *head_h,struktura6 *head_s, struktura3 head,  FILE *hurtownie)
{
  int i=0;
  struktura5 *previous_h, *current_h;
  struktura6 *previous_s, *current_s;
  char temp[255],*result;

  current_h=(struktura5 *)malloc(sizeof(struktura5));
  current_s=(struktura6 *)malloc(sizeof(struktura6));
  while(result!=NULL)
    {
      result = fgets(temp,100,hurtownie);
      if((temp[0]>=65 && temp[0]<=90) || (temp[0]>=97 && temp[0]<=122))
	{
	  if(head_h==NULL)
	    {
	      head_h=current_h;
	      head_h->myhead_art=current_s; /*head dla pierwszego */
	      i=0;
	    }
	  else
	    {
	      current_h=(struktura5 *)malloc(sizeof(struktura5));
	      previous_h->next_h=current_h;

	    }
	  current_h->next_h=NULL;

	  current_h->hurtownia=(char*)malloc(sizeof(char)*strlen(temp)+1);
	  strcpy(current_h->hurtownia,temp);

	  previous_h=current_h;
	  i=1;
	}
      else
	{
	  if(head_s==NULL)
	    {
	      head_s=current_s;
	      i=0;
	    }
	  else
	    {
	      
	      current_s=(struktura6*)malloc(sizeof(struktura6));
	      previous_s->next_s=current_s;
	      if(i==1)/*my head dla każdego z wyjątkiem pierwszego */
		{		
		  current_h->myhead_art=current_s;
		  i=0;
		}   
             }

	  current_s->next_s=NULL;
	  
	  sscanf(temp, "%ld %d %f %d %d %d\n",&current_s->id_s, &current_s->ilosc, &current_s->cena, &current_s->dzien, &current_s->miesiac, &current_s->rok);

          current_h->mytail_art=current_s; /*tail dla każdego*/
	  
          previous_s=current_s;

	}
    }
    
      head.hurtownie_head=head_h;
      head.stan_head=head_s;

      current_h=head_h;
      current_s=head_s;

      do
      {
	printf("Główna hurt: %s",current_h->hurtownia);
	current_s=current_h->myhead_art;


	printf("MH %ld\n",current_h->myhead_art->id_s);
	printf("MT %ld\n",current_h->mytail_art->id_s);
	/*do
	  {
	    printf(" ID %ld Ilosc %d Cena %f Dzien %d Miesiac %d Rok %d\n",current_s->id_s,current_s->ilosc, current_s->cena, current_s->dzien, current_s->miesiac, current_s->rok);
	    current_s=current_s->next_s;
	    }while(current_s!=current_h->mytail_art);*/
	current_h=current_h->next_h;
      }while(current_h!=NULL);
 
  return head;
}

void uwolnij(struktura3 head)
{
struktura1 *previous_g, *current_g;
struktura2 *previous_p, *current_p;
struktura4 *previous_a, *current_a;
struktura5 *previous_h, *current_h;
struktura6 *previous_s, *current_s;
struktura7 *previous_z, *current_z;

 current_g=head.glowne_head;
 current_p=head.poboczne_head;
 current_a=head.artykuly_head;
 current_h=head.hurtownie_head;
 current_s=head.stan_head;
 current_z=head.zlecenia_head;

while(current_g!=NULL)
  {
    previous_g=current_g;
    current_g=current_g->next_m;
    free(previous_g);
  }
while(current_p!=NULL)
  {
    previous_p=current_p;
    current_p=current_p->next_p;
    free(previous_p);
  }
while(current_a!=NULL)
  {
    previous_a=current_a;
    current_a=current_a->next_a;
    free(previous_a);
  }
while(current_h!=NULL)
  {
    previous_h=current_h;
    current_h=current_h->next_h;
    free(previous_h);
  }
while(current_s!=NULL)
  {
    previous_s=current_s;
    current_s=current_s->next_s;
    free(previous_s);
  }
 while(current_z!=NULL)
   {
     previous_z=current_z;
     current_z=current_z->next_z;
     free(previous_z);
   }
}

struktura3 przepisz_zlecenia(struktura7 *head_z, struktura3 head, FILE *zlecenia)
{
  int i=0;
  struktura7 *previous_z, *current_z;
  struktura4 *current_a;
  char temp[255],buff[255], *result;
  rewind(zlecenia);
  current_z=(struktura7 *)malloc(sizeof(struktura7));

  do
    {
      result = fgets(temp,100,zlecenia);
      if((temp[2]>='0' && temp[2]<='9')||(temp[4]>='0' && temp[4]<='9')||(temp[3]>='0' && temp[3]<='9'))
	{
	  if(head_z==NULL)
	    {
	      head_z=current_z;
	    }
	  else
	    {
	      current_z=(struktura7*)malloc(sizeof(struktura7));
	      previous_z->next_z=current_z;
	    }
	  current_z->next_z=NULL;
	  
	  sscanf(temp,"%d %d %d %d %[A-Za-z ]\n",&current_z->dzien_z,&current_z->miesiac_z,&current_z->rok_z,&current_z->nr_zamowienia_z,buff);
	  current_z->przeznaczenie=(char*)malloc(sizeof(char)*strlen(buff)+1);
	  strcpy(current_z->przeznaczenie,buff);

	  previous_z=current_z;
	  i=1;
          printf("say what again\n");
	}
        else
	{
	  if(i==0)
	  {
	    current_z=(struktura7*)malloc(sizeof(struktura7));
	    previous_z->next_z=current_z;
	    current_z->next_z=NULL;
	    /*przepisanie poprzednich informacji*/
	    current_z->dzien_z=previous_z->dzien_z;
	    current_z->miesiac_z=previous_z->dzien_z;
	    current_z->rok_z=previous_z->rok_z;
	    current_z->nr_zamowienia_z=previous_z->nr_zamowienia_z;
	    current_z->przeznaczenie=(char*)malloc(sizeof(char)*strlen(previous_z->przeznaczenie));
	    strcpy(current_z->przeznaczenie,previous_z->przeznaczenie);
	    /*teraz wpisuje nowe*/
	  }
	    sscanf(temp,"%d %[A-Za-z //\\-.,0-9]\n",&current_z->ilosc_z, buff);
	    /*szukanie ID zamowienia od razu*/ 
	    current_a=head.artykuly_head;
	    while(current_a!=NULL)
	      {
		if(strcmp(buff,current_a->artykul)==0)
                current_z->id_z=current_a->id;
        	 current_a=current_a->next_a;
	      }
	    printf("%ld, %s\n",current_z->id_z,buff);
	    if(i==1)	    
	    i=0;
	    previous_z=current_z;
	    /*TO DO: można dać waruna gdy nie znajdzie artykułu takiego*/ 	    	  
	} 
    
    }while(result!=NULL);

  head.zlecenia_head=head_z;
  return head;
}
