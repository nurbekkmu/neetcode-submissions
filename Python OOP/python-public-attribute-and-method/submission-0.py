class StoreItem:
    def __init__(self, name:str, price:float):
        self.name = name
        self.price = price
        # print(f"Item: {self.name} - Price: ${self.price}")



chips = StoreItem("Chips", 1.99) # Don't modify this line

# TODO: Access the attributes of the chips object and display them
print(chips.name)
print(chips.price)