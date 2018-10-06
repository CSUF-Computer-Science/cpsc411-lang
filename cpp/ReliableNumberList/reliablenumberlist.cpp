#include "reliablenumberlist.h"

ReliableNumberList::ReliableNumberList(const ReliableNumberList& original)
{
    head = copyList(original.head);
}

ReliableNumberList& ReliableNumberList::operator=(ReliableNumberList right)
{
    destroyList(head);
    head = copyList(right.head);
}

NumberList::ListNode *ReliableNumberList::copyList(ListNode *aList)
{
    if (aList == nullptr) {
        return nullptr;
    } else {
        ListNode *tailCopy = copyList(aList->next);
        return new ListNode(aList->value, tailCopy);
    }
}

void ReliableNumberList::destroyList(ListNode *aList)
{
    if (aList != nullptr) {
        ListNode *tail = aList->next;
        delete aList;
        destroyList(tail);
    }
}
