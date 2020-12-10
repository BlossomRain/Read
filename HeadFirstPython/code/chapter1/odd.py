import random
from datetime import datetime
import time

odds = [
    1, 3, 5, 7, 9, 11,
    13, 15, 17, 19, 21
]

right_this_minute = datetime.today().minute

if right_this_minute in odds:
    print("This minute seems a little odd")
else:
    print("Not a odd minute")

for i in range(5):
    print(i)
    time.sleep(1)
    random.randint(1, 100)
