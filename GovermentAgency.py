import time
import random

name = input("Hello, what is your name?")
time.sleep(2)

feeling = input("How are you today? ")
time.sleep(2)
if "good" in feeling.lower():
    print("Wow I feel the same way.")
elif "great" in feeling.lower():
    print("That's nice to know!")
else:
    print("Go ahaed and do something you love.")
    
    time.sleep(2)
    fave = input("What is your favorite color? ")
    colors = ["orange", "yellow", "pruple"]
    time.sleep(2)
    print(fave + " is cool! Mine is " + random.choice(colors) + ".")