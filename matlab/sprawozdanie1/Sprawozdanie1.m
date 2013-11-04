WPC=4;                       %warunek pocz¹tkowy
R=10;                        %opór [Ohm]  
C=0.1;                       %pojemnoœæ [F]
K=-1/(R*C);                  %sta³a

open('model')                %otwiera model simulinku
sim('model')                 %uruchamia symulacjê

figure(1)                    %wykres 1
plot(tout,x);                %wykres U(t)
title('Symulacja obwodu RC (4,10,0.1)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napiêcie [V]')       %etykieta osi y
grid on                      %siatka

%------------------------------------------------

WPC=4;                       %warunek pocz¹tkowy
R=20;                        %opór [Ohm]  
C=0.1;                       %pojemnoœæ [F]
K=-1/(R*C);                  %sta³a

sim('model')                 %uruchamia symulacjê

figure(2)
plot(tout,x);  
title('Symulacja obwodu RC (4, 20, 0.1)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napiêcie [V]')       %etykieta osi y
grid on                      %siatka

%-----------------------------------------------
WPC=8;                       %warunek pocz¹tkowy
R=10;                        %opór [Ohm]  
C=0.5;                       %pojemnoœæ [F]
K=-1/(R*C);                  %sta³a

sim('model')                 %uruchamia symulacjê

figure(3)
plot(tout,x);  
title('Symulacja obwodu RC (8, 10, 0.5)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napiêcie [V]')       %etykieta osi y
grid on                      %siatka
%-----------------------------------------------
WPC=2;                       %warunek pocz¹tkowy
R=5;                        %opór [Ohm]  
C=0.1;                       %pojemnoœæ [F]
K=-1/(R*C);                  %sta³a

sim('model')                 %uruchamia symulacjê

figure(4)
plot(tout,x);  
title('Symulacja obwodu RC (2, 5, 0.1)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napiêcie [V]')       %etykieta osi y
grid on                      %siatka
%------------------------------------------------
WPC=10;                       %warunek pocz¹tkowy
R=10;                        %opór [Ohm]  
C=0.01;                       %pojemnoœæ [F]
K=-1/(R*C);                  %sta³a

sim('model')                 %uruchamia symulacjê

figure(5)
plot(tout,x);  
title('Symulacja obwodu RC (10, 10, 0.01)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napiêcie [V]')       %etykieta osi y
grid on                      %siatka
