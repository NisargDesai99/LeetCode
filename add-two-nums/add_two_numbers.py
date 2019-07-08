

class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None


l1 = ListNode(2)
next = ListNode(4)
next_next = ListNode(3)
l1.next = next
l1.next.next = next_next


l2 = ListNode(5)
next = ListNode(6)
next_next = ListNode(4)
l2.next = next
l2.next.next = next_next


def add(l1, l2):

    carry = 0

    iter1 = l1
    iter2 = l2
    temp_node = None
    iter_res_list = None
    result_list = None

    if iter1 == None or iter2 == None:
        return

    while iter1 != None or iter2 != None:

        if iter1 == None:
            iter1 = ListNode(0)
        if iter2 == None:
            iter2 = ListNode(0)

        curr_sum = iter1.val + iter2.val + carry
        if curr_sum >= 10:
            curr_sum = curr_sum % 10
            carry = 1
        else:
            carry = 0
        
        temp_node = ListNode(curr_sum)
        if result_list == None:
            result_list = temp_node
        else:
            iter_res_list.next = temp_node
        
        iter_res_list = temp_node    
        
        iter1 = iter1.next
        iter2 = iter2.next
    
    if carry > 0:
        temp_node.next = ListNode(carry)
    
    return result_list


def print_linked_list(lst):
    if lst == None:
        return
    
    str_builder = ""
    while lst != None:
        str_builder += str(lst.val) + ", "
        lst = lst.next
    print(str_builder[0:-2])
    

# sum_list = add(l1,l2)
# print_linked_list(sum_list)

sum_list = add(ListNode(5), ListNode(5))
print_linked_list(sum_list)