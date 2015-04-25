# Questions:
# 1. Are the duplicates next to each other or randomly distributed?
# 2. Is the head node a list node with value or just base node with None?

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head is not None:
            # init a base node pointing to head
            base = ListNode(None)
            # init previous, current and next links
            prelink = base
            curlink = head
            prelink.next = curlink
            nextlink = curlink.next
            dupl = False

            while nextlink is not None:
                if curlink.val == nextlink.val:
                    nextlink = nextlink.next
                    prelink.next = nextlink
                    dupl = True
                else:   
                    if dupl:
                        dupl = False
                    else:
                        prelink = curlink                        
                    curlink = nextlink
                    nextlink = nextlink.next
            return base.next

if __name__ == '__main__':
    head = ListNode(2)
    sec = ListNode(3)
    thd = ListNode(3)
    head.next = sec
    sec.next = thd

    test = Solution()
    newhead = test.deleteDuplicates(head)
    print newhead.val
    print newhead.next





        