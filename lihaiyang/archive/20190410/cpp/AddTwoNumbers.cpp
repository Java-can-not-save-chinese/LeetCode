// AddTwoNumbers.cpp
// Author: hyan23
// 2019.03.03
// https://leetcode.com/problems/add-two-numbers/

// Runtime: 40 ms
// Best solution: 0 ms

#include <iostream>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution
{
  public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode *head = NULL, *l3 = NULL;
        int carry = 0;

        while (true)
        {
            if (l1 == NULL && l2 == NULL)
            {
                break;
            }

            if (head == NULL)
            {
                head = l3 = new ListNode(0);
            }
            else
            {
                l3->next = new ListNode(0);
                l3 = l3->next;
            }

            int sum = (l1 == NULL ? 0 : l1->val) +
                      (l2 == NULL ? 0 : l2->val) + carry;
            l3->val = sum % 10;
            carry = sum / 10;

            if (l1 != NULL)
            {
                l1 = l1->next;
            }
            if (l2 != NULL)
            {
                l2 = l2->next;
            }
        }
        if (carry != 0)
        {
            l3->next = new ListNode(carry);
        }
        return head;
    }
};

void printNumber(ListNode *list)
{
    if (list != NULL)
    {
        printNumber(list->next);
        cout << list->val;
    }
}

void destroyNumber(ListNode *list)
{
    if (list != NULL)
    {
        destroyNumber(list->next);
        list->next = NULL;
        delete list;
    }
}

int main(int argc, char *argv[])
{
    (void)argc;
    (void)argv;

    // ListNode *l1 = new ListNode(2);
    // l1->next = new ListNode(4);
    // l1->next->next = new ListNode(3);
    // ListNode *l2 = new ListNode(5);
    // l2->next = new ListNode(6);
    // l2->next->next = new ListNode(4);
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(9);
    ListNode *l2 = new ListNode(9);
    ListNode *l3 = Solution().addTwoNumbers(l1, l2);

    printNumber(l3);
    destroyNumber(l1);
    destroyNumber(l2);
    destroyNumber(l3);

    return 0;
}