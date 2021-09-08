#include<iostream>
#include<conio.h>

using namespace std;

void passByValue(int);
void passByReference(int *);

int main() {

	int num = 67;
	cout << "Before calling passByValue \"num\" is: " << num<<endl;
	passByValue(num);
	cout << "After calling passByValue \"num\" is: "<<num<<endl<<endl<<endl;
	
	cout << "Before calling passByReference \"num\" is: " << num<<endl;
	passByReference(&num);
	cout << "After calling passByReference \"num\" is: " << num<<endl;


	_getch();
}


void passByValue(int num) {
	cout << "Inside \"passByValue\" value of \"num\" is : " << num<<endl;
	num = num * 2;
	cout << "Now value of num : " << num<<endl;

}


void passByReference(int *num) {
	cout << "Inside \"passByReference\" value of \"num\" is : " << *num<<endl;
	(*num) = (*num) * 2;
	cout << "Now value of num : " << *num<<endl;

}