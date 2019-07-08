

def longest_substr_len(s: str) -> int:
    
    curr_substr = {}
    max_len = -1
    curr_len = 0
    len_str = len(s)

    if len_str == 0: return 0

    for i in range(len_str):
        if s[i] in curr_substr:
            # curr_substr = {}
            curr_substr[s[i]] = 1
            if s[i-1] == s[i] and curr_len > 1:
                curr_len -= 1
            if curr_len > max_len:
                max_len = curr_len
        else:
            curr_substr[s[i]] = 1
            curr_len += 1

    return max(max_len, curr_len)


test_1 = "abcabcbb"
test_1_res = longest_substr_len(test_1)
print(test_1, test_1_res)

test_2 = "bbbbbb"
test_2_res = longest_substr_len(test_2)
print(test_2, test_2_res)

test_3 = "pwwkew"
test_3_res = longest_substr_len(test_3)
print(test_3, test_3_res)

test_4 = "dvdf"
test_4_res = longest_substr_len(test_4)
print(test_4, test_4_res)

test_5 = "aab"
test_5_res = longest_substr_len(test_5)
print(test_5, test_5_res)

test_6 = "ckilbkd"
test_6_res = longest_substr_len(test_6)
print(test_6, test_6_res)

