#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>

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
  struct przystanki *przystanki_head;
  struct kolejnosc *kolejnosc_head;
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

struct przystanki
{
  char **przystanki;
  int numer;
};

struct data
{
  int dzien, miesiac,rok;
};

struct wybor
{
  long int id;
  int nr,dzien, miesiac, rok;
};
struct kolejnosc
{
  char *miasto;
  int odleglosc;
};

typedef struct glowne struktura1;
typedef struct poboczne struktura2;
typedef struct head struktura3;
typedef struct artykuly struktura4;
typedef struct hurtownie struktura5;
typedef struct stan struktura6;
typedef struct zlecenia struktura7;
typedef struct przystanki struktura8;
typedef struct data struktura9;
typedef struct wybor struktura10;
typedef struct kolejnosc struktura11;
struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci);

struktura3 przepisz_artykuly(struktura4 *head_a, struktura3 head, FILE *artykuly);

struktura3 przepisz_hurtownie(struktura5 *head_h, struktura6 *head_s, struktura3 head,  FILE *hurtownie);

struktura3 przepisz_zlecenia(struktura7 *head_z, struktura3 head, FILE *zlecenia);

char *wpisz_przystanki(struktura8 *head_prz, struktura3 head, char *temp, struktura7 *current_z,struktura9 data);

char *wybierz_najstarszy(struktura10 *wybor,int i,char **tab);

