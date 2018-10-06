#include "numberlist.h"

class ReliableNumberList : public NumberList
{
    public:
        ReliableNumberList(const ReliableNumberList& original);
        ReliableNumberList() { }
        ReliableNumberList& operator=(ReliableNumberList right);

    private:
        static ListNode *copyList(ListNode *aList);
        static void destroyList(ListNode *aList);
};
