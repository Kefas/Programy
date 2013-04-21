#include <iostream>

using namespace std;

int factorial_it(int n);
int factorial_re(int n);

int main(void)
{
  int number;

  cout << "Program do liczenia silni metodą rekurencyjną i iteracyjną. Podaj liczbę : ";
  cin >> number;

  int product_it=factorial_it(number);
  int product_re=factorial_re(number);

  cout << "Silnia z " << number << " rekurencyjnie to: " << product_re << " a iteracyjnie to " << product_it <<endl;

  return 0;
}

int factorial_it(int n)
{
  int product=1;

  for(int i=1;i<=n;i++)
    product *= i;
  return product;
}

int factorial_re(int n)
{
int product = 1;
  if (n>1) 
    {
      product=n*factorial_re(n-1);
    }
  return product;
}