struktura11 *rekurencja(struktura11 *kolejnosc,char *miasto_docelowe, char* miasto_aktualne, struktura3 head,char **odwiedzone,int odleglosc,int liczba_miast,int j, int p);

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
  struktura7 *head_z=NULL,*current_z;
  struktura8 *head_prz=NULL;
  struktura9 data;
  struktura11 *kolejnosc,temp2;
  FILE *miejscowosci,*artykuly,*hurtownie,*zlecenia;
  char *temp,*element,*miasto_docelowe,*miasto_aktualne,**przystanki,**odwiedzone;
  int j,i=0,z,p,odleglosc=0,liczba_miast=0;

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

  /*policzmy ile mamy miast głownych*/
    head_g=head.glowne_head;
  while(head_g!=NULL)
    {
      liczba_miast++;
      head_g=head_g->next_m;
    }
  

  /*
  printf("Główne miasto %s",head.glowne_head->miasto_g);
  printf("Główna hurtownia %s", head.hurtownie_head->hurtownia);
  */

  /*----------------INTERFACE--------------------*/
  printf("Witaj w programie wspomagającym obsługę hurtowni\n");
  printf("Zaktualizowane dane po realizacji zleceń znajdują się w pliku hurtownie_stan1.dat\n Nazwy artykułów, dla których przewidywany termin przydatności jest krótszy niż %d dni znajduje się w pliku przeterminowane.dat\n Nazwy artykułów, dla których przewidywanytermin wyczerpania zapasu jest krótszy niż %d dni znajduję się w pliku koncowki.dat\n Plik zawierający dane o sposobie i koszcie realizacji zamówień znajduje się w pliku realizacja_zlecen.dat\n",x,y);

  /*--------------Realizacja------------*/
  current_z=head.zlecenia_head;

  while(current_z!=NULL)
    {
      i=0;
      przystanki=(char**)malloc(sizeof(char*));
      temp=(char*)malloc(sizeof(char)*strlen(current_z->przeznaczenie));
      strcpy(temp,current_z->przeznaczenie);
      przystanki[i]=(char*)malloc(sizeof(char)*strlen(current_z->przeznaczenie));
      strcpy(przystanki[i],current_z->przeznaczenie);
      i=1;
      while(strcmp(current_z->przeznaczenie,temp)==0 && current_z!=NULL)
	{
	  /*przepisuję date zamówienia*/
	  data.dzien=current_z->dzien_z;
	  data.miesiac=current_z->miesiac_z;
	  data.rok=current_z->rok_z;

          printf("%s=%s\n",current_z->przeznaczenie,temp);
	  /*tu cała akcja z szukaniem hurtowni i robieniem tabela*/
	  element=wpisz_przystanki(head_prz,head,temp,current_z,data);
	  /*zwraca kolejny element tabeli*/
	  przystanki=realloc(przystanki,sizeof(char**)*(i+1));
	  przystanki[i]=(char*)malloc(sizeof(char)*strlen(element));
	  strcpy(przystanki[i],element);
  	  
	  current_z=current_z->next_z;
	  i++;
	  if(current_z!=NULL && current_z->next_z!=NULL)
	    {
	  if (current_z->id_z==current_z->next_z->id_z && strcmp(current_z->przeznaczenie,current_z->next_z->przeznaczenie)==0) break;
	    }
	  if (current_z==NULL) break; /* czemu nie dziala ten warun w while?*/
	}
    
      /* tab przeznaczenie-hurt-przeznaczenie
      przystanki=realloc(przystanki,sizeof(char**)*(i+1));
      przystanki[i]=(char*)malloc(sizeof(char)*strlen(przystanki[0]));
      strcpy(przystanki[i],przystanki[0]);*/      
      /*----sprawdzenie------*/
      
      /*przepisanie przystankow do tablicy struktur o wielkosc j*/
      kolejnosc=(struktura11*)malloc(sizeof(struktura11)*i);
      
      for(j=0;j<=i-1;j++)
	{
	  printf("\nPrzystanek%d %s",j,przystanki[j]);
	  kolejnosc[j].miasto=(char*)malloc(sizeof(char)*strlen(przystanki[j])+1);
	  strcpy(kolejnosc[j].miasto,przystanki[j]);
	  kolejnosc[j].odleglosc=0;
	  
	}
      /*----rekurencja---*/

      /*teraz od najmniejszego indeksu zaczynamy przegladac tablice struktur*/ 
      for(j=0;j<=i-1;j++)
	{
        /*--tabela miast odwiedzonych w rekurencji--*/
        odwiedzone=(char**)malloc(sizeof(char*)*liczba_miast);
 /*przejrzyjmy cala tablice w poszukiwaniu takich samych miast jak miasto przeznaczenia i ustawmy je zaraz za miastem przeznaczenia oraz zwiększmy indeks do ostatniego posortowanego,uzupełnić odleglosci miedzy tymi samymi zerami*/
	  for(p=(j+1);p<=i-1;p++)
	    {
	      /*usuniecie zbednej rekurencji*/
	      if(kolejnosc[j].miasto[0]==kolejnosc[p].miasto[0] && kolejnosc[j].miasto[1]==kolejnosc[p].miasto[1] && kolejnosc[j].miasto[2]==kolejnosc[p].miasto[2] && kolejnosc[j].miasto[3]==kolejnosc[p].miasto[3]) /*do not ask why? till it's working it's ok*/
		{
		  temp2=kolejnosc[j+1];
		  kolejnosc[j+1]=kolejnosc[p];
		  kolejnosc[p]=temp2;

		  printf("tarcza szmato \n");
		 
		}
	      else /*rekurencja*/
		{
		  printf("dupa %d %d\n",j,p);
		  miasto_docelowe=(char*)malloc(sizeof(char)*strlen(kolejnosc[j].miasto));
		  miasto_aktualne=(char*)malloc(sizeof(char)*strlen(kolejnosc[p].miasto));

		  strcpy(miasto_docelowe,kolejnosc[j].miasto);
		  strcpy(miasto_aktualne,kolejnosc[p].miasto);
		  kolejnosc=rekurencja(kolejnosc,miasto_docelowe,miasto_aktualne,head,odwiedzone,odleglosc,liczba_miast,j,p);/* trzeba po ustaleniu jednego połaczenia wykasować tablicę odwiedzonych i ustawić odleglosc na 0*/


		}
	    }
	}
        
        for(z=0;z<=i-1;z++)
        {
          printf("OOO %d %s\n",z,kolejnosc[z].miasto);
	  printf("EEE %s\n",odwiedzone[z]);
        }
	free(odwiedzone);
	 
   
      
	      
    }
  uwolnij(head);
  fclose(miejscowosci);
  fclose(artykuly);
  fclose(hurtownie);
  printf("Do widzenia\n");
  return 0;
}

