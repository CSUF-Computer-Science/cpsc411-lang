#include "reliablenumberlist.h"

int main()
{
    ReliableNumberList squareList, cubeList;

    for (int k = 1; k <= 5; k++) {
        squareList.add(k * k);
        cubeList.add(k * k * k);
    }

    ReliableNumberList otherList(squareList);
    cout << "Result of the copy constructor is: ";
    otherList.displayList();
    cout << endl;

    otherList = cubeList;
    cout << "Result of assignment is: ";
    otherList.displayList();
    cout << endl;

    return 0;
}
