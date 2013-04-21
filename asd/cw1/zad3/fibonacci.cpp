#include <iostream>

using namespace std;

int fibonacci_re(int n);

int main(int argc, char * argv[])
{
  int n;

  cout << " Program do znajdowania n liczby ciągu Fibonacciego, ktora liczbe mam znaleźć? : ";
  cin >> n;

  cout << n << "-liczbą ciągu Fibonacciego jest: " << fibonacci_re(n) << endl;

  return 0;
}

int fibonacci_re(int n)
{
  int product=0;
  if (n==0) return 0;
  if (n==1) return 1;
  if (n>1)
    {
      product = fibonacci_re(n-1) + fibonacci_re(n-2);
    }

  return product;
}
