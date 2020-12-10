letters = ['a', 'b', 'c']

# letter = input("input a letter :")
# if letter in letters:
#     print(letter, " in the letters ...")
# 常用方法
letters.append('d')
print("append", letters)

letters.remove('a')
print("remove", letters)

letters.pop(2)
print("pop", letters)

letters.extend(['1', '2', '3'])
print("extend", letters)

letters.insert(0, 'a')
print("insert", letters)

print("".join(letters))
# 切片
letters = list("helloworld")
subLetter = letters[0:len(letters):3]
print(subLetter * 2, "a"*2)