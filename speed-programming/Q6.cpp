
#include<iostream>
#include<conio.h>

using namespace std;

#define MAX 100

int maximum(int *, int);
int minimum(int *, int);


int main() {

	int size = 5;
	cout << "Enter size of array: ";
	cin >> size;

	int nums[MAX];

	for (int i = 0; i < size; i++)
	{
		cout << "Enter number # " << i + 1 << " ? :  ";
		cin >> nums[i];

	}

	cout << "Maximum : " << maximum(nums, size)<<endl;


	cout << "Minimum : " << minimum(nums, size)<<endl;


	_getch();
}


int maximum(int * arr, int s) {

	int* temp = arr;
	int max = *arr;
	for (int i = 0; i < s; i++)
	{
		if (*temp > max) {
			max = *temp;
		}
		temp++;
	}

	return max;

}

int minimum(int * arr, int s) {

	int* temp = arr;
	int min = *arr;
	for (int i = 0; i < s; i++)
	{
		if (*temp < min) {
			min = *temp;
		}
		temp++;
	}

	return min;

}
