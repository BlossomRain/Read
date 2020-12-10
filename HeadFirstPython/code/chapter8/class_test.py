class A:
    def __init__(self, v: int = 0, i: int = 1):
        self.val = v
        self.incr = i

    def increase(self):
        self.val += self.incr

    def __repr__(self) -> str:
        return str(self.val)

import chapter9.DBcm
a = A(10, 2)
a.increase()
print(a)