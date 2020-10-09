

class Solution:
	def multiply(self, num1: str, num2: str) -> str:

		len_num1 = len(num1)
		len_num2 = len(num2)

		if len_num1 == 0 or len_num2 == 0:
			return "0"
		
		result = [0] * (len_num1 + len_num2)
		print('len(result):', len(result))

		return result



if __name__ == '__main__':
	tests = [("2", "3"), ("63", "12"), ("8", "5"), ("284", "746")]
	soln = Solution()

	for test in tests:
		print("num1 =", test[0], "num2 =", test[1], "result =", soln.multiply(test[0], test[1]))




