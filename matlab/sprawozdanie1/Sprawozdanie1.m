WPC=4;                       %warunek pocz�tkowy
R=10;                        %op�r [Ohm]  
C=0.1;                       %pojemno�� [F]
K=-1/(R*C);                  %sta�a

open('model')                %otwiera model simulinku
sim('model')                 %uruchamia symulacj�

figure(1)                    %wykres 1
plot(tout,x);                %wykres U(t)
title('Symulacja obwodu RC (4,10,0.1)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napi�cie [V]')       %etykieta osi y
grid on                      %siatka

%------------------------------------------------

WPC=4;                       %warunek pocz�tkowy
R=20;                        %op�r [Ohm]  
C=0.1;                       %pojemno�� [F]
K=-1/(R*C);                  %sta�a

sim('model')                 %uruchamia symulacj�

figure(2)
plot(tout,x);  
title('Symulacja obwodu RC (4, 20, 0.1)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napi�cie [V]')       %etykieta osi y
grid on                      %siatka

%-----------------------------------------------
WPC=8;                       %warunek pocz�tkowy
R=10;                        %op�r [Ohm]  
C=0.5;                       %pojemno�� [F]
K=-1/(R*C);                  %sta�a

sim('model')                 %uruchamia symulacj�

figure(3)
plot(tout,x);  
title('Symulacja obwodu RC (8, 10, 0.5)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napi�cie [V]')       %etykieta osi y
grid on                      %siatka
%-----------------------------------------------
WPC=2;                       %warunek pocz�tkowy
R=5;                        %op�r [Ohm]  
C=0.1;                       %pojemno�� [F]
K=-1/(R*C);                  %sta�a

sim('model')                 %uruchamia symulacj�

figure(4)
plot(tout,x);  
title('Symulacja obwodu RC (2, 5, 0.1)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napi�cie [V]')       %etykieta osi y
grid on                      %siatka
%------------------------------------------------
WPC=10;                       %warunek pocz�tkowy
R=10;                        %op�r [Ohm]  
C=0.01;                       %pojemno�� [F]
K=-1/(R*C);                  %sta�a

sim('model')                 %uruchamia symulacj�

figure(5)
plot(tout,x);  
title('Symulacja obwodu RC (10, 10, 0.01)') %nazwa wykresu
xlabel('Czas [s]')           %etykieta osi x
ylabel('Napi�cie [V]')       %etykieta osi y
grid on                      %siatka
