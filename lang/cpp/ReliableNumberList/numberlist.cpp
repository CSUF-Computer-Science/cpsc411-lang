#include "numberlist.h"

using namespace std;

void NumberList::add(double number)
{
    if (head == nullptr) {
        head = new ListNode(number);
    } else {
        ListNode *nodePtr = head;
        while (nodePtr->next != nullptr) {
            nodePtr = nodePtr->next;
        }
        nodePtr->next = new ListNode(number);
    }
}

void NumberList::displayList() const
{
    ListNode *nodePtr = head;
    while (nodePtr) {
        cout << nodePtr->value << " ";
        nodePtr = nodePtr->next;
    }
}

NumberList::~NumberList()
{
    ListNode *nodePtr = head;
    while (nodePtr != nullptr) {
        ListNode *garbage = nodePtr;
        nodePtr = nodePtr->next;
        delete garbage;
    }
}
