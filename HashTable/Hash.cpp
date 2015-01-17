// Double Hashing
//

#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#define MIN_TABLE_SIZE 10


using namespace std;
/*
* Node Type Declaration
*/
enum EntryType { Legitimate, Empty, Deleted };
/*
* Node Declaration
*/
struct HashNode
{
	int element;
	enum EntryType info;
};
/*
* Table Declaration
*/
struct HashTable
{
	int size;
	HashNode *table;
};
/*
* Function to Genereate First Hash
*/
int HashFunc1(int key, int size)
{
	return key % size;
}
/*
* Function to Genereate Second Hash
*/
int HashFunc2(int key, int size)
{
	return (11 - (key % 11));
}
/*
* Function to Initialize Table
*/
HashTable *initializeTable(int size)
{
	HashTable *htable;
	if (size < MIN_TABLE_SIZE)
	{
		cout << "Table Size Too Small" << endl;
		return NULL;
	}
	htable = new HashTable;
	if (htable == NULL)
	{
		cout << "Out of Space" << endl;
		return NULL;
	}
	htable->size = size;
	htable->table = new HashNode[htable->size];
	if (htable->table == NULL)
	{
		cout << "Table Size Too Small" << endl;
		return NULL;
	}
	for (int i = 0; i < htable->size; i++)
	{
		htable->table[i].info = Empty;
		htable->table[i].element = NULL;
	}
	return htable;
}
/*
* Function to Find Element from the table
*/
int Find(int key, HashTable *htable)
{	
	
	int colCount = 0;

	int hashVal = HashFunc1(key, htable->size);
	int stepSize = HashFunc2(key, htable->size);
	while (htable->table[hashVal].info != Empty &&
		htable->table[hashVal].element != key)
	{
		hashVal = hashVal + stepSize;
		hashVal = hashVal % htable->size;
		colCount++;
	}

	cout << colCount << " collision(s) with key " << key << " before operation\n" << endl;
	

	return hashVal;
}
/*
* Function to Insert Element into the table
*/
void Insert(int key, HashTable *htable)
{
	int pos = Find(key, htable);
	if (htable->table[pos].info != Legitimate)
	{
		htable->table[pos].info = Legitimate;
		htable->table[pos].element = key;
	}
}





int findLin(int key, HashTable *htable)
{
	int colCount = 0;
	int hashVal = HashFunc1(key, htable->size);
	int stepSize = 1;
	
	while (htable->table[hashVal].info != Empty  &&
		htable->table[hashVal].element != key)
	{	

		hashVal = hashVal + stepSize;
		hashVal = hashVal % htable->size;
		colCount++;
	}

	cout << colCount << " collision(s) with key " << key << " before operation\n" << endl;

	return hashVal;
}

void removeLin(int key, HashTable *htable){
	int pos = findLin(key, htable);
	if (htable->table[pos].info == Legitimate){
		htable->table[pos].info = Empty;
		htable->table[pos].element = (-1)*key;
	}

}


void linIns(int key, HashTable *htable)
{	
	
	int pos = findLin(key, htable);
	if (htable->table[pos].info != Legitimate)
	{
		htable->table[pos].info = Legitimate;
		htable->table[pos].element = key;
	}
}


/*
* Function to Rehash the table
*/
HashTable *Rehash(HashTable *htable)
{
	int size = htable->size;
	HashNode *table = htable->table;
	htable = initializeTable(2 * size);
	for (int i = 0; i < size; i++)
	{
		if (table[i].info == Legitimate)
			Insert(table[i].element, htable);
	}
	free(table);
	return htable;
}
/*
* Function to Retrieve the table
*/
void Retrieve(HashTable *htable)
{
	for (int i = 0; i < htable->size; i++)
	{
		int value = htable->table[i].element;
		if (!value)
			cout << "Position: " << i + 1 << " Element: Null" << endl;
		else
			cout << "Position: " << i + 1 << " Element: " << value << endl;
	}

}
/*
* Main Contains Menu
*/
int main()
{
	int value, size, pos, i = 1;
	int choice;
	int foo[9] = { 38, 15, 43, 22, 71, 8, 28, 37, 19 };
	HashTable *htable = new HashTable();
	while (1)
	{
		cout << "\n----------------------" << endl;
		cout << "Operations on Double Hashing" << endl;
		cout << "\n----------------------" << endl;
		cout << "1.Initialize size of the table" << endl;
		cout << "2.Insert element into the table" << endl;
		cout << "3.Display Hash Table" << endl;
		cout << "4.Rehash The Table" << endl;
		cout << "5.Exit" << endl;
		cout << "6. Double Hash Preset -- 352 Assignment Question 8" << endl;
		cout << "7. Linear Probe -- 352 Assignment Question 9" << endl;
		cout << "Enter your choice: ";
		cin >> choice;
		switch (choice)
		{
		case 1:
			cout << "Enter size of the Hash Table: ";
			cin >> size;
			htable = initializeTable(size);
			break;
		case 2:
			if (i > htable->size)
			{
				cout << "Table is Full, Rehash the table" << endl;
				continue;
			}
			cout << "Enter element to be inserted: ";
			cin >> value;
			Insert(value, htable);
			i++;
			break;
		case 3:
			Retrieve(htable);
			break;
		case 4:
			htable = Rehash(htable);
			break;
		case 5:
			exit(1);
		case 6:
			cout << "\nInitializing Hash Table with preset example" << endl;


			cout << "Size = 19" << endl;
			htable = initializeTable(19);

			

			for (int j = 0; j< 9; j++){


				if (i > htable->size)
				{
					cout << "Table is Full, Rehash the table" << endl;
					continue;
				}
				cout << "Inserting : " << foo[j] << "\n";
				Insert(foo[j], htable);
				i++;


			}

		
			break;


		case 7:
			cout << "\nInitializing Hash Table with preset example" << endl;


			cout << "Size = 19" << endl;
			htable = initializeTable(19);


			


				if (i > htable->size)
				{
					cout << "Table is Full, Rehash the table" << endl;
					continue;
				}
				cout << "Inserting : " << 29 << "\n";
				linIns(29, htable);				

				i++;

				cout << "Inserting : " << 53 << "\n";
				linIns(53, htable);

				i++;

				cout << "Inserting : " << 14 << "\n";
				linIns(14, htable);

				i++;

				cout << "Inserting : " << 95 << "\n";
				linIns(95, htable);

				i++;

				cout << "Removing : " << 53 << "\n";
				removeLin(53, htable);

				i--;

				cout << "Removing : " << 29 << "\n";
				removeLin(29, htable);

				i--;

				cout << "Inserting : " << 32 << "\n";
				linIns(32, htable);

				i++;

				cout << "Inserting : " << 19 << "\n";
				linIns(19, htable);

				i++;

				cout << "Removing : " << 14 << "\n";
				removeLin(14, htable);

				i--;
				
				cout << "Inserting : " << 30 << "\n";
				linIns(30, htable);

				i++;
				
				cout << "Inserting : " << 12 << "\n";
				linIns(12, htable);

				i++;

				cout << "Inserting : " << 72 << "\n";
				linIns(72, htable);

				i++;


			

		default:
			cout << "\nEnter correct option\n";
		}
	}
	return 0;
}