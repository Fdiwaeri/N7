a = [8, 1, 4, 6]
b = [8, 1, 4, 6]
c = b
a is b # false
a == b # true
c is b # true
p, *m, d = a # p = 8, m = [1,4], d = 6, a = [8, 1, 4, 6]
len(a) # 4
a[-1] # 6
a[0] # 8
x = 'a'
s = str(x) # s = 'a'
r = repr(x) # r = "'a'"

# str("test\n") -> test
# repr("test\n") -> "test\n"