struktura11 *rekurencja(struktura11 *kolejnosc,char *miasto_docelowe,char *miasto_aktualne, struktura3 head,char **odwiedzone,int odleglosc,int liczba_miast,int j, int p)
{
  struktura1 *current_g;
  struktura2 *current_p;
  int i=0,flaga;

  flaga=0;

  if(miasto_docelowe[0]==miasto_aktualne[0] && miasto_docelowe[1]==miasto_aktualne[1] && miasto_docelowe[2]==miasto_aktualne[2] && miasto_docelowe[3]==miasto_aktualne[3])
    {
      printf("takie same\n");
    }
  else
    {
        i=0;
	while(odwiedzone[i]!=NULL && i<=liczba_miast-1)/*rozpatruje tylko zapisane komorki*/
	  {
	    if((odwiedzone[i][0]==miasto_aktualne[0] && odwiedzone[i][1]==miasto_aktualne[1] && odwiedzone[i][2]==miasto_aktualne[2] && odwiedzone[i][3]==miasto_aktualne[3]) || (strcmp(odwiedzone[i],miasto_aktualne)==0))
	    {
	      printf("Tu już byłem %s\n",miasto_aktualne);
	      flaga=1;
	    }
	  i++;
	  }

      if(flaga==0)
	{
	  odwiedzone[i]=(char*)malloc(sizeof(char)*strlen(miasto_aktualne));
	  strcpy(odwiedzone[i],miasto_aktualne);
	  printf("rekurencja szmato %d\n",i);
	  current_g=head.glowne_head;
	  while(current_g!=NULL)
	    {
	      if(strcmp(current_g->miasto_g,miasto_aktualne)==0)
		{		
		  break;
		}
	      current_g=current_g->next_m;
	    }
	  current_p=current_g->myhead;
	  printf("dafuq %s %s\n",current_g->miasto_g,current_g->myhead->miasto_p);
	  while(current_p!=current_g->mytail) /*kiedy zmieniam miasto aktualne, wykrzacza się.*/
	    {
	      /*free(miasto_aktualne);
	      miasto_aktualne=(char*)malloc(sizeof(char)*strlen(current_p->miasto_p));
	      strcpy(miasto_aktualne,current_p->miasto_p);
	      /*miasto_aktualne=(char*)malloc(sizeof(char)*strlen(current_p->miasto_p));
		strcpy(miasto_aktualne,current_p->miasto_p);*/
	      printf(" current p %s,miasto_aktualne %s\n",current_p->miasto_p,miasto_aktualne);

	      
              kolejnosc=rekurencja(kolejnosc,miasto_docelowe,miasto_aktualne,head,odwiedzone,odleglosc,liczba_miast,j,p);
	      current_p=current_p->next_p;
	    }
	}

    }
  i=0;
  while(odwiedzone[i]!=NULL && i<=liczba_miast-1)
    {
      printf("ODWIEDZONE:%d %s",i,odwiedzone[i]);
      i++;
    }
  
  return kolejnosc;
}


/* Tworzę listę głownych miejscowosci i pobocznych miejscowosci. Są połączone w ten sposób że każde główne miasto ma wskaźnik myhead na pierwsze miasto poboczne swoje i ma wskaźnik mytail na pierwsze miasto poboczne z następnego, oczywiście poza ostatnim którego mytail to ostatnie miasto listy pobocznych*/

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
  while(result!=NULL)
    { 
          result = fgets(temp,100,miejscowosci);
      
	  if(isalpha(temp[0]))
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
		     /*head dla każdego*/
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
	     
             /*koniec pobocznych od głównego to ↓*/ 
	     current_g->mytail=current_p;
	     previous_p=current_p;
        
	    }   
    }
    
  current_p=head_p;
  current_g=head_g;
  
  /*Tutaj ustawiam mytaile z wszystkich opróczostatniego na myheady następnych*/
  while(current_g->next_m!=NULL)
    {
      current_g->mytail=current_g->next_m->myhead;
      current_g=current_g->next_m;
    }

  current_g=head_g;
  while(current_g!=NULL)
    {
      /*    printf("%s\n",current_g->miasto_g);
      printf("Myhead: %s, %d\n",current_g->myhead->miasto_p,current_g->myhead->odleglosc);
      printf("Mytail: %s  %d\n",current_g->mytail->miasto_p,current_g->mytail->odleglosc);*/

      printf("%s\n",current_g->miasto_g);
 current_p=current_g->myhead;
      
 
        while(current_p!=current_g->mytail && current_p!=NULL)
	{
	  printf("-%s - %d\n",current_p->miasto_p, current_p->odleglosc);
	  current_p=current_p->next_p;
	  }
      
      current_g=current_g->next_m;
    }
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
      if(isalpha(temp[0]))
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
      /*Tail dla wszystkich oprócz ostatniego ustawione na myhead next*/
      while(current_h->next_h!=NULL)
       {
         current_h->mytail_art=current_h->next_h->myhead_art;
         current_h=current_h->next_h;
       }
      current_h=head_h;
      do
      {
	printf("Główna hurt: %s",current_h->hurtownia);
	current_s=current_h->myhead_art;

	/*
	printf("MH %ld\n",current_h->myhead_art->id_s);
	printf("MT %ld\n",current_h->mytail_art->id_s);
	*/while(current_s!=current_h->mytail_art)
	  {
	    printf(" ID %ld Ilosc %d Cena %f Dzien %d Miesiac %d Rok %d\n",current_s->id_s,current_s->ilosc, current_s->cena, current_s->dzien, current_s->miesiac, current_s->rok);
	    current_s=current_s->next_s;
	    }
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

  while(result!=NULL)/* Przedtem tu było do a to było na końcu */
    {
      result = fgets(temp,100,zlecenia);
      if(isdigit(temp[2])||isdigit(temp[3])||isdigit(temp[4]))
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
          
    }
  current_z=head_z;
  while(current_z->next_z!=NULL)
    {
      if(current_z->id_z==current_z->next_z->id_z && strcmp(current_z->przeznaczenie,current_z->next_z->przeznaczenie)==0)
	{
	  current_z->next_z=NULL;
	  break;
	}
      current_z=current_z->next_z;
    }
  
  /*Musiałem usunąć ten bug z poprzedniej pętli który dodawał dwa zlecenia na ostatnim miejscu*/
  current_z=head_z;
  while(current_z!=NULL)
    {
      printf("%ld\n", current_z->id_z);

      current_z=current_z->next_z;
    }

  head.zlecenia_head=head_z;
  return head;
}

