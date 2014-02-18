.nolist
.include "m8def.inc"
.list

.cseg
.org 0

cli                        ;wyłączenie przerwań 
ldi R16, HIGH(RAMEND)    ;zaimpelementowanie stosu 
out SPH, R16 
ldi R16, HIGH(RAMEND) 
out SPL, R16 

ldi R16, 0x01
out DDRB, R16
out PORTB, R16

sbi DDRB,1

sbi TCCR0, 0

cbi PORTB, 0
ldi R16, 125
out TCNT0, R16
main:
   nop
   rjmp main



