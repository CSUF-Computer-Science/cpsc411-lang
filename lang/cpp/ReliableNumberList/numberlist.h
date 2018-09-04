#include <iostream>
using namespace std;

class NumberList
{
    protected:
        struct ListNode {
            double value;
            ListNode *next;
            ListNode(double value1, ListNode *next1 = nullptr)
            {
                value = value1;
                next = next1;
            }
        };
        ListNode *head;

    public:
        NumberList() { head = nullptr; }
        ~NumberList();
        void add(double number);
        void remove(double number);
        void displayList() const;
};
