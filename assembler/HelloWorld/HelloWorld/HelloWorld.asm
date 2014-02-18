/*
 * HelloWorld.asm
 *
 *  Created: 2014-02-13 18:51:34
 *   Author: piotr
 */ 
 .nolist
 .include "m8def.inc"
 .list

 .cseg
 .org 0

 sbi DDRB, 0
 sbi PORTB, 0