char *wpisz_przystanki(struktura8 *head_prz,struktura3 head, char *temp, struktura7 *current_z, struktura9 data)
{
  /*znajdz takie hurtownie w których jest dany produkt*/
  struktura5 *current_h;
  struktura6 *current_s;
  struktura10 *wybor;
  int i=0,j;
  char *buff,**tab;
  wybor=(struktura10*)malloc(sizeof(struktura10));
  tab=(char**)malloc(sizeof(char*));
  current_h=head.hurtownie_head;
  while(current_h!=NULL)
    {
      
      current_s=current_h->myhead_art;
      while(current_s!=current_h->mytail_art)
	{
	 if(current_z->id_z==current_s->id_s)
	   if(current_z->ilosc_z<=current_s->ilosc)
	     if(current_s->rok > data.rok || (current_s->rok == data.rok && current_s->miesiac > data.miesiac) || (current_s->rok == data.rok && current_s->miesiac == data.miesiac && current_s->dzien >= data.dzien))
      	       { 
printf(" Id produktu %ld, Hurtownia %s",current_s->id_s, current_h->hurtownia);
       		 if(i==0)
		   {
		      
		     *(tab+i)=(char*)malloc(sizeof(char)*strlen(current_h->hurtownia)+1);
		      strcpy(tab[i],current_h->hurtownia);
                   }
		 else
		   {
		     tab=realloc(tab,sizeof(char**));
		     *(tab+i)=(char*)malloc(sizeof(char)*strlen(current_h->hurtownia));
		     strcpy(tab[i],current_h->hurtownia);
		     wybor=realloc(wybor,sizeof(struktura10)*(i+1));
                   
		   }
		 wybor[i].id=current_s->id_s;
		 wybor[i].dzien=current_s->dzien;
		 wybor[i].miesiac=current_s->miesiac;
		 wybor[i].rok=current_s->rok;
		 wybor[i].nr=i;	    
		   

		 i++;

	       }
	          
	 current_s=current_s->next_s;
        }
      current_h=current_h->next_h;
    }
  for(j=0;j<=i-1;j++)
    printf("tab[j]=%s",tab[j]);

  buff=wybierz_najstarszy(wybor,i,tab);
  free(tab);
  free(wybor);

  
    
  return buff;
}

char *wybierz_najstarszy(struktura10 *wybor,int i,char **tab)
{
  
  int j,rok=2014,miesiac=13,dzien=32,z;
  for(j=0;j<=i-1;j++)
    {
      printf("what? =%d.%d.%d\n", wybor[j].rok,wybor[j].miesiac,wybor[j].dzien);
       if(wybor[j].rok <= rok && wybor[j].miesiac <= miesiac && wybor[j].dzien <= dzien)
	{
	  rok=wybor[j].rok;
	  miesiac=wybor[j].miesiac;
	  dzien=wybor[j].dzien;
	  z=j;
	}
    }
  printf("rok %d mies %d dzien %d, nr %d",rok,miesiac,dzien,z);
  
  
  return tab[z];
}



/* 
1. Mamy tablice miejsc przez ktore trzeba przejechac 2. Mamy tablice
miejsc przez ktore kolejno przejezdzamy 3. Rozpatrzyć trzeba każdą
możliwą kombinację, że z każdego miasta oprócz tego co jest
uporzadkowane. Szukam polaczen w miastach pobocznych ktore szukaja w
swoich pobocznych ktore szukaja w swoich pobocznych az do momentu
kiedy znajda miasto. warunkiem jest ze nie mozna odwiedzic jednego
miasta dwa razy. Kiedy znajdziemy miasto zapisujemy odleglosc i nazwe
miasta w strukturze, jeżeli kolejne szukanie da lepszy rezultat
struktura jest zamieniana.x */

