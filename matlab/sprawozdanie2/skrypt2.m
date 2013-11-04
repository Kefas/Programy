clear;
P = eye(2); % macierz jednostkowa 2x2

% listaJ to macierz 18 x 2 ( 18 wierszy w 2 kolumnach ) zapisane s� tu
% poszczegolne macierze Jordana u�o�ene z warto�ci w�asnych odczytanych z
% rysunku 1.10 z konspektu

listaJ = [ 0 0;  %1 warto�c w�asna podw�jna = 0 liniowy dzielnik elementarny
           0 0;
           
           0 1;  %2)
           0 0;
           
           0 0;  %3)
           0 -1;
           
          -1 0;  %4
           0 -2;
           
          -1 0;  %5
           0 -1;
            
          -1 1;  %6
           0 -1;
             
           1 0;  %7
           0 -1;
            
           0 -1; %8
          1 0;
          
          -1 -1; %9
           1 -1;];

%lista naszych tytu��w do wykres�w
      captionList = {
    '\lambda1,2 = 0 - dzielnik liniowy'
    '\lambda1,2 = 0 - dzielnik nieliniowy'
    '\lambda1 = -1, \lambda2 = 0'
    '\lambda1 = -2, \lambda2 = -1'
    '\lambda1,2 = -1 - dzielnik liniowy'
    '\lambda1,2 = -1 - dzielnik nieliniowy'
    '\lambda1 = -1, \lambda2 = 1'
    '\lambda1,2 = 0 +/- 1i'
    '\lambda1,2 = -1 +/- 1i'
};

%size zwraca w wektor z rozmiarami [rows, cols]      
wektor = size(listaJ);

%wy�uskuj� ilo�c wierszy i dziel� przez 2 �eby uzyska� ilo�� macierzy J
%czyli 9
iloscJlist = wektor(1)/2;

%tworze macierz 2 x 121 ze stanami pocz�tkowymi
WPClista = [];
for i = -1:0.2:1,
    for j = -1:0.2:1,
    WPClista = [ WPClista [ i; j ] ];
    end
end


wektor2 = size(WPClista); % ileo�c wyliczonych WPC
ileWPC = wektor2(2);

open('konspekt2');

%petla dziala dla kazdej macierzy J czyli 9 razy
%z kazdym przebiegiem musimy wyznaczyn z macierz Jlist nasza macierz
%aktualna J, wyznaczyc A.
%potem zaczynamy rysowac figur�
%rysujemy tylko trajektorii ile jest stan�w pocz�tkowych czyli 121 na jednym
%wykresie, �eby narysowa� 121 osobnych trajektorii na jednym wykresie musimy
%u�y� funkcji hold on i hold off a wykres rysujemy dla ca�ego pierwszego
%wiersza warunk�w pocz�tkowych na ca�y drugi wiersz
for i = 0:iloscJlist-1
 J = [ listaJ(2*i + 1, 1) listaJ(2*i + 1, 2) ; % ustaw macierz J
         listaJ(2*i + 2, 1) listaJ(2*i + 2, 2) ];


A = P * J * P^-1;             % obliczenie A dla ka�dej J
figure(i+1);
hold on;                      %rysowanie kilku trajektorii na jednym rysunku
    for j = 1:ileWPC,
        
        WPC = WPClista(:, j); % ustaw wektor warunku pocz�tkowego
        sim('konspekt2');     % uruchom symulacj�
        x1 = x(:, 1);         % wybierz x1
        x2 = x(:, 2);         % wybierz x2
        plot(x1, x2);         % narysuj wykres
    end
    hold off;                 % koniec rysowania trajektorii
    
                              %dla pierwszego portretu siatki nie rysuje bo nie widac kropek
    if i~=0
        grid on;
    end
    xlabel('x1');             %opisy osi
    ylabel('x2');
    title(strcat('Portret fazowy systemu dynamicznego:', captionList(i+1))); % tytul
    xlim([-1 1]); % zakres: od -1 do 1
    ylim([-1 1]);
end