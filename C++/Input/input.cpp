#include <iostream>
#include <string>
using namespace std;

int main() {
  string input;
  cout << "Type a number: ";
  getline(cin, input);
  int x = stoi(input);
  cout << "Your number is: " << x<<"\n";
  return 0;
}
